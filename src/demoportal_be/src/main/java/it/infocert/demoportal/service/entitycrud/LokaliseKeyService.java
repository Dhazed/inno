package it.infocert.demoportal.service.entitycrud;

import java.util.List;

import it.infocert.demoportal.persistance.controller.LokaliseCRUD;
import it.infocert.demoportal.persistance.model.LokaliseTranslations;
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
  public List<LokaliseTranslations> get() {
    return keyCRUD.getAll();
  }

  @POST
  public void insertKey(LokaliseTranslations key){
    keyCRUD.insert(key);
  }

  @GET
  @Path("{lang_iso}")
  public List<LokaliseTranslations> getbyId(@PathParam("lang_iso") String lang_iso) {
    return keyCRUD.getallkeysforLanguage(lang_iso);
  }

  @GET
  @Path("{lang_iso}/{keyid}")
  public  List<LokaliseTranslations> getbyId(@PathParam("lang_iso") String lang_iso, @PathParam("keyid") String keyid) {
    return keyCRUD.getAllTranlsationforkeyidandlang(lang_iso,keyid);
  }

  @Path("{lang_iso}/{keyid}/{translationid}")
  @PUT
  public LokaliseTranslations updateKey(LokaliseTranslations key){
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
