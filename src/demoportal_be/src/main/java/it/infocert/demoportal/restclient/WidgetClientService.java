package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import it.infocert.demoportal.beans.RefreshToken;
import it.infocert.demoportal.persistance.controller.OnboardingStartProcessResponse;


@Consumes("application/json")
@Produces("application/json")
@RegisterRestClient(configKey = "OnboardingWidget")
public interface WidgetClientService {

    /*
     * '{
     *     "processId": "BMED_BIOMETRICS" 
     *   }'
     */
    @Path("onboarding/widget/v1/openid/webprocess-start")
    @POST
    Uni<OnboardingStartProcessResponse> startWebProcess(@HeaderParam("Authorization") String authorization, String bodyString);
    
 
    /*
     * '{
     "processId": "BMED_BIOMETRICS",
     "presets": ["P_BMED_BIOMETRICS"],
     "metadata": {
        "owWebProcessId": "null"
     }
    }'
     */
    
    @Path("identification/iqp/v1/process/instance")
    @POST
    Uni<String> startIQP(@HeaderParam("Authorization") String authorization, String bodyString);

    /*
     * {
     *  "refreshToken": "{{refreshToken}}"
     * }
     */
   
    @Path("onboarding/widget/v1/openid/token-regenerate")
    @POST
    Uni<String> regenerateToken(@HeaderParam("Authorization") String authorization, String bodyString);

    /*
     * {
     * "refreshToken": "null"
     * }'
     */
   

     @Path("/onboarding/widget/v1/openid/token-refresh")
     @POST
     Uni<String> refreshToken(@HeaderParam("Authorization") String authorization, RefreshToken bodyString);
 
 

}
