import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-users-settings',
  templateUrl: './users-settings.component.html',
  styleUrl: './users-settings.component.css'
})
export class UsersSettingsComponent implements OnInit {
  columns: any[] = [];
  rolesItems: any[] = [
    { label: 'Admin', value: 'admin' },
    { label: 'Company Admin', value: 'company_admin' },
    { label: 'User', value: 'user' },

  ];

  actions = [
    { icon: 'edit', handler: 'editUser' },
    { icon: 'delete', handler: 'deleteUser' }
  ];

  users = [
    // Esempio di dati
    { email: 'paolo.manzi@infocert.com', name: 'Paolo', surname: 'Manzi', company: 'Infocert', role: 'admin' },
    { email: 'guglielmo.bianchi@unicredit.com', name: 'Guglielmo', surname: 'Verdi', company: 'Unicredit', role: 'company_admin' },
    { email: 'mario.rossi@unicredit.com', name: 'Mario', surname: 'Rossi', company: 'Unicredit', role: 'user' },
    { email: 'franco.bianchi@enel.com', name: 'Franco', surname: 'Bianchi', company: 'Enel', role: 'user' }
  ];
  companiesItems: any[] = [];
  isVisibleEditModal: boolean = false;
  isPopUpVisible: boolean = false;
  selectedUser: any = {};

  constructor(private translate: TranslateService) {
    this.columns = [
      { field: 'email', header: this.translate.instant('bTHOq1|settings_txt_Email') },
      { field: 'name', header: this.translate.instant('bTHCp1|checkindetail_txt_Firstname') },
      { field: 'surname', header: this.translate.instant('bTHCq1|checkindetail_txt_Surname') },
      { field: 'company', header: this.translate.instant('bTHDo1|checkindetail_txt_Company') },
      { field: 'role', header: this.translate.instant('bTHDQ1|checkindetail_txt_Role') },
    ];
    this.companiesItems = this.users.map(user => user.company)
      .filter((value, index, self) => self.indexOf(value) === index)
      .map(company => ({ label: company, value: company.toLowerCase() }));
    this.selectedUser = { email: '', name: '', surname: '', company: '', role: '' };
  }

  ngOnInit(): void { }

  editUser(): void {
    this.isVisibleEditModal = true;
  }
  get userRole() {
    return this.rolesItems.find(role => role.value === this.selectedUser.role);
  }
  get userCompany() {
    return this.companiesItems.find(company => company.value === this.selectedUser.company.toLowerCase());
  }

  onActionClicked(event: { action: string, row: any }): void {
    this.selectedUser = event.row;
    const { action, row } = event;
    if (action === 'editUser') {
      this.editUser();
    } else if (action === 'deleteUser') {
      this.isPopUpVisible = true;
    }
  }

  closeModal(): void {
    this.isVisibleEditModal = false;
    this.selectedUser = {
      email: '',
      name: '',
      surname: '',
      company: '',
      role: ''
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


}