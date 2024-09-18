import { trigger, transition, query, stagger, style, animate, state } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'app-landing-3',  
  templateUrl: './landing-3.component.html',
  styleUrl: './landing-3.component.css',
  animations: [
    trigger('slideInFromTop', [
      transition(':enter', [
        query('.card-container', [
          style({ opacity: 0, transform: 'translateY(-100%)' }),
          stagger(200, [
            animate('0.5s ease-out', style({ opacity: 1, transform: 'translateY(0)' }))
          ])
        ], { optional: true })
      ])
    ]),
    trigger('slideInService', [
      transition(':enter', [
        style({ opacity: 0, transform: 'translateX(-100%)' }), // Stato iniziale (fuori schermo in alto)
        animate('0.5s ease-out', style({ opacity: 1, transform: 'translateY(0)' })) // Animazione di apparizione
      ]),
      // Animazione quando l'elemento esce
      transition(':leave', [
        animate('0.5s ease-in', style({ opacity: 0, transform: 'translateY(-100%)' })) // Animazione di uscita
      ])
    ]),
    trigger('slideInFromLeft', [
      transition(':enter', [
        query('.ic1-col-12, #diamond-shield, #trapezoid', [
          style({ opacity: 0, transform: 'translateX(-100%)' }), 
          stagger(200, [ 
            animate('0.5s ease-out', style({ opacity: 1, transform: 'translateX(0%)' }))
          ])
        ], { optional: true })
      ])
    ])
  ]
})
export class Landing3Component {
  activeService = '1'
  title = 'Prova i prodotti InfoCert (3)';
  description = 'Seleziona una categoria per visualizzare i prodotti associati';
  typedTitle = '';
  typedDescription = '';
  titleIndex = 0;
  descriptionIndex = 0;
  showDescription = false; 
  isMenuOpen = true; 
  showCaretDescription = false; 
  showCaretTitle = true; 
  constructor(){}
  
  selectService(service: string) {
    console.log('selectService')
    this.activeService=service;
    this.isMenuOpen = false; 
    
  }
  ngOnInit() {
    this.typeTitle();
  }
  
  typeTitle() {
    if (this.titleIndex < this.title.length) {
      this.typedTitle += this.title.charAt(this.titleIndex);
      this.titleIndex++;
      setTimeout(() => this.typeTitle(), 30); 
    } else {
      this.showCaretTitle = false;
      setTimeout(() => {
        this.showDescription = true;
        this.typeDescription();
      }, 500); 
    }
  }
  
  typeDescription() {
    if (this.descriptionIndex < this.description.length) {
      this.showCaretDescription = true;
      this.typedDescription += this.description.charAt(this.descriptionIndex);
      this.descriptionIndex++;
      setTimeout(() => this.typeDescription(), 10); 
    } else {
      this.showCaretDescription = false;
    }
  }
  
  toggleMenu() {
    this.isMenuOpen = !this.isMenuOpen; 
  }
}
