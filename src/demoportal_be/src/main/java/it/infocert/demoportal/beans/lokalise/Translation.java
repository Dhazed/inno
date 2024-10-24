package it.infocert.demoportal.beans.lokalise;

import java.util.ArrayList;

public class Translation{
    public long translation_id;
    public int segment_number;
    public int key_id;
    public String language_iso;
    public String translation;
    public int modified_by;
    public String modified_by_email;
    public String modified_at;
    public int modified_at_timestamp;
    public boolean is_reviewed;
    public int reviewed_by;
    public boolean is_unverified;
    public boolean is_fuzzy;
    public int words;
    public ArrayList<Object> custom_translation_statuses;
    public Object task_id;
    public int is_untranslated;

    public Translation() {
    }
    
    public long getTranslation_id() {
        return translation_id;
    }
    public void setTranslation_id(long translation_id) {
        this.translation_id = translation_id;
    }
    public int getSegment_number() {
        return segment_number;
    }
    public void setSegment_number(int segment_number) {
        this.segment_number = segment_number;
    }
    public int getKey_id() {
        return key_id;
    }
    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }
    public String getLanguage_iso() {
        return language_iso;
    }
    public void setLanguage_iso(String language_iso) {
        this.language_iso = language_iso;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
    public int getModified_by() {
        return modified_by;
    }
    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }
    public String getModified_by_email() {
        return modified_by_email;
    }
    public void setModified_by_email(String modified_by_email) {
        this.modified_by_email = modified_by_email;
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
    public boolean isIs_reviewed() {
        return is_reviewed;
    }
    public void setIs_reviewed(boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }
    public int getReviewed_by() {
        return reviewed_by;
    }
    public void setReviewed_by(int reviewed_by) {
        this.reviewed_by = reviewed_by;
    }
    public boolean isIs_unverified() {
        return is_unverified;
    }
    public void setIs_unverified(boolean is_unverified) {
        this.is_unverified = is_unverified;
    }
    public boolean isIs_fuzzy() {
        return is_fuzzy;
    }
    public void setIs_fuzzy(boolean is_fuzzy) {
        this.is_fuzzy = is_fuzzy;
    }
    public int getWords() {
        return words;
    }
    public void setWords(int words) {
        this.words = words;
    }
    public ArrayList<Object> getCustom_translation_statuses() {
        return custom_translation_statuses;
    }
    public void setCustom_translation_statuses(ArrayList<Object> custom_translation_statuses) {
        this.custom_translation_statuses = custom_translation_statuses;
    }
    public Object getTask_id() {
        return task_id;
    }
    public void setTask_id(Object task_id) {
        this.task_id = task_id;
    }
    public int getIs_untranslated() {
        return is_untranslated;
    }
    public void setIs_untranslated(int is_untranslated) {
        this.is_untranslated = is_untranslated;
    }
}


