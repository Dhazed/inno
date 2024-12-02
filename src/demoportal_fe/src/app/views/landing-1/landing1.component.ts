import { Component } from '@angular/core';

@Component({
  selector: 'app-landing-1',
  templateUrl: './landing1.component.html',
  styleUrl: './landing1.component.css'
})
export class Landing1Component {
  activeService = '1'
  constructor(){}

  selectService(service: string) {
    console.log('selectService')
    this.activeService=service;
  }
}
