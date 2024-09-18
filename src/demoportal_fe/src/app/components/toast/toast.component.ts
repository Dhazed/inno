import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-toast',
  templateUrl: './toast.component.html',
  styleUrl: './toast.component.css'
})
export class ToastComponent {
  @Input() type: string = 'info'
  @Input() title: string = ''
  @Input() text: string = ''
  @Input() hideClose: boolean = false
}
