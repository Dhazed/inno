import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service'; // Adjust the path as necessary

@Component({
  selector: 'app-companies-settings',
  templateUrl: './companies-settings.component.html',
  styleUrls: ['./companies-settings.component.css']
})
export class CompaniesSettingsComponent implements OnInit {
  showFileUploader: boolean = true;
  originalfile: any = null;

  columns = [
    { field: 'companyName', header: 'Nome' },
    { field: 'primaryColor', header: 'Colore Primario', type: 'color' },
    { field: 'secondaryColor', header: 'Colore Secondario',type: 'color' },
    { field: 'logoImg', header: 'Logo', type: 'image' },
   
  ];

  actions = [
    { icon: 'edit', handler: 'showEditModal' },
    { icon: 'delete', handler: 'deleteCompany' }
  ];

  companies: any[] = [];
  filteredCompanies: any[] = [];

  isVisibleEditModal: boolean = false;
  modalMode: string = 'create';
  oldCompanyName: string = '';
  isPopUpVisible: boolean = false;
  selectedCompany: any = {
    companyName: '',
    description: '',
    primaryColor: '#ffffff',
    secondaryColor: '#ffffff',
    logoImg: '',
  };

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.adminService.companies$.subscribe((companies: any) => {
      this.companies = companies;
      this.filteredCompanies = companies;
    });
    this.adminService.getCompanies().subscribe();
  }

  onSearch(event: { searchValue: string | null }): void {
    if (!event.searchValue) {
      this.filteredCompanies = this.companies;
      return;
    }
    const searchValue = event.searchValue.toLowerCase();
    this.filteredCompanies = this.companies.filter(company =>
      company.companyName.toLowerCase().includes(searchValue)
    );
  }

  addNewCompany(): void {
    this.isVisibleEditModal = true; 
    this.showFileUploader = true;
  }

  onActionClicked(event: { action: string, row: any }): void {
    const { action, row } = event;
    this.selectedCompany = event.row;
    if (action === 'showEditModal') {
      this.oldCompanyName = this.selectedCompany.companyName;
      this.isVisibleEditModal = true;
      this.modalMode = 'update';
      if (this.selectedCompany.logoImg) {
        this.showFileUploader = false;
      } else {
        this.showFileUploader = true;
      } 
    } else if (action === 'deleteCompany') {
      this.isPopUpVisible = true;
    }
  }

  closeModal(): void {
    this.isVisibleEditModal = false;
    this.modalMode = 'create';
    this.selectedCompany = {
      companyName: '',
      description: '',
      primaryColor: '#ffffff',
      secondaryColor: '#ffffff',
      logoImg: '',
    };
  }

  closePopUp(): void {
    this.isPopUpVisible = false;
    this.closeModal();
  }

  confirmModal(): void {
    if (!this.selectedCompany.companyName) {
      console.error('All fields are required');
      return;
    }
    if (this.modalMode == 'update') {
      this.adminService.updateCompany(this.oldCompanyName, this.selectedCompany).subscribe(() => {
        console.log('Company updated');
        this.closeModal();
      });
    } else {
      this.adminService.createCompany(this.selectedCompany).subscribe(() => {
        console.log('Company created');
        this.closeModal();
      });
    }
  }

  confirmDelete(): void {
    this.adminService.deleteCompany(this.selectedCompany.companyName).subscribe(() => {
      console.log('Company deleted');
      this.closePopUp();
    });
  }

  onFileUpload(file: any) {
    this.showFileUploader = false;
    this.selectedCompany.logoImg = file.imageSrc;
    this.originalfile = file.originalfile;
  }

  removeFile() {
    this.selectedCompany.logoImg = '';
    this.showFileUploader = true;
  }
}