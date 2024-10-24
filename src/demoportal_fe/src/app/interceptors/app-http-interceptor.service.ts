import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { finalize } from 'rxjs/operators';
import { LoaderService } from '../services/loader.service';

export const appHttpInterceptorFn: HttpInterceptorFn = (req, next) => {
  const loaderService = inject(LoaderService);

  // Controlla se l'URL contiene "/photofrommobile"
  if (!req.url.includes('/photofrommobile')) {
    loaderService.showLoader();
  }

  return next(req).pipe(
    finalize(() => {
      if (!req.url.includes('/photofrommobile')) {
        loaderService.hideLoader();
      }
    })
  );
};