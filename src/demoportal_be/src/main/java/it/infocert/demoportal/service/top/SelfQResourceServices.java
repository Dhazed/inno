package it.infocert.demoportal.service.top;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.runtime.TokensHelper;
import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.SelfQRCodeRes;
import it.infocert.demoportal.restclient.SelfQRCodeClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/selfqrcode")
public class SelfQResourceServices {

    @Inject
    OidcClient client;

    TokensHelper tokenHelper = new TokensHelper();

    @RestClient
    SelfQRCodeClientService restClient;

    @POST
    @Path("startProcess")
    public Uni<Object> startSelfQRCode(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.startProcess("Bearer " + tokens.getAccessToken(),body));
    }

    @POST
    @Path("recognition")
    public Uni<Object> recognition(SelfQRCodeRes body) {
        String fixRedirect = "{\"redirect-url\": \"https://www.infocert.it\"}";
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.recognize("Bearer " + tokens.getAccessToken(),body.getProcessId(),fixRedirect));
 
    }

}
