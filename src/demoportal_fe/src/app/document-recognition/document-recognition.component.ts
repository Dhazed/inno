import { AfterViewInit, ChangeDetectorRef, Component, TemplateRef, ViewChild } from '@angular/core';
import { DocumentService } from '../services/document.service';

@Component({
  selector: 'app-document-recognition',
  templateUrl: './document-recognition.component.html',
  styleUrl: './document-recognition.component.css'
})
export class DocumentRecognitionComponent implements AfterViewInit {
  @ViewChild('tabContent1', { static: false }) tabContent1!: TemplateRef<any>;
  @ViewChild('tabContent2', { static: false }) tabContent2!: TemplateRef<any>;
  @ViewChild('tabContent3', { static: false }) tabContent3!: TemplateRef<any>;

  aiDocIdCardResult: any = null;
  showFileUploaders: Array<boolean> = [true, true]
  imageSrcs: Array<any> = [];
  originalfiles: Array<any> = [];

  docNationalitySelected = '';
  docTypeSelected = '';

  tabs: { title: string; content: TemplateRef<any> }[] = [];

  constructor(private documentService: DocumentService, private cdRef: ChangeDetectorRef) {

  }
  get displayFields(): { label: string; value: string }[] {
    if (this.aiDocIdCardResult && this.aiDocIdCardResult.documents.length > 0) {
      return Object.entries(this.aiDocIdCardResult.documents[0]['document-data'])
        .map(([key, val]) => {
          const fieldValue = (val as { value: string }).value || '-';
          return { label: key, value: fieldValue };
        })
        .filter(field => field.value !== '-');
    } else {
      return [];
    }
  }
  onSelectedNationality(nation: any) {
    this.docNationalitySelected = nation.value;
    this.itemsDocTypesToShow =this.itemsDocTypes.filter(item => item.nationCode === nation.value);
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
    this.documentService.aiDocIdCard(this.imageSrcs, this.docNationalitySelected, this.docTypeSelected)
    .subscribe((response) => {
        if (response?.documents?.length > 0) {
          this.aiDocIdCardResult = response;
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

