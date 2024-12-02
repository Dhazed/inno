import { Component, OnInit, OnDestroy, Self } from '@angular/core';
import { DocumentService } from '../../services/document.service';
import { OnboardingWidgetService } from '../../services/onboarding-widget.service';
import { WebSocketService } from '../../services/web-socket.service';
import { environment } from '../../../environments/environment';
import * as QRCode from 'qrcode';
import { SelfQService } from '../../services/selfq.service';

@Component({
  selector: 'app-on-widget-configurator',
  templateUrl: './on-widget-configurator.component.html',
  styleUrls: ['./on-widget-configurator.component.css']
})
export class OnWidgetConfiguratorComponent implements OnInit, OnDestroy {
  currentStep: any = 1;
  qrCodeImage: string = '';
  steps: Array<{ name: string }> = [
    { name: 'Configura il widget' },
    { name: 'Inquadra QR code' }
  ];

  categories: Array<{ label: string; value: any }> = [
    { label: 'CUSTOM UI', value: 'CUSTOM UI' },
    { label: 'STANDARD UI', value: 'STANDARD UI' }
  ];
  types: Array<{ label: string; value: any }> = [
    { label: 'DOCUMENT VALIDATION ONLY', value: 'DOCUMENT VALIDATION ONLY' },
    { label: 'SELF IDENTIFICATION ONLY', value: 'SELF IDENTIFICATION ONLY' },
    { label: 'SELF IDENTIFICATION + AES', value: 'SELF IDENTIFICATION + AES' },
    { label: 'SELF IDENTIFICATION + QES', value: 'SELF IDENTIFICATION + QES' }
  ];
  livenessTypes: Array<{ label: string; value: any }> = [
    { label: 'LIGHT', value: 'LIGHT' },
    { label: 'ACTIVE', value: 'ACTIVE' },
    { label: 'ADVANCED', value: 'ADVANCED' }
  ];
  selectedCategory: any = { label: '', value: '' };
  selectedType: any = { label: '', value: '' };
  selectedLivenessType: any = { label: '', value: '' };
  selectedPreset: Array<string> = [];

  presets: { [key: string]: { [key: string]: { [key: string]: string[] } | string[] } } = {
    'CUSTOM UI': {
      'DOCUMENT VALIDATION ONLY': ['P_ONBWG_DEMOPORTAL_DOC_VALIDATION_ONLY', 'DMPC_INFOCERT'],
      'SELF IDENTIFICATION ONLY': {
        'LIGHT': ['P_ONBWG_DEMOPORTAL_LIGHT', 'DMPC_INFOCERT'],
        'ACTIVE': ['P_ONBWG_DEMOPORTAL_ACTIVE', 'DMPC_INFOCERT'],
        'ADVANCED': ['P_ONBWG_DEMOPORTAL_ADVANCED', 'DMPC_INFOCERT']
      },
      'SELF IDENTIFICATION + AES': {
        'LIGHT': ['P_ONBWG_DEMOPORTAL_LIGHT', 'DMPC_INFOCERT'],
        'ACTIVE': ['P_ONBWG_DEMOPORTAL_ACTIVE', 'DMPC_INFOCERT'],
        'ADVANCED': ['P_ONBWG_DEMOPORTAL_ADVANCED', 'DMPC_INFOCERT']
      },
      'SELF IDENTIFICATION + QES': { 'ADVANCED': ['BMEDBIO_DEMOPORTAL_LIVE_ADVANCED', 'DMPC_INFOCERT'] }
    },
    'STANDARD UI': {
      'DOCUMENT VALIDATION ONLY': ['SELF_DOCVALIDATION_ONLY', 'DMPC_INFOCERT'],
      'SELF IDENTIFICATION ONLY':  {
        'LIGHT': ['SELF_ID_ONLY_LIVE_LIGHT', 'DMPC_INFOCERT'],
        'ACTIVE': ['SELF_ID_ONLY_LIVE_ACTIVE', 'DMPC_INFOCERT'],
        'ADVANCED': ['SELF_ID_ONLY_LIVE_ADVANCED', 'DMPC_INFOCERT']
      },
      'SELF IDENTIFICATION + AES': {
        'LIGHT': ['SELF_ID_AES_LIVE_LIGHT', 'DMPC_INFOCERT'],
        'ACTIVE': ['SELF_ID_AES_LIVE_ACTIVE', 'DMPC_INFOCERT'],
        'ADVANCED': ['SELF_ID_AES_LIVE_ADVANCED', 'DMPC_INFOCERT']
      },
      'SELF IDENTIFICATION + QES': { 'ADVANCED': ['SELF_ID_QES', 'DMPC_INFOCERT'] }
    }
  };

  constructor(private documentService: DocumentService,
    private selfqService: SelfQService,
    private onWidgetService: OnboardingWidgetService,
    private webSocketService: WebSocketService,
  ) { }

  ngOnInit(): void { }

  ngOnDestroy() {
    // this.disconnectSocket();
  }

  onCategoryChange(category: { label: string; value: any }) {
    this.selectedCategory = category;
    this.selectedType = { label: '', value: '' };
    this.selectedLivenessType = { label: '', value: '' };
    this.selectedPreset = [];
  }

  onTypeChange(type: { label: string; value: any }) {
    this.selectedType = type;
    this.selectedLivenessType = { label: '', value: '' };
    this.selectedPreset = [];
    if (type.value === 'DOCUMENT VALIDATION ONLY') {
      this.selectedPreset = this.presets[this.selectedCategory.value][this.selectedType.value] as string[];
    } else if (type.value === 'SELF IDENTIFICATION + QES') {
      this.selectedLivenessType = { label: 'ADVANCED', value: 'ADVANCED' };
      this.selectedPreset = (this.presets[this.selectedCategory.value][this.selectedType.value] as { [key: string]: string[] })['ADVANCED'];
    }
  }

  onLivenessTypeChange(livenessType: { label: string; value: any }) {
    this.selectedLivenessType = livenessType;
    this.selectedPreset = (this.presets[this.selectedCategory.value][this.selectedType.value] as { [key: string]: string[] })[this.selectedLivenessType.value];
  }

  goToStep2() {
    console.log('Generazione QR code');
    if (this.selectedCategory.value == 'STANDARD UI') {
      this.selfqService.startSelfQ({ phoneNumber: '+393356426591', email: 'paolo.manzi@infocert.it', lang: 'it', dossierType: this.selectedPreset[0] }).subscribe((response: any) => {
        console.log('URL: ', response.tokens);
        QRCode.toDataURL(response.tokens, (err, url) => {
          if (err) {
            console.error(err);
            return;
          }
          this.qrCodeImage = url;
          this.currentStep = 2;
        });
      });
    } else {
      this.onWidgetService.getOnWidgetToken(this.selectedPreset).subscribe((response: any) => {
        const url = `${window.location.origin}/mobile-onboarding-widget?sessionId=${response.sessionId}`;
        console.log('URL: ', url);
        QRCode.toDataURL(url, (err, url) => {
          if (err) {
            console.error(err);
            return;
          }
          this.qrCodeImage = url;
          this.currentStep = 2;
        });
      })
    }

  }

  goToStep1() {
    this.currentStep = 1;
  }
}