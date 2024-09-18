import { Component } from '@angular/core';
import { WebcamImage } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-file-uploader',
  templateUrl: './file-uploader.component.html',
  styleUrl: './file-uploader.component.css'
})
export class FileUploaderComponent {
  isVisibleImageModal = false;
  isVisibleWebcamModal = false;
  imageSrc: any;
  webcamImage: WebcamImage | null = null;
  private trigger: Subject<void> = new Subject<void>();
  isVisible = false;
  showFileUpload = false;

  constructor () {}

  confirm() {}

  closeModal() {
    this.isVisibleImageModal = false;
    this.isVisibleWebcamModal = false;
    this.imageSrc = undefined;
    this.showFileUpload = false;
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
    this.webcamImage = webcamImage;
  }
  triggerSnapshot(): void {
    this.trigger.next();
  }
  triggerFileUpload(uploaderNr: string = '') {
    const elementClass = uploaderNr ? 'ic1-file-upload-' + uploaderNr : 'ic1-file-upload';
    const fileInput = document.getElementById(elementClass) as HTMLInputElement;
    fileInput.click();
    
  }

  onFileDrop(event: DragEvent) {
    event.preventDefault();
    const files = event.dataTransfer?.files;
    if (files && files.length > 0) {
      this.handleFileInput(files);
    }
  }

  onDragOver(event: DragEvent) {
    event.preventDefault();
  }

  onDragLeave(event: DragEvent) {
  }

  removeSnapshot() {
    this.webcamImage = null;
  }

  onFileSelected(event: Event, uploaderNr: string = '') {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.isVisibleImageModal = true;
      this.handleFileInput(input.files);
      if (uploaderNr == '2')  {
        this.showFileUpload = false;
      }
    }
    input.value = '';
  }

  handleFileInput(files: FileList) {
    const file = files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.imageSrc = e.target?.result; 
      };
      reader.readAsDataURL(file);
    }
  }
}
 

