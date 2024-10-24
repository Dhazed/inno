package it.infocert.demoportal.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/top")
public class TopResourceServices {

    
    @Path("/ping")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Rest Service Interface for TOP Application";
    }

}
