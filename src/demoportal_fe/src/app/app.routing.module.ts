import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './views/page-not-found/page-not-found.component';
import { LandingComponent } from './views/landing/landing.component';
import { LoginComponent } from './views/login/login.component';
import { AiFaceMatchingComponent } from './views/ai-face-matching/ai-face-matching.component';
import { ProfileSettingsComponent } from './views/profile-settings/profile-settings.component';
import { DocumentRecognitionComponent } from './views/document-recognition/document-recognition.component';
import { LanguageSettingsComponent } from './views/language-settings/language-settings.component';
import { ThemeSettingsComponent } from './views/theme-settings/theme-settings.component';
import { DocumentRecognitionVeridasComponent } from './views/document-recognition-veridas/document-recognition-veridas.component';
import { PhotoPageComponent } from './views/photo-page/photo-page.component';
import { CompaniesSettingsComponent } from './views/companies-settings/companies-settings.component';
import { UsersSettingsComponent } from './views/users-settings/users-settings.component';
import { OnboardingWidgetPageComponent } from './views/onboarding-widget-page/onboarding-widget-page.component';
import { OnWidgetConfiguratorComponent } from './views/on-widget-configurator/on-widget-configurator.component';
import { SelfqConfiguratorComponent } from './views/selfq-configurator/selfq-configurator.component';
import { SBBSelfqConfiguratorComponent } from './views/sbb-selfq-configurator/sbb-selfq-configurator.component';
import { LoginGuard } from './guards/login.guard';
import { AutoLoginPartialRoutesGuard } from 'angular-auth-oidc-client';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login'},
  { path: 'login', component: LoginComponent, canActivate: [LoginGuard]  },
  { path: 'home', component: LandingComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'document-recognition', component: DocumentRecognitionComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'document-recognition-veridas', component: DocumentRecognitionVeridasComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'ai-face-matching', component: AiFaceMatchingComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'profile-settings', component: ProfileSettingsComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'language-settings', component: LanguageSettingsComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'theme-settings', component: ThemeSettingsComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'users-settings', component: UsersSettingsComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'companies-settings', component: CompaniesSettingsComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'mobile-photo', component: PhotoPageComponent },
  { path: 'mobile-onboarding-widget', component: OnboardingWidgetPageComponent },
  { path: 'on-widget-configurator', component: OnWidgetConfiguratorComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'selfq-configurator', component: SelfqConfiguratorComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  { path: 'SBB-selfq-configurator', component: SBBSelfqConfiguratorComponent, canActivate: [AutoLoginPartialRoutesGuard] },
  /*  { path: 'unauthorized', component: UnauthorizedComponent }, */
  /* { path: 'callback', component: CallbackComponent }, */
  { path: '**', redirectTo: 'login', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
