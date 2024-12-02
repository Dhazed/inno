package it.infocert.demoportal.restclient;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.rest.client.reactive.ClientBasicAuth;
import io.smallrye.mutiny.Uni;


@RegisterRestClient(configKey = "SelfQClient")
@ClientBasicAuth(username = "${SelfQClient.username}", password = "${SelfQClient.password}")
public interface SelfQRestClient {


    /**
     * Interfaccia selfQ with SMS 
     */
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("OnboardingService")
    @POST
    Uni<String> selfQ(String bodyString);
    
}
