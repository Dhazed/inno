import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { LangChangeEvent } from '@ngx-translate/core';
import { AppTranslationService } from '../../services/app-translation.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  isLangOpen: boolean = false;
  flagLang: string = '';

  constructor(public router: Router,
              private appTranslateService: AppTranslationService,
     private translate: TranslateService) {
    this.translate.onLangChange.subscribe((event: LangChangeEvent) => {
      if (this.translate.currentLang == 'en') {
        this.flagLang = 'fi-gb';
      } else if (this.translate.currentLang == 'sl') {
        this.flagLang = 'fi-si';
      } else {
        this.flagLang = 'fi-' + this.translate.currentLang;
      }
    });
  }

  setLanguage(language: string) {
    this.appTranslateService.getTranslations(language).subscribe((resp) => {
      this.translate.use(language).subscribe(() => {
        this.flagLang = language === 'en' ? 'fi-gb' : language === 'sl' ? 'fi-si' : 'fi-' + language;
        this.isLangOpen = false;
      });
    });
  }
}
