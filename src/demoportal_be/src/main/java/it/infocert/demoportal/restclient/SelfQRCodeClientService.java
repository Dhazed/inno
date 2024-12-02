package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.SelfQRCodeRes;


@Consumes("application/json")
@Produces("application/json")
@RegisterRestClient(configKey = "SelfQRCode")
public interface SelfQRCodeClientService {

    /*
     * {
    "context": {
        "country": "PL",
        "method-id": "SELFID"
    },
    "process-data": {
        "external-id": "<external-id>",
        "tenant-id": "INFOCERT",
        "assertion-format": "VC_JSON-LD_1.1",
        "subject-email": "<email>",
        "subject-mobile": "<phone_number>"
    }
}
     */

    @Path("identifications")
    @POST
    Uni<SelfQRCodeRes> startProcess(@HeaderParam("Authorization") String authorization, String bodyString);
    
    //
    /*
     * {
     *     "redirect-url": "https://www.infocert.it"
     * }
     */

    @Path("identifications/{process_id}/action/recognition")
    @POST
    Uni<Object> recognize(@HeaderParam("Authorization") String authorization, @PathParam("process_id") String process_id, String bodyString);

}
