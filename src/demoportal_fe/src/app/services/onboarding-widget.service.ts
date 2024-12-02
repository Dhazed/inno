import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject, takeUntil } from 'rxjs';
import { environment } from '../../environments/environment';
import { map, switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OnboardingWidgetService {
  private baseUrl: string = environment.apiUrl || 'http://localhost:8080/api/';
  private stopPolling: boolean = false;

  constructor(private http: HttpClient) { }

  /* saveImageFromMobile(request: any): Observable<any> {
      return this.http.post(this.baseUrl + 'photofrommobile?idMobileSession=' + request.idMobileSession,
        { base64Content: request.base64Photo, mimeType: request.mimeType });
    }
   */
  /*   stopSaveMobileSession(): void {
      this.stopPolling = true;
    }
   */

  /*  awaitMobileSession(request: any): Observable<any> {
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
  } */

  getOnWidgetToken(presets: string[]): Observable<any> {
    const startWebProcessUrl = `${this.baseUrl}widget/startWebProcess`;
    const startIQPUrl = `${this.baseUrl}widget/startIQP`;

    const startWebProcessBody = {
      processId: 'BMED_BIOMETRICS',
    };

    return this.http.post(startWebProcessUrl, startWebProcessBody).pipe(
      switchMap((webProcessResponse: any) => {
       /*   const startIQPBody = {
           processId: 'BMED_BIOMETRICS',
           presets: [presets[0]],
           metadata: {
             owWebProcessId: webProcessResponse.id
           }
         }; */
        const startIQPBody = {
          processId: 'BMED_BIOMETRICS',
          presets: ['P_BMED_BIOMETRICS'],
          metadata: {
            owWebProcessId: webProcessResponse.id
          }
        };
        return this.http.post(startIQPUrl, startIQPBody).pipe(
          map((iqpResponse: any) => ({
            sessionId: webProcessResponse.sessionId
          }))
        );
      })
    );
  }

  getRefreshToken(sessionId: string): Observable<any> {
    return this.http.post(this.baseUrl + 'widget/refreshToken', { sessionId });
  }

}