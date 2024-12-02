package it.infocert.demoportal.service.isac;

import java.time.Duration;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.restclient.IsacAdminRestClient;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import io.quarkus.logging.Log; 

@Path("/isac")
@Consumes("application/json")
@Produces("application/json")
public class IsacResourceService {

    @RestClient
    IsacAdminRestClient restClient;

    /*
     * {
  "id": "paolocoll0001",
  "accountId": "paolocoll0001",
  "professionalUse": false,
  "type": "NORMAL",
  "state": {
    "state": "ACTIVE"
  },
  "capabilities": [
    {
      "value": "app"
    }
  ],
  "credential": {
    "nickname": "paolo.manzi.coll@infocert.it",
    "password": "Password01!",
    "hashed": false,
    "policy": "none",
    "state": "VALID"
  },
  "securityInformation": {
    "email": "paolo.manzi@infocert.it",
    "phone": "+393356426591"
  },
  "description": ""
}
     */


    @POST
    @Path("creation")
    public Uni<Object> createUser(String body) {
        Log.debug("User creation: " + body);
        return restClient.createIdentityUni("Bearer " + getAccessToken(), body);
    }

    @POST
    @Path("sendemail/{{identityID}}")
    public Uni<Object> sendemail(@PathParam("identityID") String identityID, String body) {
        Log.debug("User sendemail: " + identityID);
        return restClient.setCredentialUni("Bearer " + getAccessToken(), identityID , body);
    }

    private String getAccessToken() {
        String jwt = null;
        jwt = Jwt.issuer("DEMOPORTAL").subject("DEMOPORTAL").expiresIn(Duration.ofHours(1)).sign("rsaPrivateKey.pem");
        return jwt;
     }

     public static void main(String[] args) {
        Log.debug("Hello ");
        IsacResourceService dd = new IsacResourceService();
        Log.debug("JWT : " + dd.getAccessToken());
    }

}
