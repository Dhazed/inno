import { Component, OnInit, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { LoaderService } from './services/loader.service';
import { TranslateService } from '@ngx-translate/core';
import { AppTranslationService } from './services/app-translation.service';
import { ThemeService } from './services/theme.service';
import { Router } from '@angular/router';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { NotificationService } from './services/notification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  isLoading$: Observable<boolean> | null;
  notification$: Observable<{ message: string, type: string } | null> | null;
  isControlPanelHidden = true;
  private readonly oidcSecurityService = inject(OidcSecurityService);


  constructor(private loaderService: LoaderService,
    private notificationService: NotificationService,
    public router: Router,
    private translate: TranslateService,
    private themeService: ThemeService,
    private appTranslationService: AppTranslationService) {

      this.isLoading$ = this.loaderService.loading$;
      this.notification$ = this.notificationService.notification$;
      this.appTranslationService.getTranslations('en').subscribe((resp: any) => {
        this.translate.setDefaultLang('en');
        this.translate.use('en');
      });
  }

  ngOnInit() {
    this.oidcSecurityService
      .checkAuth()
      .subscribe(
        ({ isAuthenticated, userData, accessToken, idToken, configId }) => {
          console.log('callback authenticated', isAuthenticated);
        }
      );
  }

  toggleControlPanel() {
    this.isControlPanelHidden = !this.isControlPanelHidden;
  }

  changeTheme(themeName: string) {
    // Carica il tema specificato
    this.themeService.loadTheme(themeName);
  }
}

