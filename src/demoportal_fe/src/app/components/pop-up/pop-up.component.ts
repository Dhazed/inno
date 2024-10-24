import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent {
  @Input() isVisible: boolean = false;
  @Input() title: string = '';
  @Input() subtitle: string = '';
  @Input() primaryButtonText: string = '';
  @Input() secondaryButtonText: string = '';
  @Input() customIcon: string = '';
  @Input() status: string = '';

  @Output() close = new EventEmitter<void>();
  @Output() primaryAction = new EventEmitter<void>();
  @Output() secondaryAction = new EventEmitter<void>();

  closePopUp(): void {
    this.close.emit();
  }

  primaryButtonClick(): void {
    this.primaryAction.emit();
  }

  secondaryButtonClick(): void {
    this.secondaryAction.emit();
  }
}