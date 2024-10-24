import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {
  private themeSubject = new BehaviorSubject<any>(null);
  theme$ = this.themeSubject.asObservable();

  constructor(private http: HttpClient) { }

  loadTheme(clientId: string) {
    let theme = null;
    switch (clientId) {
      case 'infocert':
        theme = {
          "colors": {
            'primary-color': '#006F98',
            'primary-dark-color': '#165874',
            'secondary-color': '#0B2E4F',
            'secondary-light-color': '#3C5872',
            'secondary-dark-color': '#1D2D3D',
            'secondary-tertiary-color': '#319ed8',
            'gray-color': '#EDEFF0',
            'gray-light-color': '#C2D1D9',
            'text-color': '#ffffff',
          },
          "logo": "logo_2023.png"
        };
        break;

      case 'unicredit':
        theme = {
          "colors": {
            'primary-color': '#B91823',
            'primary-dark-color': '#cc0060',
            'secondary-color': '#660033',
            'secondary-light-color': '#99334d',
            'secondary-dark-color': '#330019',
            'secondary-tertiary-color': '#ff3399',
            'gray-color': '#EDEFF0',
            'gray-light-color': '#C2D1D9',
            'text-color': '#330019',
          },
          "logo": "unicredit_logo.png"
        };
        break;

      default:
        break;
    }
    if (theme) {
      this.themeSubject.next(theme);
      this.applyTheme(theme);
    }

    /*   this.http.get(`/api/theme/${clientId}`).subscribe(theme => {
        this.themeSubject.next(theme);
        this.applyTheme(theme);
      }); */
  }

  private applyTheme(theme: any) {
    if (theme.colors) {
      Object.keys(theme.colors).forEach(key => {
        document.documentElement.style.setProperty(`--${key}`, theme.colors[key]);
      });
    }
    if (theme.logo) {
      document.documentElement.style.setProperty('--logo-url', `url(${theme.logo})`);
    }
  }
}