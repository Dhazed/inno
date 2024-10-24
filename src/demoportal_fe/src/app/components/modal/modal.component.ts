import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {
  @Input() isVisible = false;
  @Input() title = '';
  @Input() subTitle = '';
  @Input() modalWidth = '';
  @Output() close = new EventEmitter();

  closeModal() {
    this.close.emit();
  }  

}
