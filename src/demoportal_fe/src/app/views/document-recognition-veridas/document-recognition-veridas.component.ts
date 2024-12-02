import { AfterViewInit, ChangeDetectorRef, Component, TemplateRef, ViewChild } from '@angular/core';
import { DocumentService } from '../../services/document.service';

@Component({
  selector: 'app-document-recognition-veridas',
  templateUrl: './document-recognition-veridas.component.html',
  styleUrl: './document-recognition-veridas.component.css'
})
export class DocumentRecognitionVeridasComponent implements AfterViewInit {
  @ViewChild('tabContent1', { static: false }) tabContent1!: TemplateRef<any>;
  @ViewChild('tabContent2', { static: false }) tabContent2!: TemplateRef<any>;
  @ViewChild('tabContent3', { static: false }) tabContent3!: TemplateRef<any>;

  veridasDocResult: any = null;
  showFileUploaders: Array<boolean> = [true, true]
  imageSrcs: Array<any> = [];
  originalfiles: Array<any> = [];

  docNationalitySelected = '';
  docTypeSelected = '';

  tabs: { title: string; content: TemplateRef<any> }[] = [];

  constructor(private documentService: DocumentService, private cdRef: ChangeDetectorRef) {

  }
  get displayFields(): { label: string; value: string }[] {
    if (this.veridasDocResult && this.veridasDocResult.extractedData) {
      const extractedData = this.veridasDocResult.extractedData;
      const personData = extractedData.personData || {};
      const identityDocumentData = extractedData.identityDocumentData || {};
      const addressData = extractedData.addressData || {};

      const combinedData = {
        ...personData,
        ...identityDocumentData,
        ...addressData
      };

      return Object.entries(combinedData)
        .map(([key, val]) => {
          const fieldValue = val ? String(val) : '-';
          return { label: key, value: fieldValue };
        })
        .filter(field => field.value !== '-');
    } else {
      return [];
    }
  }
  onSelectedNationality(nation: any) {
    this.docNationalitySelected = nation.value;
    this.itemsDocTypesToShow = this.itemsDocTypes.filter(item => item.nationCode === nation.value);
  }
  onSelectedDocType(doc: any) {
    this.docTypeSelected = doc.value;
  }
  ngAfterViewInit() {
    this.tabs = [
      { title: 'I tuoi dati personali', content: this.tabContent1 },
      { title: 'Risultato', content: this.tabContent2 },
      { title: 'Json', content: this.tabContent3 },
    ];
    this.cdRef.detectChanges()
  }
  onFileUpload(file: any) {
    this.showFileUploaders[file.uploaderIndex] = false;
    this.imageSrcs[file.uploaderIndex] = file.imageSrc;
    this.originalfiles[file.uploaderIndex] = file.originalfile;
  }
  removeFile(index: number) {
    this.imageSrcs[index] = undefined;
    this.showFileUploaders[index] = true;
  }

  verifyIdentity() {
    this.documentService.veridasDocVerify(
      {
        "channel": "DEMO_VE",
        "requestId": "request-12345",
        "document": {
          "images": [
            {
              "name": "front",
              "base64Content": this.imageSrcs[0].replace(/^data:image\/[^;]+;base64,/, ''),
              "mimeType": this.imageSrcs[0].match(/^data:(.*?);base64,/)[1]
            },
            {
              "name": "back",
              "base64Content": this.imageSrcs[1].replace(/^data:image\/[^;]+;base64,/, ''),
              "mimeType": this.imageSrcs[1].match(/^data:(.*?);base64,/)[1]
            }
          ]
        },
        "options": {}
      }).subscribe((response) => {
        if (response) {
          this.veridasDocResult = response;
        }
      })

  }

  itemsDocNationalities = [
    { label: 'Austria', value: 'AUT' },
    { label: 'Bulgaria', value: 'BGR' },
    { label: 'Belgio', value: 'BEL' },
    { label: 'Bosnia ed Erzegovina', value: 'BIH' },
    { label: 'Colombia', value: 'COL' },
    { label: 'Croazia', value: 'HRV' },
    { label: 'Cipro', value: 'CYP' },
    { label: 'Cechia', value: 'CZE' },
    { label: 'Estonia', value: 'EST' },
    { label: 'Finlandia', value: 'FIN' },
    { label: 'Francia', value: 'FRA' },
    { label: 'Germania', value: 'DEU' },
    { label: 'Ungheria', value: 'HUN' },
    { label: 'Irlanda', value: 'IRL' },
    { label: 'Italia', value: 'ITA' },
    { label: 'Lettonia', value: 'LVA' },
    { label: 'Liechtenstein', value: 'LIE' },
    { label: 'Lituania', value: 'LTU' },
    { label: 'Lussemburgo', value: 'LUX' },
    { label: 'Malta', value: 'MLT' },
    { label: 'Moldavia', value: 'MDA' },
    { label: 'Paesi Bassi', value: 'NLD' },
    { label: 'Perù', value: 'PER' },
    { label: 'Polonia', value: 'POL' },
    { label: 'Portogallo', value: 'PRT' },
    { label: 'Romania', value: 'ROU' },
    { label: 'Serbia', value: 'SRB' },
    { label: 'Slovacchia', value: 'SVK' },
    { label: 'Slovenia', value: 'SVN' },
    { label: 'Spagna', value: 'ESP' },
    { label: 'Svezia', value: 'SWE' },
    { label: 'Svizzera', value: 'CHE' },
    { label: 'Inghilterra', value: 'GBR' }
  ];
  itemsDocTypes = [
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'BGR' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'AUT' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'BEL' },
    { label: 'Id card', value: 'ID CARD', nationCode: 'BIH' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'COL' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'HRV' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'CYP' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'CZE' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'EST' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'FIN' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'FRA' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'DEU' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'HUN' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'IRL' },
    { label: 'Driver license', value: 'DRIVER LICENSE', nationCode: 'ITA' },
    { label: 'Health ins card', value: 'HEALTH INS CARD', nationCode: 'ITA' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'ITA' },
    { label: 'Old electronic id card', value: 'OLD ELECTRONIC ID CARD', nationCode: 'ITA' },
    { label: 'Old paper id card', value: 'OLD PAPER ID CARD', nationCode: 'ITA' },
    { label: 'Passport', value: 'PASSPORT', nationCode: 'ITA' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'LVA' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'LIE' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'LTU' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'LUX' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'MLT' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'MDA' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'NLD' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'NLD' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'PER' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'POL' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'PRT' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'ROU' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'SRB' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'SVK' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'SVN' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'ESP' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'SWE' },
    { label: 'Identity card', value: 'IDENTITY CARD', nationCode: 'CHE' },
    { label: 'Driver license', value: 'DRIVER LICENSE', nationCode: 'GBR' },
    { label: 'Passport', value: 'PASSPORT', nationCode: 'GBR' }
  ]

  itemsDocTypesToShow: any = [];
}

