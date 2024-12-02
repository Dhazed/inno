import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component'; 
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { CardComponent } from './components/card/card.component';
import { CardMenuComponent } from './components/card-menu/card-menu.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Landing1Component } from './views/landing-1/landing1.component';
import { LandingComponent } from './views/landing/landing.component';
import { AppRoutingModule } from './app.routing.module';
import { LoginComponent } from './views/login/login.component';
import { FooterComponent } from './components/footer/footer.component';
import { Landing3Component } from './views/landing-3/landing-3.component';
import { AiFaceMatchingComponent } from './views/ai-face-matching/ai-face-matching.component';
import { FileUploaderComponent } from './components/file-uploader/file-uploader.component';
import { ModalComponent } from './components/modal/modal.component';
import { WebcamModule } from 'ngx-webcam';
import { StepCounterComponent } from './components/step-counter/step-counter.component';
import { ProfileSettingsComponent } from './views/profile-settings/profile-settings.component';
import { ToastComponent } from './components/toast/toast.component';
import { FilePreviewComponent } from './components/file-preview/file-preview.component';
import { HttpClient, provideHttpClient, withInterceptors } from '@angular/common/http';
import { GaugeComponent } from './components/gauge/gauge.component';
import { LoaderComponent } from './components/loader/loader.component';
import { appHttpInterceptorFn } from './interceptors/app-http-interceptor.service';
import { TabsComponent } from './components/tabs/tabs.component';
import { DocumentRecognitionComponent } from './views/document-recognition/document-recognition.component';
import { DocumentRecognitionVeridasComponent } from './views/document-recognition-veridas/document-recognition-veridas.component';
import { CountdownTimerComponent } from './components/countdown-timer/countdown-timer.component';
import { CustomSelectComponent } from './components/custom-select/custom-select.component';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { LanguageSettingsComponent } from './views/language-settings/language-settings.component';
import { TableComponent } from './components/table/table.component';
import { FormsModule } from '@angular/forms';
import { SearchComponent } from './components/search/search.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ThemeSettingsComponent } from './views/theme-settings/theme-settings.component';
import { PhotoPageComponent } from './views/photo-page/photo-page.component';
import { OnboardingWidgetPageComponent } from './views/onboarding-widget-page/onboarding-widget-page.component';
import { CompaniesSettingsComponent } from './views/companies-settings/companies-settings.component';
import { UsersSettingsComponent } from './views/users-settings/users-settings.component';
import { PopUpComponent } from './components/pop-up/pop-up.component';
import '@infocert/onboarding-widget/build';
import { OnWidgetConfiguratorComponent } from './views/on-widget-configurator/on-widget-configurator.component';
import { SBBSelfqConfiguratorComponent } from './views/sbb-selfq-configurator/sbb-selfq-configurator.component';
import { SelfqConfiguratorComponent } from './views/selfq-configurator/selfq-configurator.component';
/* import { OAuthModule } from 'angular-oauth2-oidc'; */
import { AuthConfigModule } from './auth-config.module';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    TableComponent,
    SearchComponent,
    PopUpComponent,
    CustomSelectComponent,
    TabsComponent,
    CountdownTimerComponent,
    CardMenuComponent,
    HeaderComponent,
    ModalComponent,
    StepCounterComponent,
    ToastComponent,
    GaugeComponent,
    FilePreviewComponent,
    LoaderComponent,
    LandingComponent,
    Landing1Component,
    Landing3Component,
    LoginComponent,
    FooterComponent,
    FileUploaderComponent,
    AiFaceMatchingComponent,
    ProfileSettingsComponent,
    LanguageSettingsComponent,
    DocumentRecognitionComponent,
    DocumentRecognitionVeridasComponent,
    ThemeSettingsComponent,
    PhotoPageComponent,
    OnboardingWidgetPageComponent,
    CompaniesSettingsComponent,
    UsersSettingsComponent,
    OnboardingWidgetPageComponent,
    OnWidgetConfiguratorComponent,
    SBBSelfqConfiguratorComponent,
    SelfqConfiguratorComponent
  ],
  imports: [
    AuthConfigModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserModule, 
    BrowserAnimationsModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    WebcamModule,
    FormsModule,
   /*  OAuthModule.forRoot(), */
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
    providers: [ 
      provideHttpClient(
      withInterceptors([appHttpInterceptorFn])  // Usa withInterceptors per fornire il nuovo interceptor basato su funzioni
    )
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }