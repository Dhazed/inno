package it.infocert.demoportal.service.top;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import io.quarkus.logging.Log;
import it.infocert.demoportal.beans.SelfQRequest;
import it.infocert.demoportal.beans.TopSoapSelfQRes;
import it.infocert.demoportal.beans.onboarding.brutal.CreateDossierBrutal;
import it.infocert.demoportal.restclient.SelfQRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Path("/top")
public class TopResourceServices {

    @Path("/ping")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Rest Service Interface for TOP Application";
    }

    @RestClient
    SelfQRestClient restClient;

    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("selfq")
    public TopSoapSelfQRes startSelfQ(SelfQRequest req) throws Exception {
        Log.debug("Dossier Type req= " + req.getDossierType());
        CreateDossierBrutal createDossier = new CreateDossierBrutal(req.getDossierType(), req.getLang(), req.getEmail(), req.getPhoneNumber());
        String soapResXML = restClient.selfQ(createDossier.getSoapBodyRequest()).await().indefinitely();
        Log.debug("soap response:\n" + soapResXML);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(soapResXML.getBytes());
        Document doc = db.parse(inputStream);
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("tokens");
        TopSoapSelfQRes response = new TopSoapSelfQRes(list.item(0).getTextContent());
        return response;
    }

}
