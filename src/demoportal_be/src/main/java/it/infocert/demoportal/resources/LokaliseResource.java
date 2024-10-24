package it.infocert.demoportal.resources;
import java.util.Iterator;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import it.infocert.demoportal.beans.lokalise.Key;
import it.infocert.demoportal.beans.lokalise.LokaliseResponse;
import it.infocert.demoportal.beans.lokalise.Translation;
import it.infocert.demoportal.restclient.LokaliseClientServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("/api/lokalise")
public class LokaliseResource {

    @RestClient
    LokaliseClientServices lokaliserestClient; 

    @GET
    public LokaliseResponse listAllKeys() {
        LokaliseResponse jres = lokaliserestClient.listAllKeys(400,1).await().indefinitely();

        Iterator<Key> iter = jres.keys.iterator();
        Iterator<Translation> itertranslation;
        Translation translation;
        System.out.println("Lokalise Keys Found :" + jres.keys.size());
        while (iter.hasNext()) {
            Key key = iter.next();
            itertranslation = key.getTranslations().iterator();
            // System.out.println(key.getKey_name().web + " ");
            while (itertranslation.hasNext()) {
                translation = itertranslation.next();
                System.out.println(" Language " + translation.language_iso );
              //  System.out.println("Text " + translation.translation );
            }
        } 
        return jres;
    }
}

