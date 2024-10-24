package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;


@Consumes("application/json")
@RegisterRestClient(configKey = "IsacIpamServices")
public interface IsacIpamClientServices {

    /**
     * Interfaccia di amministrazione isac & ipam per la creazione dell'utenza
     * 
     */
    @Path("isac/")
    @POST
    Uni<String> identities(@HeaderParam("Authorization") String authorization, String bodyString);
    

}
