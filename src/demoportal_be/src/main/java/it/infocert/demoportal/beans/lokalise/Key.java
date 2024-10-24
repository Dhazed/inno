package it.infocert.demoportal.beans.lokalise;

import java.util.ArrayList;


public class Key{
    public int key_id;
    public String created_at;
    public int created_at_timestamp;
    public KeyName key_name;
    public Filenames filenames;
    public String description;
    public ArrayList<String> platforms;
    public ArrayList<Object> tags;
    public ArrayList<Translation> translations;
    public boolean is_plural;
    public String plural_name;
    public boolean is_hidden;
    public boolean is_archived;
    public String context;
    public int base_words;
    public int char_limit;
    public String custom_attributes;
    public String modified_at;
    public int modified_at_timestamp;
    public String translations_modified_at;
    public int translations_modified_at_timestamp;
    
    public int getKey_id() {
        return key_id;
    }
    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public int getCreated_at_timestamp() {
        return created_at_timestamp;
    }
    public void setCreated_at_timestamp(int created_at_timestamp) {
        this.created_at_timestamp = created_at_timestamp;
    }
    public KeyName getKey_name() {
        return key_name;
    }
    public void setKey_name(KeyName key_name) {
        this.key_name = key_name;
    }
    public Filenames getFilenames() {
        return filenames;
    }
    public void setFilenames(Filenames filenames) {
        this.filenames = filenames;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<String> getPlatforms() {
        return platforms;
    }
    public void setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
    }
    public ArrayList<Object> getTags() {
        return tags;
    }
    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }
    public ArrayList<Translation> getTranslations() {
        return translations;
    }
    public void setTranslations(ArrayList<Translation> translations) {
        this.translations = translations;
    }
    public boolean isIs_plural() {
        return is_plural;
    }
    public void setIs_plural(boolean is_plural) {
        this.is_plural = is_plural;
    }
    public String getPlural_name() {
        return plural_name;
    }
    public void setPlural_name(String plural_name) {
        this.plural_name = plural_name;
    }
    public boolean isIs_hidden() {
        return is_hidden;
    }
    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }
    public boolean isIs_archived() {
        return is_archived;
    }
    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public int getBase_words() {
        return base_words;
    }
    public void setBase_words(int base_words) {
        this.base_words = base_words;
    }
    public int getChar_limit() {
        return char_limit;
    }
    public void setChar_limit(int char_limit) {
        this.char_limit = char_limit;
    }
    public String getCustom_attributes() {
        return custom_attributes;
    }
    public void setCustom_attributes(String custom_attributes) {
        this.custom_attributes = custom_attributes;
    }
    public String getModified_at() {
        return modified_at;
    }
    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }
    public int getModified_at_timestamp() {
        return modified_at_timestamp;
    }
    public void setModified_at_timestamp(int modified_at_timestamp) {
        this.modified_at_timestamp = modified_at_timestamp;
    }
    public String getTranslations_modified_at() {
        return translations_modified_at;
    }
    public void setTranslations_modified_at(String translations_modified_at) {
        this.translations_modified_at = translations_modified_at;
    }
    public int getTranslations_modified_at_timestamp() {
        return translations_modified_at_timestamp;
    }
    public void setTranslations_modified_at_timestamp(int translations_modified_at_timestamp) {
        this.translations_modified_at_timestamp = translations_modified_at_timestamp;
    }
}
