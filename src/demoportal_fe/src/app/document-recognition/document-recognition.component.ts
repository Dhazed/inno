import { Component } from '@angular/core';

@Component({
  selector: 'app-document-recognition',
  templateUrl: './document-recognition.component.html',
  styleUrl: './document-recognition.component.css'
})
export class DocumentRecognitionComponent {
  currentStep: number = 1
  stepsArray = [
    { name: 'Carica documento' },
    { name: 'Verifica identità' }]

    verifyIdentity() {
      this.currentStep = 2;
    }
  }
  