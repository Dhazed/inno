import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TranslateService } from '@ngx-translate/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';


@Injectable({ providedIn: 'root' })
export class AppTranslationService {
  private baseUrl: string = environment.apiUrl || 'http://localhost:8080/';

  private languageLabels: { [key: string]: { label: string, code: string } } = {
    'es': { label: 'Spagnolo', code: 'es_ES' },
    'de': { label: 'Tedesco', code: 'de_DE' },
    'fr': { label: 'Francese', code: 'fr_FR' },
    'pt': { label: 'Portoghese', code: 'pt_PT' },
    'it': { label: 'Italiano', code: 'it_IT' },
    'ro': { label: 'Rumeno', code: 'ro_RO' },
    'sl': { label: 'Sloveno', code: 'sl_SI' },
    'en': { label: 'Inglese', code: 'en_US' },
    'pl': { label: 'Polacco', code: 'pl_PL' },
    'hu': { label: 'Ungherese', code: 'hu_HU' },
  };

  private translationsSubject = new BehaviorSubject<any>({});
  translations$: Observable<any> = this.translationsSubject.asObservable();

  private langagesSubject = new BehaviorSubject<any>(null);
  languages$: Observable<any> = this.langagesSubject.asObservable();

  constructor(private http: HttpClient, private translate: TranslateService) { }

  getTranslations(language?: string): Observable<any> {
    const langCode =  language ? this.languageLabels[language].code : '';
    return this.http.get<any[]>(this.baseUrl+'db/lokalise/' + langCode).pipe(
      tap(response => {
        const translations: { [key: string]: { [key: string]: { value: string, id: string } } } = this.transformTranslations(response);
        this.translationsSubject.next(translations);
        Object.keys(translations).forEach(lang => {
          const langTranslations = Object.keys(translations[lang]).reduce((acc: any, key) => {
            acc[key] = translations[lang][key].value;
            return acc;
          }, {});
          this.translate.setTranslation(lang, langTranslations, true);
        });
      })
    );
  }

  transformTranslations(data: any[]): any {
    const translations: any = {};
    const langArray: Set<string> = new Set();

    data.forEach(item => {
      const lang = item.lang_iso.split('_')[0]; // Extract language code (e.g., 'en' from 'en_US')
      langArray.add(lang);
      const key = item.web_key_name.replace(/^\uFEFF/, '');
      const translation = item.translation;
      if (!translations[lang]) {
        translations[lang] = {};
      }
      translations[lang][key] = {
        value: translation,
        translationId: item.translation_id,
        keyId: item.key_id
      };
    });

    this.langagesSubject.next(Array.from(langArray).map((lang: string) => ({
      label: this.languageLabels[lang].label || lang,
      value: lang
    })).sort((a, b) => a.label.localeCompare(b.label)));

    return translations;
  }

  updateTranslation(lang: string, key: string, translationId: string, value: string): Observable<any> {
    if (lang && key && translationId && value) {
      const langCode = this.languageLabels[lang].code;
      return this.http.put(`${this.baseUrl}db/lokalise/${langCode}/${key}/${translationId}`, { value });
    } else {
      return new Observable();
    } 
    
  }
}