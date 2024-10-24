import { Component, Input, Output, EventEmitter, OnInit, OnDestroy, ElementRef } from '@angular/core';

@Component({
  selector: 'app-custom-select',
  templateUrl: './custom-select.component.html',
  styleUrls: ['./custom-select.component.css']
})
export class CustomSelectComponent implements OnInit, OnDestroy {
  @Input() items: { label: string, value: any, customContent?: any }[] = [];
  @Input() placeholder: string = '';
  @Input() label: string = '';
  @Input() emptyLabel: string = '';
  @Input() includeEmptyOption: boolean = false;
  @Output() selectedItemChange = new EventEmitter<any>();
  @Input() disabled: boolean = false;

  @Input() selectedItem: any;
  isDropdownOpen: boolean = false;

  constructor(private eRef: ElementRef) {

  }

  ngOnInit() {
    /* if (this.preselectedItem) {
      this.selectedItem = this.items.filter(item => item.value === this.preselectedItem.toLowerCase())[0];
    } */
  }

  ngOnDestroy() {
    //document.removeEventListener('click', this.onDocumentClick.bind(this));
  }

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  selectItem(item: any) {
    this.selectedItem = item;
    this.selectedItemChange.emit(this.selectedItem);
    this.isDropdownOpen = false;
  }

  onDocumentClick(event: Event) {
    if (!this.eRef.nativeElement.contains(event.target)) {
      this.isDropdownOpen = false;
    }
  }
}