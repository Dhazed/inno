import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../../services/document.service';
import { SelfQService } from '../../services/selfq.service';
import * as QRCode from 'qrcode';

@Component({
  selector: 'app-sbb-selfq-configurator',
  templateUrl: './sbb-selfq-configurator.component.html',
  styleUrls: ['./sbb-selfq-configurator.component.css']
})
export class SBBSelfqConfiguratorComponent implements OnInit {
  currentStep: number = 1;
  qrCodeImage: string = '';
  isEmailValid: boolean = true;
  email: string = '';
  urlQrCode: string = '';
  phoneNumber: string = '';
  flagLang: string = 'fi-gb'; // Imposta il valore iniziale
  countryPrefix: string = '+44'; // Imposta il prefisso iniziale
  
  steps: Array<{ name: string }> = [
    { name: 'Inserisci i tuoi dati' },
    { name: 'Inquadra QR code' }
  ];

  constructor(private documentService: DocumentService,
              private selfQService: SelfQService
  ) { }

  ngOnInit(): void {
  }
 
  updateFlagAndPrefix(flag: string, prefix: string) {
    this.flagLang = flag;
    this.countryPrefix = prefix;
  }

  goToStep2() {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (this.email === '' || this.phoneNumber === '' || !emailRegex.test(this.email)) {
     this.isEmailValid = false;
      return;
    } else {
      this.isEmailValid = true;
    }

    this.selfQService.startSelfQSSB(this.countryPrefix + this.phoneNumber, this.email).subscribe((res: any) => {  
      QRCode.toDataURL(res['customer-token'], (error, qrUrl) => {
        if (error) {
          console.error(error);
        } else {
          this.qrCodeImage = qrUrl;
          this.urlQrCode = res['customer-token'];
          this.currentStep = 2;   
          console.log('QR code link: ' + this.qrCodeImage);
        }
      });
    }); 
  }

  goToStep1() {
    this.currentStep = 1;
  }

}

