package it.infocert.demoportal.restclient;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.OneClickEnrolmentProcessStart;

@RegisterRestClient(configKey = "TopOCE")
public interface TopClient {

    /**
     * Interfaccia Top CreateDossier SOAP
     */
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    @Path("services/OnboardingService")
    @POST
    Uni<String> CreateDossier(String bodyString);
    
    @Path("rest10/process/{{tokenID}}/start")
    @POST
    Uni<OneClickEnrolmentProcessStart> processStart(@PathParam("tokenID") String tokenID);

    @Path("rest10/oneshot/{{taskID}}/start")
    @POST
    Uni<Object> oneclickStart(@PathParam("taskID") String taskID);

    @Path("rest10/oneshot/{{taskID}}/register")
    @POST
    Uni<Object> oneclickRegister(@PathParam("taskID") String taskID, String bodyString);

    @Path("rest10/oneshot/{{taskID}}/sendotp")
    @POST
    Uni<Object> oneclicksendotp(@PathParam("taskID") String taskID, String bodyString);

    @Path("rest10/oneshot/{{taskID}}/issueandsign")
    @POST
    Uni<Object> oneclickissueandsign(@PathParam("taskID") String taskID, String bodyString);


}
