package it.infocert.demoportal.persistance.service;

import java.util.List;

import it.infocert.demoportal.persistance.crud.DemoPortalUserCRUD;
import it.infocert.demoportal.persistance.entity.DemoPortalUser;
import it.infocert.demoportal.persistance.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("persistence/user")
@Consumes("application/json")
@Produces("application/json")
public class DemoPortalUserService {

  @Inject
  DemoPortalUserCRUD userCRUD;

  @GET
  public List<User> get() {
    return userCRUD.getAll();
  }

  @GET
  @Path("{userid}")
  public User getbyId(@PathParam("userid") String userid) {
    return userCRUD.getbyEmail(userid);
  }

  @POST
  public DemoPortalUser insertUser(User user){
    return userCRUD.insert(user);
  }

  @PUT
  public DemoPortalUser updateUser(User user){
    return userCRUD.update(user);
  }

  @DELETE
  public void deleteUser(String userid){
    userCRUD.delete(userid);
  }

}
