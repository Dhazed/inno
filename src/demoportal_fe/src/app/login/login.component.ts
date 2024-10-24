import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ThemeService } from '../services/theme.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: any = '';
  constructor(private router: Router, private themeService: ThemeService) {}
  onLogin() {
    
    this.themeService.loadTheme(this.email.split('@')[1].replace('.com', ''));

    this.router.navigate(['/home']);
  }
}
