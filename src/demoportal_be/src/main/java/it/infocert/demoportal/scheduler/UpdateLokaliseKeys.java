package it.infocert.demoportal.scheduler;

import java.util.Iterator;

import it.infocert.demoportal.beans.lokalise.Key;
import it.infocert.demoportal.beans.lokalise.LokaliseResponse;
import it.infocert.demoportal.beans.lokalise.Translation;
import it.infocert.demoportal.persistance.entity.LokaliseTranslation;
import it.infocert.demoportal.resources.LokaliseResource;

public class UpdateLokaliseKeys {

    LokaliseResource lokaliseClientServices;
    
    public UpdateLokaliseKeys() {
    }

    public static void main(String[] args) {
        UpdateLokaliseKeys dd = new UpdateLokaliseKeys();
        dd.allignLokalisewithDB();
    }



    //    @Scheduled(cron = "{lokalise.cron.expr}")
    void allignLokalisewithDB() {
        System.out.println("Started allignLokalisewithDB with Cron expression configured in application.properties");
        // get key from lokalise with pagination
        // for all keys retrived
        // if not present into db - Insert.
        // if present and non modified from lokalise - nothing
        // if present and modified in lokalise - update
        // if present and modified db - update lokalise and db
        int page = 1;
        int limit = 400;

        for (page = 1; page < 20; page++) {
            LokaliseResponse jres = lokaliseClientServices.listAllKeys();
            System.out.println("From Lokalise was Found :" + jres.keys.size() + " keys");
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
                    translationsIterator = lokaliseKey.getTranslations().iterator();
                    // System.out.println(key.getKey_name().web + " ");
                    while (translationsIterator.hasNext()) {
                        translation = translationsIterator.next();
                        LokaliseTranslation tLokaliseTranslation = new LokaliseTranslation(translation.translation_id,
                                translation.key_id, lokaliseKey.key_name.web, translation.language_iso, translation.translation,
                                translation.modified_at_timestamp, translation.modified_at_timestamp,
                                translation.is_untranslated == 0 ? true : false);
                        tLokaliseTranslation.persistAndFlush();
                        System.out.println("Traslation with id = " + translation.translation_id + " for Language "
                                + translation.language_iso + "Stored into local DB");
                    }
                    // if all OK commit

                } else {
                    // key and traslations are present
                    translationsIterator = lokaliseKey.getTranslations().iterator();
                    while (translationsIterator.hasNext()) {
                        translation = translationsIterator.next();
                        System.out.println("working on translation.translation_id" + translation.translation_id);
                        LokaliseTranslation tLokaliseTranslation = LokaliseTranslation
                                .findById(translation.translation_id);
                        if (tLokaliseTranslation != null) {
                            // apply logic to last update
                            if (translation.modified_at_timestamp >= tLokaliseTranslation.translation_modified_at_timestamp) {
                                System.out
                                        .println("Traslation with id = " + translation.translation_id + " for Language "
                                                + translation.language_iso + "Modified on lokalise");
                                // modified on lokalise
                                // update

                            } else {
                                if (translation.modified_at_timestamp < tLokaliseTranslation.modified_locally_at_timestamp) {
                                    System.out.println(
                                            "Traslation with id = " + translation.translation_id + " for Language "
                                                    + translation.language_iso + "was modified on DemoPortal");
                                    System.out.println("needs to be update on lokalise");
                                    // modify lokalise
                                    // update?
                                }
                            }

                        }

                    }
                }
            }

        }
    }

}
