package it.infocert.demoportal.persistance.models;

import java.sql.Date;

public class LangLabel {
    
    public Integer id;
    public String lang_iso;
    public int key_id;
    public String key_name;
    public String translation;
    public int translation_id;
    public Date last_lokalise_update;
    public Date last_demoportal_update;
    

    public LangLabel(String lang_iso, int key_id, String key_name, String translation,
            int translation_id, Date last_lokalise_update, Date last_demoportal_update) {
        this.lang_iso = lang_iso;
        this.key_id = key_id;
        this.key_name = key_name;
        this.translation = translation;
        this.translation_id = translation_id;
        this.last_lokalise_update = last_lokalise_update;
        this.last_demoportal_update = last_demoportal_update;
    }
    

    public String getLang_iso() {
        return lang_iso;
    }
    
    public void setLang_iso(String lang_iso) {
        this.lang_iso = lang_iso;
    }
    public int getKey_id() {
        return key_id;
    }
    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }
    public String getKey_name() {
        return key_name;
    }
    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getTranslation_id() {
        return translation_id;
    }

    public void setTranslation_id(int translation_id) {
        this.translation_id = translation_id;
    }

    public Date getLast_lokalise_update() {
        return last_lokalise_update;
    }

    public void setLast_lokalise_update(Date last_lokalise_update) {
        this.last_lokalise_update = last_lokalise_update;
    }

    public Date getLast_demoportal_update() {
        return last_demoportal_update;
    }

    public void setLast_demoportal_update(Date last_demoportal_update) {
        this.last_demoportal_update = last_demoportal_update;
    }

}
