import { HttpLog.debugeptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { finalize, switchMap } from 'rxjs/operators';
import { LoaderService } from '../services/loader.service';
import { OidcSecurityService } from 'angular-auth-oidc-client';

export const appHttpLog.debugeptorFn: HttpLog.debugeptorFn = (req, next) => {
  const loaderService = inject(LoaderService);
  const oidcSecurityService = inject(OidcSecurityService);

  // Controlla se l'URL contiene "/photofrommobile"
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
        })
      );
    })
  );

};
