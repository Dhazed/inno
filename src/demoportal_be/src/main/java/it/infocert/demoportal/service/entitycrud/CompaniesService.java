package it.infocert.demoportal.service.entitycrud;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.directory.InvalidAttributesException;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import it.infocert.demoportal.persistance.model.Companies;
import it.infocert.demoportal.persistance.repository.CompanyRepository;
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

@Path("db/companies")
public class CompaniesService {

  @Inject
  CompanyRepository repository;

  @GET
  public List<Companies> get() {
    return repository.listAll(Sort.by("id_company_name"));
  }

  @POST
  @Transactional
  public Response create(Companies newco) {
      try {
        if (repository.findByIdOptional(newco.id_company_name.toUpperCase()).isPresent()) {
          return Response.status(Status.CONFLICT).entity("Duplicate").build();
        }
        newco.id_company_name = newco.id_company_name.toUpperCase();
        repository.persist(newco);  
        return  Response.ok(newco).status(Status.CREATED).build();
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
  @Path("{companyName}")
  public Response update(@PathParam("companyName") String companyName, Companies company) {
    return repository
        .findByIdOptional(companyName.toUpperCase()).map(
            t -> {
              // t.id_company_name = company.id_company_name;
              t.company_description = company.company_description;
              t.logo_img = company.logo_img;
              t.primary_color = company.primary_color;
              t.secondary_color = company.secondary_color;
              return Response.status(204).build();
            })
        .orElse(Response.status(Status.NOT_FOUND).build());
  }

  @GET
  @Path("{companyName}")
  public Response getbyId(@PathParam("companyName") String id_company_name) {
    try {
      Optional<Companies> company = repository.findByIdOptional(id_company_name.toUpperCase());
      if (company.isEmpty()) {
        return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(company.get()).build();
    } catch (Exception e) {
      Log.error(e);
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

  @DELETE
  @Transactional
  @Path("{companyName}")
  public Response delete(@PathParam("companyName") String id_company_name) {
    repository.delete("id_company_name", id_company_name.toUpperCase());
    return Response.status(204).build();
  }

}
