package it.infocert.demoportal.service.idframework;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.runtime.TokensHelper;
import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.restclient.IdentificationFrameworkClientService;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/idframework")
@Consumes("application/json")
@Produces("application/json")
public class IdentificationResourceService  {

    @Inject
    OidcClient client;
    
    TokensHelper tokenHelper = new TokensHelper();
   
    @RestClient
    IdentificationFrameworkClientService restClient; 

    @POST
    @Path("afm/compare")
    public Uni<Object> afmcompare(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.compare("Bearer " + tokens.getAccessToken(),body));
    }

    @POST
    @Path("aidoc/idcard")
    public Uni<Object> aidocreader(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.idcard("Bearer " + tokens.getAccessToken(),body));
    }

    @POST
    @Path("veridas/docverify")
    public Uni<Object> veridasdocreader(String body) {
        return tokenHelper.getTokens(client).onItem().transformToUni(tokens -> restClient.docverifybyveridas("Bearer " + tokens.getAccessToken(),body));
    }
}

