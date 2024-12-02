package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;


@Consumes("application/json")
@RegisterRestClient(configKey = "isacadmin")
public interface IsacAdminRestClient {

    /**
     * Interfaccia di amministrazione isac & ipam per la creazione dell'utenza
     * 
     */
    @Path("identities")
    @POST
    Uni<Object> createIdentityUni(@HeaderParam("Authorization") String authorization,String bodyString);
   
    /**
     * Interfaccia per l'invio della mail di primo accesso 
     */
    @Path("identities/{{identityID}}/credentials")
    @POST
    Uni<Object> setCredentialUni(@HeaderParam("Authorization") String authorization,@PathParam("identityID") String identityID,String bodyString);
   

}
