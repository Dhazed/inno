package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.lokalise.LokaliseResponse;


@Consumes("application/json")
@RegisterRestClient(configKey = "lokaliseservices")
@ClientHeaderParam(name = "X-Api-Token", value = "10fd3b49de733bb6bf255fa129d1baeb973284ad")
public interface LokaliseClientServices {

    /**
     * Interfaccia client del lokalise
     */
    @GET
    Uni<LokaliseResponse> listAllKeys(@QueryParam("limit") int limit, @QueryParam("page") int page);

}
