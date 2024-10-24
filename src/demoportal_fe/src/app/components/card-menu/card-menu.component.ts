import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-menu',
 
  templateUrl: './card-menu.component.html',
  styleUrl: './card-menu.component.css'
})
export class CardMenuComponent {
  @Input() isActive = false; 
  @Input() title = '';
  @Input() text = '';
  @Input() icon = '';
  @Input() isNewCard = false;

}
