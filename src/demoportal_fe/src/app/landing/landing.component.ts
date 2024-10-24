import { Component } from '@angular/core';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
})
export class LandingComponent {
  activeService = '1'
  constructor(){}
  
  selectService(service: string) {
    console.log('selectService')
    this.activeService=service;
  }
}
