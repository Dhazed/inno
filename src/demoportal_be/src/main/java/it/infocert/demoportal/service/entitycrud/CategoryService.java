package it.infocert.demoportal.service.entitycrud;

import it.infocert.demoportal.persistance.model.Categories;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("db/categories")
public class CategoryService {

  @GET
  public Categories[] list() {
    return Categories.values();
  }
}


  