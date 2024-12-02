import { Component, OnInit, ViewChild } from '@angular/core';
import { AppTranslationService } from '../../services/app-translation.service';
import { SearchComponent } from '../../components/search/search.component';

@Component({
  selector: 'app-language-settings',
  templateUrl: './language-settings.component.html',
  styleUrls: ['./language-settings.component.css']
})
export class LanguageSettingsComponent implements OnInit {
  @ViewChild(SearchComponent) searchComponent: SearchComponent | undefined;

  areAllAccordionsOpen: boolean = false;
  currentPage: number = 1;
  itemsPerPage: number = 20;
  totalPages: number = 1;
  maxPagesToShow: number = 5;
  selectedLanguage2: { label: string, value: string } = { label: 'English', value: 'en' };
  selectedLanguage1: { label: string, value: string } = { label: 'Italiano', value: 'it' };
  isVisibleEditModal: boolean = false;
  selectedLabel: any = {};
  filteredTranslationKeys: string[] = [];
  languagesOptions = [];
  translations: { [lang: string]: { [key: string]: { value: string, translationId: string, keyId: string } } } = {};

  get translationKeys() {
    if (this.translations
       && Object.keys(this.translations).length > 0
      && this.translations[this.selectedLanguage1.value]) {
      return Object.keys(this.translations[this.selectedLanguage1.value]);
    } else {
      return [];
    }
  }

  constructor(private appTranslationService: AppTranslationService) { }

  ngOnInit() {
    this.appTranslationService.getTranslations().subscribe();
    this.appTranslationService.translations$.subscribe(resp => {
      if (resp && Object.keys(resp).length > 0) {
        this.translations = resp;
        this.filteredTranslationKeys = this.translationKeys;
        this.totalPages = Math.ceil(this.filteredTranslationKeys.length / this.itemsPerPage);
      }
    });

    this.appTranslationService.languages$.subscribe(resp => {
      if (resp) {
        this.languagesOptions = resp;
      }
    });
  }

  toggleAllAccordions() {
    this.areAllAccordionsOpen = !this.areAllAccordionsOpen;
  }

  onSelectedLanguage1(lang: { label: string, value: string }) {
    this.selectedLanguage1 = lang;
    this.onSearch({ searchValue: '', searchOptions: { caseSensitive: false, wholeWord: false } });
    if (this.searchComponent) {
      this.searchComponent.clearInput();
    }
  }

  onSelectedLanguage2(lang: { label: string, value: string }) {
    this.selectedLanguage2 = lang;
    this.onSearch({ searchValue: '', searchOptions: { caseSensitive: false, wholeWord: false } });
    if (this.searchComponent) {
      this.searchComponent.clearInput();
    }
  }

  onSearch(event: { searchValue: string | null; searchOptions: { caseSensitive: boolean; wholeWord: boolean; } }) {
    if (this.translations && Object.keys(this.translations).length > 0) {
      const { searchValue, searchOptions } = event;
      const { caseSensitive, wholeWord } = searchOptions;

      const seenKeys = new Set<string>();

      this.filteredTranslationKeys = this.translationKeys.filter(key => {
        const keyToCheck = caseSensitive ? key : key.toLowerCase();
        const searchText = caseSensitive ? (searchValue || '') : (searchValue || '').toLowerCase();

        const translation1 = this.translations[this.selectedLanguage1.value][key].value;
        const translation2 = this.translations[this.selectedLanguage2.value][key].value;

        const translation1ToCheck = caseSensitive ? translation1 : translation1.toLowerCase();
        const translation2ToCheck = caseSensitive ? translation2 : translation2.toLowerCase();

        let match = false;

        if (wholeWord) {
          match = keyToCheck === searchText ||
            translation1ToCheck === searchText ||
            translation2ToCheck === searchText;
        } else {
          match = keyToCheck.includes(searchText) ||
            translation1ToCheck.includes(searchText) ||
            translation2ToCheck.includes(searchText);
        }

        if (match && !seenKeys.has(key)) {
          seenKeys.add(key);
          return true;
        }

        return false;
      });

      this.totalPages = Math.ceil(this.filteredTranslationKeys.length / this.itemsPerPage);
      this.currentPage = 1;
    }
  }

  get paginatedTranslationKeys() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.filteredTranslationKeys.slice(startIndex, endIndex);
  }

  goToPage(page: number) {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }

  get pagesToShow(): number[] {
    const pages = [];
    const half = Math.floor(this.maxPagesToShow / 2);
    let start = Math.max(this.currentPage - half, 1);
    let end = Math.min(start + this.maxPagesToShow - 1, this.totalPages);

    if (end - start < this.maxPagesToShow - 1) {
      start = Math.max(end - this.maxPagesToShow + 1, 1);
    }

    for (let i = start; i <= end; i++) {
      pages.push(i);
    }

    return pages;
  }

  closeModal() {
    this.isVisibleEditModal = false;
    this.selectedLabel = {};
  }

  openEditLabelModal(key: string, label: any) {
    this.selectedLabel = { key, ...label };
    this.isVisibleEditModal = true;
  }

  saveChanges() {
    this.appTranslationService.updateTranslation(this.selectedLanguage1.value, this.selectedLabel.keyId, this.selectedLabel.translationId, this.selectedLabel.value)
    .subscribe(resp => {
      this.closeModal();
    });
   
  }
}