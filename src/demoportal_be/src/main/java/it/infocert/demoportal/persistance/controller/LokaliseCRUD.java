package it.infocert.demoportal.persistance.controller;

import java.util.List;

import io.quarkus.logging.Log;
import it.infocert.demoportal.persistance.model.LokaliseTranslations;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LokaliseCRUD {

     public List<LokaliseTranslations> getAll() {
      return LokaliseTranslations.findAll().list();
    }

    public List<LokaliseTranslations> getallkeysforLanguage(String lang_iso) {
       Log.debug(lang_iso);
       return LokaliseTranslations.list("lang_iso = ?1", lang_iso);
      }
   
    
    public List<LokaliseTranslations> getAllTranlsationforkeyidandlang(String lang_iso, String key_id) {
       return LokaliseTranslations.list("lang_iso = ?1 and key_id = ?2",lang_iso,key_id);
    }

    
    public LokaliseTranslations update(LokaliseTranslations key) {
      LokaliseTranslations entity = LokaliseTranslations.findById(key.translation_id);
      entity = key;
      return entity;
    }

    @Transactional
    public void deleteAllTranslationsforkeyidandlang(String lang_iso, String key_id) {
      LokaliseTranslations.delete("lang_iso = ?1 and key_id = ?2",lang_iso, key_id);
    }
    
    @Transactional
    public void deleteTranslation(String translation_id) {
      LokaliseTranslations.delete("translation_id =?1", translation_id);
    }

    @Transactional
    public void insert(LokaliseTranslations LokaliseTranslations) {
      LokaliseTranslations.persist();
    }

}
