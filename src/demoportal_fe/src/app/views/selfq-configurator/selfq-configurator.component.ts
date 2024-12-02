import { Component, OnInit } from '@angular/core';
import { SelfQService } from '../../services/selfq.service';

@Component({
  selector: 'app-selfq-configurator',
  templateUrl: './selfq-configurator.component.html',
  styleUrls: ['./selfq-configurator.component.css']
})
export class SelfqConfiguratorComponent implements OnInit {
  currentStep: number = 1;
  isEmailValid: boolean = true;
  urlQrCode: string = '';
  email: string = '';
  phoneNumber: string = '';
  flagLang: string = 'fi-gb'; // Imposta il valore iniziale
  countryPrefix: string = '+44'; // Imposta il prefisso iniziale
  steps: Array<{ name: string }> = [
    { name: 'Inserisci i tuoi dati' },
    { name: 'SMS sul tuo cellulare' }
  ];

  constructor(private selfQService: SelfQService
  ) { }

  ngOnInit(): void {
  }
 
  updateFlagAndPrefix(flag: string, prefix: string) {
    this.flagLang = flag;
    this.countryPrefix = prefix;
  }

  goToStep2() {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (this.email === '' || this.phoneNumber === '' || !emailRegex.test(this.email)) {
     this.isEmailValid = false;
      return;
    } else {
      this.isEmailValid = true;
    }
    this.selfQService.startSelfQ({ phoneNumber: this.countryPrefix + this.phoneNumber, email: this.email, lang: this.flagLang.replace('fi-', '') }).subscribe((res: any) => {
      this.urlQrCode = res.tokens;
      this.currentStep = 2;
    });
  }

  goToStep1() {
    this.currentStep = 1;
  }

}
