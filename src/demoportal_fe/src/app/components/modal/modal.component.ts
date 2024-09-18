import { Component, EventEmitter, Input, Output } from '@angular/core';
import { WebcamImage } from 'ngx-webcam';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {
  @Input() isVisible = false;
  @Input() title = '';
  @Input() subTitle = '';
  @Output() close = new EventEmitter();

  closeModal() {
    this.close.emit();
  }  

}
