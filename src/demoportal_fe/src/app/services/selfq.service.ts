import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, switchMap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SelfQService {
  apiUrl = environment.apiUrl || 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  startSelfQ(body: { phoneNumber: string, email: string, lang: string, dossierType?: string }) {
    if (body.dossierType) {
      body.dossierType = 'QUICKSTART_SELFQ_ONESHOT';
    }
    return this.http.post(this.apiUrl + 'top/selfq', body);
  }

  startSelfQSSB(phoneNumber: string, email: string) {
    const body = {
      context: {
        "country": "PL",
        "method-id": "SELFID"
      },
      "process-data": {
        "external-id": "INFOCERT",
        "tenant-id": "INFOCERT",
        "assertion-format": "VC_JSON-LD_1.1",
        "subject-email": email,
        "subject-mobile": phoneNumber
      }
    }
    return this.http.post(this.apiUrl + 'selfqrcode/startProcess', body).pipe(
      switchMap((res: any) => {
        return this.http.post(this.apiUrl + 'selfqrcode/recognition', res);
      })
    );
  }

}
