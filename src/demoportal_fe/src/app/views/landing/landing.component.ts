import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrl: './landing.component.css',
})
export class LandingComponent implements OnInit {
  activeService = '1'
  constructor(private httpClient: HttpClient){}

  ngOnInit(): void {
    this.activeService = localStorage.getItem('activeService') || '1';
  
  }

  selectService(service: string) {
    localStorage.setItem('activeService', service);
    this.activeService=service;
  }
}
