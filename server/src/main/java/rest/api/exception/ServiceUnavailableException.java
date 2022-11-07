package rest.api.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Provider
public class ServiceUnavailableException extends Exception implements ExceptionMapper<ServiceUnavailableException> {
    private ErrorMessage em;
    private String message = "Service Temporariliy Unavailable";
    private Status status = Status.SERVICE_UNAVAILABLE;

    public ServiceUnavailableException(ErrorMessage em) {
        super(em.getMessage());
        this.em = em;
    }

    @Override
    public Response toResponse(ServiceUnavailableException exception) {
        exception.getEm().setMessage(message);
        exception.getEm().setStatus(status.getStatusCode());
        return Response.status(status)
                .entity(exception.getEm())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
