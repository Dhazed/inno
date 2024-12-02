package it.infocert.demoportal.errormanager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.vertx.core.http.HttpServerRequest;
import jakarta.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.UncheckedIOException;
import io.quarkus.logging.Log; 

@Provider
public class ErrorPageResponseExceptionMapper implements ExceptionMapper<Exception> {
  // -- Class Fields ------------------------------------------------------------------------------------------------ //

  // -- Instance Fields --------------------------------------------------------------------------------------------- //

  @Inject
  ObjectMapper objectMapper;

  // -- Initialization ---------------------------------------------------------------------------------------------- //

  public ErrorPageResponseExceptionMapper() {}

  // -- Exposed Methods --------------------------------------------------------------------------------------------- //

  @Inject
  javax.inject.Provider<HttpServerRequest> httpServerRequestProvider;

  @Override
  public Response toResponse(Exception exception) {
    Log.error(exception);
    Response errorResponse = mapExceptionToResponse(exception);
    String errorContent = createJsonErrorContent(errorResponse.getStatusInfo(), errorResponse.getEntity().toString());
    return Response.fromResponse(errorResponse)
                       .type(MediaType.APPLICATION_JSON_TYPE)
                   .entity(errorContent)
                   .build();
  }


  // -- Private Methods --------------------------------------------------------------------------------------------- //

  private Response mapExceptionToResponse(Exception exception) {
    // Use response from WebApplicationException as they are
    if (exception instanceof WebApplicationException) {
      // Overwrite error message
      Response originalErrorResponse = ((WebApplicationException) exception).getResponse();
      return Response.fromResponse(originalErrorResponse)
                     .entity(exception.getMessage())
                     .build();
    }
    // Special mappings
    else if (exception instanceof IllegalArgumentException) {
      return Response.status(400).entity(exception.getMessage()).build();
    }
    // Use 500 (Internal Server Error) for all other
    else {
      Log.fatalf(exception,
                    "Failed to process request to: {}",
                    httpServerRequestProvider.get().absoluteURI());
      return Response.serverError().entity("Internal Server Error").build();
    }
  }


  private String createJsonErrorContent(Response.StatusType errorStatus, String errorDetails) {
    ObjectNode errorObject = objectMapper.createObjectNode();
    errorObject.put("status", errorStatus.getStatusCode());
    errorObject.put("title", errorStatus.getReasonPhrase());

    if (errorDetails != null) {
      errorObject.put("detail", errorDetails);
    }

    ArrayNode errorsArray = objectMapper.createArrayNode().add(errorObject);

    try {
      return objectMapper.writeValueAsString(errorsArray);
    }
    catch (JsonProcessingException e) {
      throw new UncheckedIOException(e);
    }
  }
  
  /* 
  private static String createTextErrorContent(Response.StatusType errorStatus, String errorDetails) {
    var errorText = new StringBuilder();
    errorText.append("Error ")
             .append(errorStatus.getStatusCode())
             .append(" (").append(errorStatus.getReasonPhrase()).append(")");

    if (errorDetails != null) {
      errorText.append("\n\n").append(errorDetails);
    }

    return errorText.toString();
  }
  */

  // -- Inner Type -------------------------------------------------------------------------------------------------- //
}