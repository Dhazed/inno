import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Landing1Component } from './landing-1/landing1.component';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { Landing2Component } from './landing-2/landing2.component';
import { LoginComponent } from './login/login.component';
import { Landing3Component } from './landing-3/landing-3.component';
import { DocumentRecognitionComponent } from './document-recognition/document-recognition.component';
import { ProfileSettingsComponent } from './profile-settings/profile-settings.component';

const routes: Routes = [
    { path: 'landing1', component: Landing1Component },
    { path: 'landing2', component: Landing2Component },
    { path: 'landing3', component: Landing3Component },
    { path: 'document-recognition', component: DocumentRecognitionComponent },
    { path: 'profile-settings', component: ProfileSettingsComponent },
    { path: 'login', component: LoginComponent },
    { path: '',   redirectTo: '/landing1', pathMatch: 'full' },
    { path: '**', component: PageNotFoundComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }