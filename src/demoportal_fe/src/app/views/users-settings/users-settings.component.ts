import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-users-settings',
  templateUrl: './users-settings.component.html',
  styleUrl: './users-settings.component.css'
})
export class UsersSettingsComponent implements OnInit {
  columns: Array<{ field: string, header: string, type?: string }> = [];
  rolesItems: any[] = [];
  users = [];
  searchValue = '';
  filteredUsers = [];
  companiesItems: any[] = [];
  isVisibleEditModal: boolean = false;
  isPopUpVisible: boolean = false;
  selectedUser: any = {};
  selectedRole: string | null = null;
  selectedCompany: string | null = null;
  actions: any[] = [];
  modalMode: string = 'create';
  constructor(private translate: TranslateService,
    private adminService: AdminService) {
    this.columns = [
      { field: 'user_id', header: this.translate.instant('bTHOq1|settings_txt_Email'), type: 'email' },
      { field: 'given_name', header: this.translate.instant('bTHCp1|checkindetail_txt_Firstname') },
      { field: 'surname', header: this.translate.instant('bTHCq1|checkindetail_txt_Surname') },
      { field: 'companyName', header: this.translate.instant('bTHDo1|checkindetail_txt_Company') },
      { field: 'is_active', header: 'Active' },
      { field: 'last_login', header: 'Last login' },
      { field: 'valid_from_epoch', header: 'Valid From' },
      { field: 'valid_until_epoch', header: 'Valid Until' },
      { field: 'user_roles', header: this.translate.instant('bTHDQ1|checkindetail_txt_Role') },
    ];
    this.actions = [{ icon: 'edit', handler: 'editUser' },
    { icon: 'delete', handler: 'deleteUser' }];
    this.selectedUser = { user_id: '', given_name: '', surname: '', companyName: '', user_roles: '' };
  }

  ngOnInit() {
    this.adminService.getUsers().subscribe((users: any) => {
      this.users = users;
      this.filteredUsers = users;
    });
    this.adminService.getCompanies().subscribe((companies: any) => {
      this.companiesItems = companies.map((company: any) => ({ label: company.companyName, value: company.companyName.toLowerCase() }));
    });
    this.adminService.getRoles().subscribe((roles: string[]) => {
      this.rolesItems = roles.map((role: string) => ({ label: role.replace('_', ' '), value: role.toLowerCase() }));
    });
  }

  onSearch(event: { searchValue: string | null }): void {
    this.searchValue = event.searchValue ? event.searchValue.toLowerCase() : '';
    this.filteredUsers = this.users.filter((user: any) => {
      const matchesSearchValue = this.searchValue
        ? user.given_name.toLowerCase().includes(this.searchValue)
        || user.surname.toLowerCase().includes(this.searchValue)
        || user.user_id.toLowerCase().includes(this.searchValue)
        : true;
      const matchesRole = this.selectedRole ? user.user_roles.toLowerCase() === this.selectedRole : true;
      const matchesCompany = this.selectedCompany ? user.companyName.toLowerCase() === this.selectedCompany : true;
      return matchesSearchValue && matchesRole && matchesCompany;
    });
  }

  editUser(): void {
    this.isVisibleEditModal = true;
    this.modalMode = 'update';
  }

/*   get userRole() {
    if (!this.selectedUser.user_roles) {
      return '';
    }
    return this.rolesItems.find(role => role.value === this.selectedUser.user_roles.toLowerCase());
  }

  get userCompany() {
    if (!this.selectedUser?.company) {
      return '';
    }
    return this.companiesItems.find(company => company.value === this.selectedUser.company.toLowerCase());
  }
 */
  onRoleChange(newRole: any): void {
    this.selectedUser.user_roles = newRole.value;
  }

  onCompanyChange(newCompany: any): void {
    this.selectedUser.companyName = newCompany.label;
  }

  filterByRole(newRole: any): void {
    this.selectedRole = newRole.value;
    this.onSearch({ searchValue: this.searchValue });
  }

  filterByCompany(newCompany: any): void {
    this.selectedCompany = newCompany.value;
    this.onSearch({ searchValue: this.searchValue });
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
      user_id: '', given_name: '', surname: '', companyName: '', user_roles: ''
    };
    this.modalMode = 'create';
  }

  closePopUp(): void {
    this.isPopUpVisible = false;
  }

  confirmModal(): void {
    if (!this.selectedUser.user_id || !this.selectedUser.given_name || !this.selectedUser.surname || !this.selectedUser.user_roles || !this.selectedUser.companyName) {
      return;
    }

    if (this.modalMode === 'create') {
      this.adminService.createUser(this.selectedUser).subscribe(() => {
        this.closeModal();
      });
    } else if (this.modalMode === 'edit') {
      this.adminService.updateUser(this.selectedUser.user_id, this.selectedUser).subscribe(() => {
        this.closeModal();
      });
    }
  }

  confirmDelete(): void {
    this.adminService.deleteUser(this.selectedUser.user_id).subscribe(() => {
      this.closePopUp();
    });
  }
}