import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component'; 
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';
import { CardComponent } from './components/card/card.component';
import { CardMenuComponent } from './components/card-menu/card-menu.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Landing1Component } from './landing-1/landing1.component';
import { Landing2Component } from './landing-2/landing2.component';
import { AppRoutingModule } from './app.routing.module';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './components/footer/footer.component';
import { Landing3Component } from './landing-3/landing-3.component';
import { DocumentRecognitionComponent } from './document-recognition/document-recognition.component';
import { FileUploaderComponent } from './components/file-uploader/file-uploader.component';
import { ModalComponent } from './components/modal/modal.component';
import { WebcamModule } from 'ngx-webcam';
import { StepCounterComponent } from './components/step-counter/step-counter.component';
import { ProfileSettingsComponent } from './profile-settings/profile-settings.component';
import { ToastComponent } from './components/toast/toast.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    CardMenuComponent,
    HeaderComponent,
    Landing2Component,
    Landing1Component,
    Landing3Component,
    LoginComponent,
    FooterComponent,
    DocumentRecognitionComponent,
    FileUploaderComponent,
    ModalComponent,
    StepCounterComponent,
    ProfileSettingsComponent,
    ToastComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule, 
    BrowserAnimationsModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    WebcamModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
