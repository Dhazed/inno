package it.infocert.demoportal.resources;


import it.infocert.demoportal.beans.LoginResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginSessionResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(
            final @FormParam("userid") String userid,
            final @FormParam("password") String password,
            final @FormParam("fake-profiles") String fakeProfiles) {
        try {
            System.out.println("login: userid=" + userid + ", password=" + (password == null ? "null" : "****"));
            System.out.println("fake-profiles: " + fakeProfiles);
            return new LoginResponse();
            /* validation */
        } catch (Exception e) {
            return null;
        } finally {
            System.out.println("login: end");
        }
    }

}
