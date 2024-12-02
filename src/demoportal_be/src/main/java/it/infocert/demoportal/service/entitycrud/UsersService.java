package it.infocert.demoportal.service.entitycrud;

import java.util.List;

import it.infocert.demoportal.persistance.model.Users;
import it.infocert.demoportal.persistance.repository.UsersRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("db/users")
public class UsersService {

  @Inject
  UsersRepository repository;
  

  @GET
  public List<Users> get() {
    return repository.listAll();
  }

  @POST
  @Transactional
  public Response create(Users newuser) {
    if (newuser.user_id == null) {
      throw new WebApplicationException("User Mail was invalidly set on request.", 422);
  }
  repository.persist(newuser);
  return Response.ok(newuser).status(201).build();  
    }
  

  @PUT
  @Transactional
  @Path("{user_id}")
  public Response update(@PathParam("user_id") String user_id, Users user) {
    return repository
                .findByIdOptional(user_id).map(
                        t -> {
                            t.company = user.company;
                            t.given_name = user.given_name;
                            t.user_roles = user.user_roles;
                            t.surname = user.surname;
                            t.is_active = user.is_active;
                            return Response.status(204).build();
                        })
                .orElse(Response.status(Status.NOT_FOUND).build());
  }

  @GET
  @Path("{user_id}")
  public Response getbyId(@PathParam("user_id") String user_id) {
    return repository
    .findByIdOptional(user_id)
    .map(d -> Response.ok(d).build())
    .orElse(Response.status(204).build());
  }

  @DELETE
  @Transactional
  @Path("{user_id}")
  public Response delete(@PathParam("user_id") String user_id) {
    repository.delete("user_id", user_id);
    return Response.status(204).build();
  }
}
