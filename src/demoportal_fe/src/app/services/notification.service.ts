import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private modalSubject = new BehaviorSubject<{ message: string, type: string } | null>(null);
  loading$ = this.modalSubject.asObservable();
  private notificationSubject = new BehaviorSubject<{ message: string, type: string } | null>(null);
  notification$ = this.notificationSubject.asObservable();
  
  showNotification(message: string, type: string) {
    this.notificationSubject.next({ message, type });
    setTimeout(() => {
      this.hideNotification();
    }, 5000);
  }
  
  hideNotification() {
    this.notificationSubject.next(null);
  }

  showModal(message: string, type: string) {
    this.modalSubject.next({ message, type });
  }

  hideModal() {
    this.modalSubject.next(null);
  }
}
