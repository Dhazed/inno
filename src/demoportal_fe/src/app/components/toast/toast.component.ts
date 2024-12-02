import { Component, Input } from '@angular/core';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-toast',
  templateUrl: './toast.component.html',
  styleUrl: './toast.component.css'
})
export class ToastComponent {
  @Input() type: string | undefined | null = 'info'
  @Input() title: string | undefined | null= ''
  @Input() text: string | undefined | null = ''
  @Input() hideClose: boolean = false

  constructor(private notificationService: NotificationService) { } 

  closeToast() {
    this.notificationService.hideNotification();
  }
}
