import { Component, ElementRef, AfterViewInit, ViewChild, Renderer2 } from '@angular/core';
import { WebcamImage } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';
import { DocumentService } from '../services/document.service';
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
    /*  if () {} */

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
        //mimeType: 'data:image/png;base64',
        mimeType: this.webcamImageSrc.imageAsDataUrl.split(',')[0],
        base64Photo: this.webcamImageSrc.imageAsBase64
        //base64Photo: 'iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAIAAAB7GkOtAAANH0lEQVR4nOzXi68edH3HcToO0B2UsnKphcpWtRAu9dKeiLBaZ4sodqvoEOQyAs0GmZiJwKjYsUuFFYqMjCowY1egwUNdY4qFNoIyqMV4Sq1dL8SsteLWUmet0IaorWvdX/FJlnxerz/g8zs5T57nne/A2+/8yhFJTw++Et1/16kTovs3jzsnuj888c7o/tTnD0b39057Ibq/cvPF0f098waj+zPe+q/R/VfHDkf3J3/slOj+H9yxObr/v199KLq/Y/Dk6P7AB78a3f+d6DoA/28JAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAz/5l0ujD0zftjG6/9rwqdH9JWNnRffP/PC3ovufO2t0dP/yw6dH93f/w73R/YevvTi6/+Il26P7e7fcEt0/974vRPffcMw7o/v79j4Z3T9mXvb354s/vz667wIAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEqNGr3sr6IPnDN0XXb/Az+L7m+asii6P7zkF9H9a8dfFd1/Zt3V0f0LHroruv/4TSdF93cPz4zuf33CD6P7E//ylOj+0Jbs5/uJ2+6J7k85bUF0/8fnfSe67wIAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoNnPDt+6MP/MeyGdH9lY8diu6v239jdH/htGej+yd+aFZ0f/djN0f3h+avju5//+5/ju4vvGxOdH/xcYej+49e+GJ0/8DOc6L7v9q7LLp/0tDG6P7+h/dE910AAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAECpgfnzLog+8IsLnoruP/iDBdH9c8/42+j+xFkfie7v3zspur/6go9H9y977F3R/XuXj43un3HUxOj+e4dOj+7/aM5J0f3fv//E6P6p5++O7h/z+vHR/ZOXHB3ddwEAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKVGbVjwmegD0+85GN3f9OZl0f0Xplwf3X/2r1+I7t8+eEx0/671O6L79287Mbq/67UPR/e3//uXovufOvpQdP+BO9ZF9/evXB3dn/uO8dH9GVNHR/cPv/W16L4LAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoNTB638+iD+x6Ym90/66x34ruX3vT/uj+HR99Jbq/cM746P65//2N6P5t4xZE98fNOCG6/4WRv4juT5z8cnT/O1dsi+5/96rs78/A2aui+6Mu+qPo/oHrFkb3XQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQKmB/S89F31g5IrPRff/6/PbovuPD14f3f/pH2YbfOvohdH9rd/fG90/+cFV0f3V79sT3b/l8jOi+xtm3B7d33PmvOj+lJk3RPd3L745un/4ud+L7r/x5ez/xwUAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQatWD4vugDP5mwJrp/zVeOj+7PPuLd0f0xr49E94fO/2l0f83x26P7n96+Mbp/3Nz3Rfc3fPHL0f0bx90T3Z//sU9E9w9P2xzdn/zJ8dH9oaufju5/7eu/ie67AABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUqP++ISZ0Qc+8unp0f0VM++L7q+adVZ0f/nST0b373///Oj+NVfMie5/97TZ0f3BmYPR/T+78u3R/VnX/ya6f/ovj4zun/WPv4ruPzMn+/395TO/je4vnveW6L4LAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoNWrRm/ZFH3h2/Zbo/qLTl0b33zRlU3T/e5Nuiu5fsmdsdH/ngZei+0/tuTW6f+Pxj0f3r/za+dH9PVuPi+6/svWi6P6kVedF98+78JLo/vNXPh3df/T290f3XQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQKmBH9/7nugDayeOie4ve3JqdP/uD06I7j856Zro/vz1D0f3x905Prp/wxmfje6/cXhTdP+W2aOj+y+fe3V0/z07/i66f+ncXdH9kUWLovu7RtZG93c89evovgsAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACg18MDbDkUfOOvII6P70x/ZF90fmvxP0f2RSVOi+xOPend0/73HzonuL5g9Obo/aeSU6P7i2c9F9+f/+cro/kmXLo/uf/t/lkT3X9/5+ej+PX//luj+mQOTovsuAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACg1MC282+PPrDkls3R/VmHFkX3p122Mbq/dv2PovsbFh6O7h916Zei+1esmRvdn3POmOj+g8dm//7F3/hBdH/udc9H9z90zUej+/ddlf3+Ll/9zej+lM9eFN13AQCUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApUZNf/G86AOTf/el6P7SwaXR/avmH4zur5jwhuj+tFf/Jrr/yCNrovs3feaJ6P7DO1ZG9w8s/3V0/4kPnB3dP3buadH9FetviO7vu/VPo/tHj9wW3Z964dui+y4AgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKDUwAnfvDz6wNo/eTS6/+qb10X3777woej+EUecHF2/eMzB6P7wit9G99/5b1+O7r/j7MXR/f/csjy6/8idP4/uP7D9U9H9dR/fGt3/3tJD0f1xY6ZG93fO/GF03wUAUEoAAEoJAEApAQAoJQAApQQAoJQAAJQSAIBSAgBQSgAASgkAQCkBACglAAClBACglAAAlBIAgFICAFBKAABKCQBAKQEAKCUAAKUEAKCUAACUEgCAUgIAUEoAAEoJAEApAQAoJQAApQQAoJQAAJT6vwAAAP//nUd7qUr7up0AAAAASUVORK5CYII='
      }).subscribe((response) => {
        if (window.top) {
          window.top.close();
        }
      })

    }
  }
}