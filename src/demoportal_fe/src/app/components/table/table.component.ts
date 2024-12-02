import { Component, Input, Output, EventEmitter, OnInit, OnChanges } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit, OnChanges {
  @Input() columns: { header: string, field: string, type?: string }[] = [];
  @Input() data: any[] = [];
  @Input() actions: { icon: string, handler: string }[] = [];
  @Output() actionClicked = new EventEmitter<{ action: string, row: any }>();

  paginatedData: any[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 15;
  totalPages: number = 1;
  pages: number[] = [];
  sortField: string = '';
  sortOrder: string = 'asc';

  ngOnInit() {
    this.updatePagination();
  }

  ngOnChanges() {
    this.updatePagination();
  }

  updatePagination() {
    if (this.data) {
      this.totalPages = Math.ceil(this.data.length / this.itemsPerPage);
      this.pages = Array.from({ length: this.totalPages }, (_, i) => i + 1);
      this.paginateData();
    }
  }

  paginateData() {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    this.paginatedData = this.data.slice(start, end);
  }

  goToPage(page: number) {
    if (page < 1 || page > this.totalPages) {
      return;
    }
    this.currentPage = page;
    this.paginateData();
  }

  sortData(type: string | undefined, field: string) {
    if (type == 'image' || type == 'color') {
      return;
    }
    if (this.sortField === field) {
      this.sortOrder = this.sortOrder === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortOrder = 'asc';
    }

    this.data.sort((a, b) => {
      const valueA = a[field];
      const valueB = b[field];

      if (valueA < valueB) {
        return this.sortOrder === 'asc' ? -1 : 1;
      } else if (valueA > valueB) {
        return this.sortOrder === 'asc' ? 1 : -1;
      } else {
        return 0;
      }
    });

    this.paginateData();
  }

  onActionClick(action: string, row: any) {
    this.actionClicked.emit({ action, row });
  }
}