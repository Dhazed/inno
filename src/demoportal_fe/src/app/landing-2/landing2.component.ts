import { Component } from '@angular/core';

@Component({
  selector: 'app-landing-2',
  templateUrl: './landing2.component.html',
  styleUrl: './landing2.component.css',
})
export class Landing2Component {
  activeService = '1'
  constructor(){}

  selectService(service: string) {
    console.log('selectService')
    this.activeService=service;
  }
}
