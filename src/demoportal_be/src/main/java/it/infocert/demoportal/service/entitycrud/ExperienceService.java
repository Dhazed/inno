package it.infocert.demoportal.service.entitycrud;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.directory.InvalidAttributesException;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import it.infocert.demoportal.persistance.model.Experiences;
import it.infocert.demoportal.persistance.repository.ExperiencesRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("db/experiences")
public class ExperienceService {

  @Inject
  ExperiencesRepository repository;

  @GET
  public List<Experiences> get() {
    return repository.listAll(Sort.by("experience_name"));
  }

  @POST
  @Transactional
  public Response create(Experiences newex) {
      try {
        if (repository.findByIdOptional(newex.experience_id).isPresent()) {
          return Response.status(Status.CONFLICT).entity("Duplicate").build();
        }
        newex.experience_name = newex.experience_name.toUpperCase();
        repository.persist(newex);  
        return  Response.ok(newex).status(Status.CREATED).build();
        } catch (Exception e) {
            Log.debug(e);
            if (e instanceof InvalidAttributesException) {
                return Response.status(Status.CONFLICT).entity(Map.of("message", e.getMessage())).build();
            }
            return Response.status(Status.BAD_REQUEST).build();
        }
  }

  @PUT
  @Transactional
  @Path("{experience_id}")
  public Response update(@PathParam("experience_id") Long experienceId, Experiences experience) {
    return repository
        .findByIdOptional(experienceId).map(
            t -> {
              // t.id_company_name = company.id_company_name;
              t.experience_name = experience.experience_name;
              t.experience_category = experience.experience_category;
              t.dt_last_modified = experience.dt_last_modified;
              t.is_active = experience.is_active;
              t.is_betaversion = experience.is_betaversion;
              return Response.status(204).build();
            })
        .orElse(Response.status(Status.NOT_FOUND).build());
  }

  @GET
  @Path("{experience_id}")
  public Response getbyId(@PathParam("experience_id") Long experience_id) {
    try {
      Optional<Experiences> ex = repository.findByIdOptional(experience_id);
      if (ex.isEmpty()) {
        return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(ex.get()).build();
    } catch (Exception e) {
      Log.error(e);
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

  @DELETE
  @Transactional
  @Path("{experience_id}")
  public Response delete(@PathParam("experience_id") Long experience_id) {
    if (repository.delete("experience_id", experience_id) > 0){
      return Response.status(204).build();
    } else {
      return Response.status(Status.NOT_FOUND).build();
    }
  }

}

