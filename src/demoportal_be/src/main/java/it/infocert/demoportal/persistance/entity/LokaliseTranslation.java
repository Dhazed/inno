package it.infocert.demoportal.persistance.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LokaliseTranslation extends PanacheEntityBase {

    @Id
    @Column(name = "translation_id")
    public long translation_id;
    
    @Column(name = "key_id")
    public int key_id;

    @Column(name = "web_key_name")
    public String web_key_name;

    @Column(name = "lang_iso", length = 5 )
    public String lang_iso;

    @Column(name = "translation", length = 4000)
    public String translation;

    @Column(name = "translation_modified_at_timestamp")
    public int translation_modified_at_timestamp;

    @Column(name = "modified_locally_at_timestamp")
    public int modified_locally_at_timestamp;

    @Column(name = "is_untranslated")
    public Boolean is_untranslated;

    public LokaliseTranslation(long translation_id, int key_id, String web_key_name, String lang_iso, String translation,
            int translation_modified_at_timestamp, int modified_locally_at_timestamp,
            Boolean is_untranslated) {
        this.translation_id = translation_id;
        this.key_id = key_id;
        this.web_key_name = web_key_name;
        this.lang_iso = lang_iso;
        this.translation = translation;
        this.translation_modified_at_timestamp = translation_modified_at_timestamp;
        this.modified_locally_at_timestamp = modified_locally_at_timestamp;
        this.is_untranslated = is_untranslated;
    }

    public LokaliseTranslation() {
    }

    public long getTranslation_id() {
        return translation_id;
    }

    public void setTranslation_id(int translation_id) {
        this.translation_id = translation_id;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public String getLang_iso() {
        return lang_iso;
    }

    public void setLang_iso(String lang_iso) {
        this.lang_iso = lang_iso;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Boolean getIs_untranslated() {
        return is_untranslated;
    }

    public void setIs_untranslated(Boolean is_untranslated) {
        this.is_untranslated = is_untranslated;
    }

    public String getWeb_key_name() {
        return web_key_name;
    }

    public void setWeb_key_name(String web_key_name) {
        this.web_key_name = web_key_name;
    }

    public int getTranslation_modified_at_timestamp() {
        return translation_modified_at_timestamp;
    }

    public void setTranslation_modified_at_timestamp(int translation_modified_at_timestamp) {
        this.translation_modified_at_timestamp = translation_modified_at_timestamp;
    }

    public int getModified_locally_at_timestamp() {
        return modified_locally_at_timestamp;
    }

    public void setModified_locally_at_timestamp(int modified_locally_at_timestamp) {
        this.modified_locally_at_timestamp = modified_locally_at_timestamp;
    }

}
