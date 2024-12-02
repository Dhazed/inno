import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, finalize, switchMap } from 'rxjs/operators';
import { LoaderService } from '../services/loader.service';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { environment } from '../../environments/environment';
import { throwError } from 'rxjs';
import { NotificationService } from '../services/notification.service';

export const appHttpInterceptorFn: HttpInterceptorFn = (req, next) => {
  const loaderService = inject(LoaderService);
  const oidcSecurityService = inject(OidcSecurityService);
  const notificationService = inject(NotificationService);

  if (!req.url.includes('/photofrommobile')) {
    loaderService.showLoader();
  }
  return oidcSecurityService.getAccessToken().pipe(
    switchMap(token => {
      const accessToken = token;
      if (accessToken && !req.url.includes('/token')) {
        req = req.clone({
          setHeaders: {
            Authorization: 'Bearer ' + accessToken
          }
        });
      }
      return next(req).pipe(
        finalize(() => {
          if (!req.url.includes('/photofrommobile')) {
            loaderService.hideLoader();
          }
        }),
        catchError(error => {
          if (error.status !== 500 && error) {
            if (error.status == 404) {
              notificationService.showNotification('Element not found', 'error');
              console.error('Not Found error: ', error);
            } else {
              notificationService.showNotification(error.error, 'error');
              console.error('Generic error: ', error);
            }
          } else {
            console.error('Server error: ', error);
          }
          return throwError(error);
        })
      );
    })
  );
  
};
