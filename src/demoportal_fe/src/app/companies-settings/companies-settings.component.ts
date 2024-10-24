import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-companies-settings',
  templateUrl: './companies-settings.component.html',
  styleUrls: ['./companies-settings.component.css']
})
export class CompaniesSettingsComponent implements OnInit {
  showFileUploader: boolean = true;
  imageSrc: any = undefined;
  originalfile: any = null;

  columns = [
    { field: 'name', header: 'Nome' },
    { field: 'primaryColor', header: 'Colore Primario' },
    { field: 'secondaryColor', header: 'Colore Secondario' },
    { field: 'logo', header: 'Logo' },
    { field: 'userCount', header: 'Numero Utenti' }
  ];

  actions = [
    { icon: 'edit', handler: 'editCompany' },
    { icon: 'delete', handler: 'deleteCompany' }
  ];

  companies = [
    { name: 'Company A', primaryColor: '#FF0000', secondaryColor: '#00FF00', logo: 'logoA.png', userCount: 100 },
    { name: 'Company B', primaryColor: '#0000FF', secondaryColor: '#FFFF00', logo: 'logoB.png', userCount: 200 }
  ];

  isVisibleEditModal: boolean = false;
  isPopUpVisible: boolean = false;
  selectedCompany: any = {
    name: '',
    primaryColor: '#ffffff',
    secondaryColor: '#ffffff',
    logo: '',
    userCount: 0
  };

  constructor() { }

  ngOnInit(): void { }

  editCompany(): void {
    this.isVisibleEditModal = true;
  }



  onActionClicked(event: { action: string, row: any }): void {
    this.selectedCompany = event.row;
    const { action, row } = event;
    if (action === 'editCompany') {
      this.editCompany();
    } else if (action === 'deleteCompany') {
      this.isPopUpVisible = true;
    }
  }

  closeModal(): void {
    this.isVisibleEditModal = false;
    this.selectedCompany = {
      name: '',
      primaryColor: '#ffffff',
      secondaryColor: '#ffffff',
      logo: '',
      userCount: 0
    };
  }

  closePopUp(): void {
    this.isPopUpVisible = false;
  }

  confirmModal(): void {
    //TODO: Implementare la logica per la conferma
    if (true) {
      this.closeModal();
    } else {
      console.log('Form is invalid');
    }
  }


  confirmDelete(): void {
    //TODO: Implementare la logica per l eliminazione
    this.closePopUp();
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