package it.infocert.demoportal.resources;

import java.util.Iterator;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import it.infocert.demoportal.beans.lokalise.Key;
import it.infocert.demoportal.beans.lokalise.LokaliseResponse;
import it.infocert.demoportal.beans.lokalise.Translation;
import it.infocert.demoportal.persistance.entity.LokaliseTranslation;
import it.infocert.demoportal.restclient.LokaliseClientServices;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/api/lokalise/sceduled")
public class LokaliseResourceSceduled {

    @RestClient
    LokaliseClientServices lokaliserestClient;

    @GET
    public LokaliseResponse listAllKeys(@DefaultValue("1") @QueryParam("page") int page) {
        LokaliseResponse jres = lokaliserestClient.listAllKeys(300, page).await().indefinitely();
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
                System.out.println(" Language " + translation.language_iso);
                // System.out.println("Text " + translation.translation );
            }
        }
        return jres;
    }

    @Path("updateDB")
    @GET
    public boolean updateDB() {
        allignLokalisewithDB();
        return true;

    }

    // @Scheduled(every = "10s")
    @Transactional
    void allignLokalisewithDB() {
        System.out.println("Started allignLokalisewithDB with Cron expression configured in application.properties");
        // get key from lokalise with pagination
        // for all keys retrived
        // if not present into db - Insert.
        // if present and non modified from lokalise - nothing
        // if present and modified in lokalise - update
        // if present and modified db - update lokalise and db
        int page = 1;
        int limit = 300;
        for (page = 1; page < 20; page++) {
            LokaliseResponse jres = lokaliserestClient.listAllKeys(limit, page).await().indefinitely();
            System.out.println("Page = " + page + " From Lokalise was Found :" + jres.keys.size() + " keys");
            if (jres.keys.size() == 0) {
                // stop iteration
                System.out.println("End Flow");
                return;
            }
            Iterator<Key> keysIterator = jres.keys.iterator();
            Iterator<Translation> translationsIterator;
            Translation translation;
            while (keysIterator.hasNext()) {
                Key lokaliseKey = keysIterator.next();
                if (LokaliseTranslation.count("key_id = ?1", lokaliseKey.key_id) == 0) {
                    // insert all , key and traslations
                    insertAll(lokaliseKey);
                    // if all OK commit
                } else {
                    // key and traslations are present
                    translationsIterator = lokaliseKey.getTranslations().iterator();
                    while (translationsIterator.hasNext()) {
                        translation = translationsIterator.next();
                        System.out.println("working on translation_id " + translation.translation_id);
                        LokaliseTranslation tLokaliseTranslation = LokaliseTranslation
                                .findById(translation.translation_id);
                        if (tLokaliseTranslation != null) {
                            // apply logic to last update
                            if (translation.modified_at_timestamp > tLokaliseTranslation.translation_modified_at_timestamp) {
                                System.out
                                        .println("Traslation with id = " + translation.translation_id
                                                + " for Language "
                                                + translation.language_iso + " was modified on lokalise");
                                // modified on lokalise
                                // update
                                tLokaliseTranslation.translation = translation.translation;
                                tLokaliseTranslation.translation_modified_at_timestamp = translation.modified_at_timestamp;
                                tLokaliseTranslation.is_untranslated = translation.is_untranslated == 0 ? true : false;
                            } else {
                                if (translation.modified_at_timestamp < tLokaliseTranslation.modified_locally_at_timestamp) {
                                    System.out
                                            .println("Traslation with id = " + translation.translation_id
                                                    + " for Language "
                                                    + translation.language_iso
                                                    + "was modified by DemoPortal and non allined to lokalise jet");
                                    // allign lokalise to local version
                                } else {
                                    System.out.println("Traslation is OK ");
                                }
                            }
                        } else {
                            System.err.println("Some kind of error on traslation db table");
                        }
                    }
                }
            }
        }

    }

    @Transactional
    void insertAll(Key lokaliseKey) {
        Translation translation;
        // insert all , key and traslations
        Iterator<Translation> translationsIterator = lokaliseKey.getTranslations().iterator();
        // System.out.println(key.getKey_name().web + " ");
        while (translationsIterator.hasNext()) {
            translation = translationsIterator.next();
            LokaliseTranslation tLokaliseTranslation = new LokaliseTranslation(translation.translation_id,
                    translation.key_id, lokaliseKey.key_name.web, translation.language_iso, translation.translation,
                    translation.modified_at_timestamp, translation.modified_at_timestamp,
                    translation.is_untranslated == 0 ? true : false);
            tLokaliseTranslation.persist();
            System.out.println("Traslation with id = " + translation.translation_id + " for Language "
                    + translation.language_iso + " stored into local DB");
        }
    }

}
