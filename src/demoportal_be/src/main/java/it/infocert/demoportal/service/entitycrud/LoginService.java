package it.infocert.demoportal.service.entitycrud;

import org.eclipse.microprofile.jwt.JsonWebToken;
import jakarta.inject.Inject;

import io.quarkus.logging.Log;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import it.infocert.demoportal.persistance.repository.UsersRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("login")
public class LoginService {

  @Inject
  UsersRepository repository;

  /**
   * Injection point for the access token issued by the OpenID Connect provider
   */

  @Inject
  SecurityIdentity securityIdentity;

  @Inject
  JsonWebToken jwt;

  @Inject
  UserInfo userInfo;

  @GET
  public Response get() {
    Log.debug("email from isac userinfo: " + userInfo.getJsonObject().getJsonArray("alias").getString(1));
    String userId =  userInfo.getJsonObject().getJsonArray("alias").getString(1);
    Log.debug("userid =" + userId);
    return repository
        .findByIdOptional(userId)
        .map(d -> Response.ok(d).build())
        .orElse(Response.status(Status.NOT_FOUND).build());
  }

  /**
   * Returns the tokens available to the application.
   * This endpoint exists only for demonstration purposes.
   * Do not expose these tokens in a real application.
   *
   * @return an HTML page containing the tokens available to the application.
   */

   /* 
  @Path("debug")
  @GET
  @Produces("text/html")
  public String getTokens() {
    Log.debug(accessToken);
   // Log.debug(userinfo.getSubject().toString());
    StringBuilder response = new StringBuilder().append("<html>")
        .append("<body>")
        .append("<ul>");

    Object userName =  accessToken.getSubject();
    if (userName != null) {
      response.append("<li>username: ").append(userName.toString()).append("</li>");
    }

    Object scopes = this.accessToken.getClaim("scope");

    if (scopes != null) {
      response.append("<li>scopes: ").append(scopes.toString()).append("</li>");
    }

    return response.append("</ul>").append("</body>").append("</html>").toString();
  }
*/
}
