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
public class UnauthorizedException extends Exception implements ExceptionMapper<UnauthorizedException> {
    private ErrorMessage em;
    private String message = "Unauthorized Access";
    private Status status = Status.UNAUTHORIZED;

    public UnauthorizedException(ErrorMessage em) {
        super(em.getMessage());
        this.em = em;
    }

    @Override
    public Response toResponse(UnauthorizedException exception) {
        exception.getEm().setMessage(message);
        exception.getEm().setStatus(status.getStatusCode());
        return Response.status(status)
                .entity(exception.getEm())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
