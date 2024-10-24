import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { LoaderService } from './services/loader.service';
import { TranslateService } from '@ngx-translate/core';
import { AppTranslationService } from './services/app-translation.service';
import { ThemeService } from './services/theme.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isLoading$: Observable<boolean> | null;
  isControlPanelHidden = true;


  constructor(private loaderService: LoaderService,
    public router: Router,
    private translate: TranslateService,
    private themeService: ThemeService,
    private appTranslationService: AppTranslationService) {
    this.isLoading$ = this.loaderService.loading$;
    
    this.appTranslationService.getTranslations('en').subscribe((resp: any) => {
      this.translate.setDefaultLang('en');
      this.translate.use('en');
    });
  }

  toggleControlPanel() {
    this.isControlPanelHidden = !this.isControlPanelHidden;
  }

  changeTheme(themeName: string) {
    // Carica il tema specificato
    this.themeService.loadTheme(themeName);
  }
}

