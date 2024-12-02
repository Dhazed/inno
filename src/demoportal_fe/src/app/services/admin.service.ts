import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl = environment.apiUrl || 'http://localhost:8080/api/';
  private companiesSubject = new BehaviorSubject<any[]>([]);
  companies$ = this.companiesSubject.asObservable();

  constructor(private http: HttpClient) { }

  deleteCompany(companyId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}db/companies/${companyId}`).pipe(
      tap(() => this.loadCompanies())
    );
  }

  createCompany(companyData: any): Observable<any> {
    const createCompanyBody = {
      id_company_name: companyData.companyName,
      company_description: companyData.description,
      primary_color: companyData.primaryColor,
      secondary_color: companyData.secondaryColor,
      logo_img: companyData.logoImg,
    }
    return this.http.post(this.baseUrl + 'db/companies', createCompanyBody).pipe(
      tap(() => this.loadCompanies())
    );
  }

  getCompanies(): Observable<any> {
    return this.http.get(this.baseUrl + 'db/companies').pipe(
      map((response: any) => {
        return response.map((company: any) => {
          return {
            companyName: company.id_company_name,
            description: company.company_description,
            primaryColor: company.primary_color,
            secondaryColor: company.secondary_color,
            logoImg: company.logo_img,
          };
        });
      }),
      tap(companies => this.companiesSubject.next(companies))
    );
  }

  getCompany(companyId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}db/companies/${companyId}`).pipe(
      map((company: any) => {
        return {
          companyName: company.id_company_name,
          description: company.company_description,
          primaryColor: company.primary_color,
          secondaryColor: company.secondary_color,
          logoImg: company.logo_img,
        };
      })
    );
  }

  updateCompany(oldCompanyName: string, companyData: any): Observable<any> {
    const updateCompanyBody = {
      company_description: companyData.description,
      primary_color: companyData.primaryColor,
      secondary_color: companyData.secondaryColor,
      logo_img: companyData.logoImg,
    }
    return this.http.put(`${this.baseUrl}db/companies/${oldCompanyName}`, updateCompanyBody).pipe(
      tap(() => this.loadCompanies())
    );
  }

  private loadCompanies(): void {
    this.getCompanies().subscribe();
  }

  getRoles(): Observable<any> {
    return this.http.get(this.baseUrl + 'db/roles');
  }

  getUsers(): Observable<any> {
    return this.http.get(this.baseUrl + 'db/users').pipe(
      map((response: any) => {
        return response.map((user: any) => {
          return {
            ...user,
            valid_from_epoch: this.formatDate(user.valid_from_epoch),
            valid_until_epoch: this.formatDate(user.valid_until_epoch),
            companyName: user.company.id_company_name,
          };
        });
      }));
  }

  deleteUser(userId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}db/users/${userId}`).pipe(
      tap(() => this.loadUsers())
    );
  }
  createUser(userData: any): Observable<any> {
    const createUserBody = {
      user_id: userData.user_id,
      given_name: userData.given_name,
      surname: userData.surname,
      user_roles: userData.user_roles,
      company: userData.companyName,
    }
    return this.http.post(this.baseUrl + 'db/users', createUserBody).pipe(
      tap(() => this.loadUsers())
    );
  }

  updateUser(userId: string, userData: any): Observable<any> {
    const updateUserBody = {
      given_name: userData.given_name,
      surname: userData.surname,
      user_roles: userData.user_roles,
      company: userData.companyName,
    }
    return this.http.put(`${this.baseUrl}db/users/${userId}`, updateUserBody).pipe(
      tap(() => this.loadUsers())
    );
  }

  private loadUsers(): void {
    this.getUsers().subscribe();
  }
  private formatDate(epoch: number): string {
    const date = new Date(epoch * 1000);
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  }
}