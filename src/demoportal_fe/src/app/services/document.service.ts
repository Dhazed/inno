import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject, takeUntil } from 'rxjs';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  private baseUrl: string = environment.apiUrl || 'http://localhost:8080/';
  private stopPolling: boolean = false;

  constructor(private http: HttpClient) {}
  
  saveImageFromMobile(request: any): Observable<any> {
    return this.http.post(this.baseUrl + 'photofrommobile?idMobileSession=' + request.idMobileSession,
       {base64Content: request.base64Photo, mimeType: request.mimeType});
  }
  saveMobileSession(request: any): Observable<any> {
    return new Observable(observer => {
      const startTime = Date.now();
      const interval = setInterval(() => {
        if (this.stopPolling) {
          clearInterval(interval);
          observer.complete();
          this.stopPolling = false;
          return;
        }
        const elapsedTime = Date.now() - startTime;
        if (elapsedTime >= 3 * 60 * 1000) { // 3 minutes in milliseconds
          clearInterval(interval);
          observer.error(new Error('Timeout: Operation took longer than 3 minutes.'));
          return;
        }
        this.http.get(this.baseUrl + '/photofrommobile?idMobileSession=' + request.idMobileSession)
          .subscribe(
            (response: any) => {
              if (response.status === 'completed') {
                clearInterval(interval);
                observer.next(response);
                observer.complete();
              }
            },
            (error: any) => {
              clearInterval(interval);
              observer.error(error);
            }
          );
      }, 1000);
    });
  }

  stopSaveMobileSession(): void {
    this.stopPolling = true;
  }

  afmCompare(request: any): Observable<any> {
    return this.http.post(this.baseUrl + 'idframework/afm/compare', request);
  }
  aiDocIdCard(imageSrcs: string[], docNationalitySelected: string, docTypeSelected: string): Observable<any> {
    const docTypes = docNationalitySelected && docTypeSelected ? [docNationalitySelected + ':' + docTypeSelected] : 
             docNationalitySelected ? [docNationalitySelected] : 
             docTypeSelected ? [docTypeSelected] : ['INT:GENERIC'];

    const request = {
      "request-id": "request-12345",
      "images": [
      {
        "image-id": "document_01",
        "description": "document_01.jpg",
        "content": imageSrcs[0].replace(/^data:image\/[^;]+;base64,/, ''),
        "doc-types": docTypes
      },
      {
        "image-id": "document_02",
        "description": "document_02.jpg",
        "content": imageSrcs[1].replace(/^data:image\/[^;]+;base64,/, ''),
        "doc-types": docTypes
      }
      ],
      "options": {}
    }
    return this.http.post(this.baseUrl + 'idframework/aidoc/idcard', request);
  } 
  veridasDocVerify(request: any): Observable<any> {
    return this.http.post(this.baseUrl + 'idframework/veridas/docverify', request);
  }

  createAiDocIdCardRequest(imageSrcs: string[], docNationalitySelected: string, docTypeSelected: string): any {
    return {
      "request-id": "request-12345",
      "images": [
        {
          "image-id": "document_01",
          "description": "document_01.jpg",
          "content": imageSrcs[0].replace(/^data:image\/[^;]+;base64,/, ''),
          "doc-types": [docNationalitySelected + ':' + docTypeSelected]
        },
        {
          "image-id": "document_02",
          "description": "document_02.jpg",
          "content": imageSrcs[1].replace(/^data:image\/[^;]+;base64,/, ''),
          "doc-types": [docNationalitySelected + ':' + docTypeSelected]
        }
      ],
      "options": {}
    };
  }
}
