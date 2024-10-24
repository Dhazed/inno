import { AfterViewInit, ChangeDetectorRef, Component, TemplateRef, ViewChild } from '@angular/core';
import { DocumentService } from '../services/document.service';

@Component({
  selector: 'ai-face-matching',
  templateUrl: './ai-face-matching.component.html',
  styleUrl: './ai-face-matching.component.css'
})
export class AiFaceMatchingComponent implements AfterViewInit {
  @ViewChild('tabContent1', { static: false }) tabContent1!: TemplateRef<any>;
  @ViewChild('tabContent2', { static: false }) tabContent2!: TemplateRef<any>;
  @ViewChild('tabContent3', { static: false }) tabContent3!: TemplateRef<any>;

  afmCompareResult: any = null;
  matchResult: any = {};
  showFileUploaders: Array<boolean> = [true, true];
  imageSrcs: Array<any> = [];
  originalfiles: Array<any> = [];

  tabs: { title: string; content: TemplateRef<any> }[] = [];

  constructor(private documentService: DocumentService, private cdr: ChangeDetectorRef) { }

  get displayFields(): { label: string; value: string }[] {
    if (this.afmCompareResult && this.afmCompareResult.results.length > 0) {
      return Object.entries(this.afmCompareResult.results[0])
        .map(([key, val]) => {
          return { label: key, value: val as string || '-' };
        })
        .filter(field => field.value !== '-');
    } else {
      return [];
    }
  }

  ngAfterViewInit() {
    this.tabs = [
      { title: 'Risultato', content: this.tabContent2 },
      { title: 'Json', content: this.tabContent3 },
    ];
    this.cdr.detectChanges(); // Forza il rilevamento delle modifiche
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
    this.documentService.afmCompare(
      {
        "request-id": "request-12345",
        "images": [
          {
            "image-id": "document_01",
            "description": "document_01.jpg",
            "content": this.imageSrcs[0].replace('data:image/jpeg;base64,', '').replace('data:image/png;base64,', '')
          },
          {
            "image-id": "document_02",
            "description": "document_02.jpg",
            "content": this.imageSrcs[1].replace('data:image/jpeg;base64,', '').replace('data:image/png;base64,', '')
          }
        ],
        "options": {}
      }).subscribe((response) => {
        if (response && response.results && response.results.length > 0) {
          this.afmCompareResult = response;
        }
      });
  }
}