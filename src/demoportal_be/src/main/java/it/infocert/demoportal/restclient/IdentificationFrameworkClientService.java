package it.infocert.demoportal.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;


@Consumes("application/json")
@RegisterRestClient(configKey = "IdentificationFrameworkService")
public interface IdentificationFrameworkClientService {

    /**
     * Interfaccia client del servizio di Ai Face Matching
     * 
     * @param authorization Bearer Token ottenuto dall'idp 
     * @param bodyString Json contente la richiesta verso il servizio
     *                   es    {
     *                           "request-id": "req-1234",
     *                           "images": [
     *                               {
     *                                   "image-id": "doc",
     *                                   "description": "doc1.jpg",
     *                                   "content": "[BASE64 IMAGE CONTENT OR URL]"
     *                               },
     *                               {
     *                                   "image-id": "selfie",
     *                                   "description": "selfie.jpg",
     *                                   "content": "[BASE64 IMAGE CONTENT OR URL]"
     *                               }
     * 
     *                                       ],
     *                              "options": {...}
     *                           }   
     * @return   Json respose is {
     *  "api-version": "1.0.3",
     *   "request-id": "bsdza-3c928289-333e-43c2-a5e6-d5c52500e3d9",
     *   "results": [
     *      {
     *       "pair": "selfie_01:portrait_01",
     *       "pair-description": "selfie.jpg:portrait.jpg",
     *       "match": "True",
     *       "similarity": 88.14
     *      }
     *              ]
     *   }
     */
    @Path("/identification/afm/v1/compare")
    @POST
    Uni<String> compare(@HeaderParam("Authorization") String authorization, String bodyString);
    
    /**
     * Interfaccia client per il servizio di AIDOC Reader 
     * 
     * @param authorization Bearer Token ottenuto dall'idp 
     * @param bodyString Json contente la richiesta verso il servizio
     *                   es    {
     *                           "api-version": "1.1.3",
     *                           "request-id": "req-1234",
     *                           "images": [
     *                               {
     *                                   "image-id": "A0001",
     *                                   "content": "[BASE64 IMAGE CONTENT OR URL]"
     *                               }
     *                                       ]
     *                           }   
     * @return   Json respose is made of two main sections: documents and images.  
     */
    @Path("/identification/adr/v1/idcard")
    @POST
    Uni<String> idcard(@HeaderParam("Authorization") String authorization, String bodyString);

    /**
     * Interfaccia client del servizio Veridas
     * https://apistage.infocert.digital/esolutions/ocr/v1/docverify
     * 
     * {
     *      "channel": "DEMO_VE",
     *      "requestId": "<requestId>",
     *      "document": {
     *          "images": [
     *              {
     *            "name": "front",
     *            "mimeType": "imageFront/jpg",
     *            "base64Content": "<base64-front-immage>"
     *        }
     *          ]
     *      }
     * }
     * @param authorization 
     * 
     */
    @Path("/esolutions/ocr/v1/docverify")
    @POST
    Uni<String> docverifybyveridas(@HeaderParam("Authorization") String authorization, String bodyString);

}
