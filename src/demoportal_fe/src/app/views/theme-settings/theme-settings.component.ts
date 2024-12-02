import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-theme-settings',
  templateUrl: './theme-settings.component.html',
  styleUrls: ['./theme-settings.component.css']
})
export class ThemeSettingsComponent {
  primaryColor: string = '#006F98';
  secondaryColor: string = '#ffffff';
  showFileUploader: boolean = true;
  imageSrc: any = undefined;
  originalfile: any = null;
  font = 'Satoshi';

  customStyles = {
    "fontFamily": ["Satoshi"],
    "loaderColor": "#006F98",
    "primaryTextColor": "#ffffff",
    "primaryBgColor": "#006F98",
    "secondaryTextColor": "#165874",
    "secondaryBgColor": "#ffffff",
    "theme": {
      "textColor": "#1F2937",
      "backgroundColor": "#ffffff"
    }
  };

  constructor(private http: HttpClient) {}

  saveThemeSettings() {
    const themeSettings = {
      'primary-color': this.primaryColor,
      'secondary-color': this.secondaryColor
    };

    this.http.post('/api/save-theme-settings', themeSettings).subscribe(response => {
      console.log('Theme settings saved:', response);
      // Aggiorna i colori nel documento
      //this.themeService.applyThemeSettings(themeSettings);
    });
  }

  onFileUpload(file: any) {
    this.showFileUploader = false;
    this.imageSrc = file.imageSrc;
    this.originalfile = file.originalfile;
  }
  removeFile() {
    this.imageSrc = undefined;
    this.showFileUploader = true;
  }

  
}