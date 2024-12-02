package it.infocert.demoportal.service.entitycrud;

import it.infocert.demoportal.persistance.model.Roles;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("db/roles")
public class RoleService {

  @GET
  public Roles[] list() {
    return Roles.values();
  }
}


  