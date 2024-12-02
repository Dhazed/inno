import { Component, ElementRef, AfterViewInit, ViewChild, Renderer2 } from '@angular/core';
import { WebcamImage } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';
import { DocumentService } from '../../services/document.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-photo-page',
  templateUrl: './photo-page.component.html',
  styleUrl: './photo-page.component.css'
})
export class PhotoPageComponent implements AfterViewInit {
  @ViewChild('webcamElement') webcamElement: any;
  public screenWidth: number = window.innerWidth;
  public screenHeight: number = window.innerHeight;

  hideWebcam: boolean = false;
  isVisibleWebcamModal = false;
  webcamImageSrc: WebcamImage | null = null;
  private trigger: Subject<void> = new Subject<void>();

  constructor(
    private route: ActivatedRoute,
    private documentService: DocumentService,
    private renderer: Renderer2
  ) { }

  get triggerObservable(): Observable<void> {
    return this.trigger.asObservable();
  }
  ngAfterViewInit(): void {
    if (this.webcamElement && this.webcamElement.video) {
      const videoElement = this.webcamElement.video.nativeElement;
      if (videoElement) {
        this.renderer.setStyle(videoElement, 'object-fit', 'cover');
        this.renderer.setStyle(videoElement, 'height', '93vh');
      }
    }
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
  confirm() {
    if (this.webcamImageSrc) {
      const idMobileSession = this.route.snapshot.queryParamMap.get('idMobileSession');
      this.documentService.saveImageFromMobile({
        idMobileSession,
        mimeType: this.webcamImageSrc.imageAsDataUrl.split(',')[0],
        base64Photo: this.webcamImageSrc.imageAsBase64
      }).subscribe((response) => {
        if (window.top) {
          window.top.close();
        }
      })

    }
  }
}