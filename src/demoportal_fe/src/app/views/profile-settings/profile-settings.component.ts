import { Component } from '@angular/core';
import { OidcSecurityService, UserDataResult } from 'angular-auth-oidc-client';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-profile-settings',
  templateUrl: './profile-settings.component.html',
  styleUrl: './profile-settings.component.css'
})
export class ProfileSettingsComponent {
  isVisibleEditProfileModal: boolean = false;
  userData$: Observable<UserDataResult> | null = null;

  constructor( private oidcSecurityService: OidcSecurityService) {
    this.userData$ = this.oidcSecurityService.userData$;
  }

  closeModal() {
    this.isVisibleEditProfileModal = false;
    
  }
}
