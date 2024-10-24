import { Component, ElementRef, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { WebcamImage } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';
import * as QRCode from 'qrcode';
import { DocumentService } from '../../services/document.service';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-file-uploader',
  templateUrl: './file-uploader.component.html',
  styleUrl: './file-uploader.component.css'
})
export class FileUploaderComponent {
  @Input() uploaderIndex: number = 1;
  @Input() hideWebcam: boolean = false;
  @Input() hideQr: boolean = false;
  @Output() onFileUploaded = new EventEmitter();

  isDragActive = false;
  isVisibleImageModal = false;
  isVisibleWebcamModal = false;
  imageSrc: any = undefined;
  webcamImageSrc: WebcamImage | null = null;;
  private trigger: Subject<void> = new Subject<void>();
  showFileUpload = false;
  showQRCode = false;
  qrCodeImage = '';
  originalfile: File | null = null;
  baseUrl = environment.apiUrl || 'http://localhost:8080/';
  constructor(private documentService: DocumentService) { }

  triggerQrCode() {
    console.log('Generazione QR code');
    const idMobileSession = this.generateSessionId();
    const url = this.baseUrl + `mobile-photo?idMobileSession=${idMobileSession}`;
    QRCode.toDataURL(url, (error, qrUrl) => {
      if (error) {
        console.error('Errore nella generazione del QR code:', error);
      } else {
        this.qrCodeImage = qrUrl;
        this.showQRCode = true;
        this.documentService.saveMobileSession({ idMobileSession }).subscribe((response: any) => {
          this.imageSrc = response.mimeType + ',' + response.b64Content;
          this.onFileUploaded.emit({ imageSrc: this.imageSrc, uploaderIndex: this.uploaderIndex, originalfile: this.originalfile ? this.originalfile : { name: 'webcam_capture_' + this.uploaderIndex + '.jpg' } });

          this.isVisibleImageModal = false;
          this.isVisibleWebcamModal = false;
          this.imageSrc = undefined;
          this.showFileUpload = false;
          this.removeQrCode();
        });
      }
    });
  }

  generateSessionId(): string {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      const r = Math.random() * 16 | 0
      let v = c === 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }
  removeQrCode() { 
    this.showQRCode = false;
    this.qrCodeImage = '';
    this.documentService.stopSaveMobileSession();

  }

  confirm() {
    this.onFileUploaded.emit({ imageSrc: this.imageSrc || this.webcamImageSrc?.imageAsDataUrl, uploaderIndex: this.uploaderIndex, originalfile: this.originalfile ? this.originalfile : { name: 'webcam_capture_' + this.uploaderIndex + '.jpg' } });
    this.closeModal();
  }

  closeModal() {
    this.isVisibleImageModal = false;
    this.isVisibleWebcamModal = false;
    this.imageSrc = undefined;
    this.showFileUpload = false;
    this.removeQrCode();
  }
  removeFile() {
    this.imageSrc = undefined;
    this.showFileUpload = true;
  }
  get triggerObservable(): Observable<void> {
    return this.trigger.asObservable();
  }
  triggerWebcam() {
    this.isVisibleWebcamModal = true;
  }
  handleImage(webcamImage: WebcamImage): void {
    this.webcamImageSrc = webcamImage;
  }
  triggerSnapshot(): void {
    this.trigger.next();
  }
  removeSnapshot() {
    this.webcamImageSrc = null;
  }

  triggerFileUpload(isInner: boolean = false) {
    let elementClass = '';
    if (isInner) {
      elementClass = 'ic1-file-upload-inner';
    } else if (this.uploaderIndex >= 0) {
      elementClass = 'ic1-file-upload-' + this.uploaderIndex;
    }
    const fileInput = document.getElementById(elementClass) as HTMLInputElement;
    fileInput.click();
  }

  onFileDrop(event: DragEvent) {
    event.preventDefault();
    this.isDragActive = false;
    const files = event.dataTransfer?.files;
    if (files && files.length > 0) {
      this.handleFileInput(files);
      this.isVisibleImageModal = true;
    }
  }

  onDragOver(event: DragEvent) {
    event.preventDefault();
    this.isDragActive = true;
  }
  onDragLeave(event: DragEvent) {
    this.isDragActive = false;
  }

  onFileSelected(event: Event, uploaderNr: string = '') {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.isVisibleImageModal = true;
      this.handleFileInput(input.files);
      if (uploaderNr == '2') {
        this.showFileUpload = false;
      }
    }
    input.value = '';
  }
  handleFileInput(files: FileList) {
    this.originalfile = files[0];
    if (this.originalfile) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageSrc = e.target?.result;
      };
      reader.readAsDataURL(this.originalfile);
    }
  }
}


