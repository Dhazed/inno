package it.infocert.demoportal.persistance.service;

import java.util.List;

import it.infocert.demoportal.persistance.crud.LokaliseCRUD;
import it.infocert.demoportal.persistance.entity.LokaliseTranslation;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("db/lokalise")
public class LokaliseKeyService {

  @Inject
  LokaliseCRUD keyCRUD;

  @GET
  public List<LokaliseTranslation> get() {
    return keyCRUD.getAll();
  }

  @POST
  public void insertKey(LokaliseTranslation key){
    keyCRUD.insert(key);
  }

  @GET
  @Path("{lang_iso}")
  public List<LokaliseTranslation> getbyId(@PathParam("lang_iso") String lang_iso) {
    return keyCRUD.getallkeysforLanguage(lang_iso);
  }

  @GET
  @Path("{lang_iso}/{keyid}")
  public  List<LokaliseTranslation> getbyId(@PathParam("lang_iso") String lang_iso, @PathParam("keyid") String keyid) {
    return keyCRUD.getAllTranlsationforkeyidandlang(lang_iso,keyid);
  }



  @Path("{lang_iso}/{keyid}/{translationid}")
  @PUT
  public LokaliseTranslation updateKey(LokaliseTranslation key){
    return keyCRUD.update(key);
  }

  @Path("{lang_iso}/{keyid}/{translationid}")
  @DELETE
  public void deleteKey(String translationid){
    keyCRUD.deleteTranslation(translationid);
  }

  @Path("{lang_iso}/{keyid}")
  @DELETE
  public void deleteKey(@PathParam("lang_iso") String lang_iso, @PathParam("keyid") String keyid){
    keyCRUD.deleteAllTranslationsforkeyidandlang(lang_iso, keyid);
  }
}
