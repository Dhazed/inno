import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { AiFaceMatchingComponent } from './ai-face-matching/ai-face-matching.component';
import { ProfileSettingsComponent } from './profile-settings/profile-settings.component';
import { DocumentRecognitionComponent } from './document-recognition/document-recognition.component';
import { LanguageSettingsComponent } from './language-settings/language-settings.component';
import { ThemeSettingsComponent } from './theme-settings/theme-settings.component';
import { DocumentRecognitionVeridasComponent } from './document-recognition-veridas/document-recognition-veridas.component';
import { PhotoPageComponent } from './photo-page/photo-page.component';
import { CompaniesSettingsComponent } from './companies-settings/companies-settings.component';
import { UsersSettingsComponent } from './users-settings/users-settings.component';

const routes: Routes = [
  { path: 'home', component: LandingComponent },
  { path: 'document-recognition', component: DocumentRecognitionComponent },
  { path: 'document-recognition-veridas', component: DocumentRecognitionVeridasComponent },
  { path: 'ai-face-matching', component: AiFaceMatchingComponent },
  { path: 'profile-settings', component: ProfileSettingsComponent },
  { path: 'language-settings', component: LanguageSettingsComponent },
  { path: 'theme-settings', component: ThemeSettingsComponent },
  { path: 'users-settings', component: UsersSettingsComponent },
  { path: 'companies-settings', component: CompaniesSettingsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'mobile-photo', component: PhotoPageComponent },
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }