import { NgModule } from '@angular/core';
import { AuthModule, LogLevel } from 'angular-auth-oidc-client';
import { environment } from '../environments/environment';

@NgModule({
  imports: [
    AuthModule.forRoot({
      config: {
        postLoginRoute: '/home',
        forbiddenRoute: '/login',
        unauthorizedRoute: '/login',
        logLevel: LogLevel.Debug,
        historyCleanupOff: true,
        authority: environment.idpUrl,
        redirectUrl: `${window.location.origin}`,
        postLogoutRedirectUri: window.location.origin + '/login',
        clientId: environment.clientId,
        scope: environment.scope,
        responseType: 'code',
        silentRenew: true,
        useRefreshToken: true
      },
    }),
  ],
  exports: [AuthModule],
})
export class AuthConfigModule {}