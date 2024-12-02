package it.infocert.demoportal.service.lokalise;
import java.util.Iterator;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.logging.Log;
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
        Log.debug("listAllKeys from Lokalise");
        LokaliseResponse jres = lokaliserestClient.listAllKeys(400,1).await().indefinitely();
        Iterator<Key> iter = jres.keys.iterator();
        Iterator<Translation> itertranslation;
        Translation translation;
        Log.debug("Lokalise Keys Found :" + jres.keys.size());
        while (iter.hasNext()) {
            Key key = iter.next();
            itertranslation = key.getTranslations().iterator();
            Log.debug(key.getKey_name().web + " ");
            while (itertranslation.hasNext()) {
                translation = itertranslation.next();
                Log.debug(" Language " + translation.language_iso );
            }
        } 
        return jres;
    }
}

