package it.infocert.demoportal.persistance.crud;

import java.util.List;
import it.infocert.demoportal.persistance.entity.LokaliseTranslation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LokaliseCRUD {

     public List<LokaliseTranslation> getAll() {
      return LokaliseTranslation.findAll().list();
    }

    public List<LokaliseTranslation> getallkeysforLanguage(String lang_iso) {
       System.out.println(lang_iso);
       return LokaliseTranslation.list("lang_iso = ?1", lang_iso);
      }
   
    
    public List<LokaliseTranslation> getAllTranlsationforkeyidandlang(String lang_iso, String key_id) {
       return LokaliseTranslation.list("lang_iso = ?1 and key_id = ?2",lang_iso,key_id);
    }

    
    @Transactional
    public LokaliseTranslation update(LokaliseTranslation key) {
      LokaliseTranslation lokaliseTranslation = LokaliseTranslation.findById(key.translation_id);
      lokaliseTranslation = key;
      return lokaliseTranslation;
    }

    @Transactional
    public void deleteAllTranslationsforkeyidandlang(String lang_iso, String key_id) {
      LokaliseTranslation.delete("lang_iso = ?1 and key_id = ?2",lang_iso, key_id);
    }
    
    @Transactional
    public void deleteTranslation(String translation_id) {
      LokaliseTranslation.delete("translation_id =?1", translation_id);
    }

    @Transactional
    public void insert(LokaliseTranslation lokaliseTranslation) {
      lokaliseTranslation.persist();
    }

}
