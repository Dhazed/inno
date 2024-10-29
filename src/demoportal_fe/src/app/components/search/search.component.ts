import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchControl = new FormControl('');
  @Input() hideWholeWord = false;
  @Input() hideCaseSensitive = false;
  @Output() searchEvent = new EventEmitter<{ searchValue: string | null; searchOptions: { caseSensitive: boolean; wholeWord: boolean; } }>();
  @ViewChild('searchInput') searchInput: ElementRef | undefined;

  isCaseSensitive = false;
  isWholeWord = false;

  clearInput() {
    if (this.searchInput) {
      this.searchInput.nativeElement.value = '';
      this.isCaseSensitive = false;
      this.isWholeWord = false;
    
    }
  }

  toggleCaseSensitive() {
    this.isCaseSensitive = !this.isCaseSensitive;
    this.emitSearchEvent();
  }

  toggleWholeWord() {
    this.isWholeWord = !this.isWholeWord;
    this.emitSearchEvent();
  }

  emitSearchEvent() {
    const searchValue = this.searchControl.value;
    const searchOptions = {
      caseSensitive: this.isCaseSensitive,
      wholeWord: this.isWholeWord
    };
    this.searchEvent.emit({ searchValue, searchOptions });
  }

  constructor() {}

  ngOnInit() {
    this.searchControl.valueChanges.pipe(
      debounceTime(300),
      distinctUntilChanged()
    ).subscribe((value: any) => {
      this.emitSearchEvent();
    });
  }
}