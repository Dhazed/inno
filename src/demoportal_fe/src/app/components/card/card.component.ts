import { trigger, state, style, transition, animate } from '@angular/animations';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.css',
})
export class CardComponent {
  @Input() isActive = false; 
  @Input() title = ''; 
  @Input() text = ''; 
  @Input() buttonLabel = ''; 
  @Input() cardImage = ''; 
  @Input() content = ''; 
  @Input() cssClasses = ''; 



}
