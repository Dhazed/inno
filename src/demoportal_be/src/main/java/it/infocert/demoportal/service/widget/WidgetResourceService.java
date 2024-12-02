package it.infocert.demoportal.service.widget;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.logging.Log;
import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.runtime.TokensHelper;
import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.RefreshToken;
import it.infocert.demoportal.beans.RefreshTokenReq;
import it.infocert.demoportal.persistance.controller.OnboardingStartProcessResponse;
import it.infocert.demoportal.persistance.model.OnboardingProcess;
import it.infocert.demoportal.restclient.WidgetClientService;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/widget")
@Consumes("application/json")
@Produces("application/json")
public class WidgetResourceService  {

    @Inject
    OidcClient client;
    
    TokensHelper tokenHelper = new TokensHelper();
   
    @RestClient
    WidgetClientService restClient; 

    @POST
    @Path("/startWebProcess")
    @Transactional
    public OnboardingStartProcessResponse startWebProcess(String body) {
        OnboardingStartProcessResponse res = (OnboardingStartProcessResponse) tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.startWebProcess("Bearer " + tokens.getAccessToken(),body)).await().indefinitely();
        OnboardingProcess entity = new OnboardingProcess();
        entity.setId(res.id);
        entity.setRefreshToken(res.refreshToken);
        entity.setSessionId(res.sessionId);
        entity.setToken(res.token);
        entity.persist();
        return res;
    }

    @POST
    @Path("/startIQP")
    public Uni<Object> startIQP(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.startIQP("Bearer " + tokens.getAccessToken(),body));
    }

    @POST
    @Path("/regenerateToken")
    public Uni<Object> regenerateToken(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.regenerateToken("Bearer " + tokens.getAccessToken(),body));
    }

    @POST
    @Path("/refreshToken")
    @Transactional
    public Uni<Object> tokenRefresh(RefreshTokenReq refreshTokenReq) {
        Log.debug(refreshTokenReq.getSessionId());
        OnboardingProcess owsession = OnboardingProcess.findById(refreshTokenReq.getSessionId());
        Log.debug(owsession);
        if (owsession == null) {
         throw new NotFoundException("SessionId " + refreshTokenReq.getSessionId() + "does not exist.");
        }
        RefreshToken rt = new RefreshToken(owsession.getRefreshToken());
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.refreshToken("Bearer " + tokens.getAccessToken(),rt));
    }
}

