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
public class InternalException extends Exception implements ExceptionMapper<InternalException> {
    private ErrorMessage em;
    private String message = "Internal Server Error";
    private Status status = Status.INTERNAL_SERVER_ERROR;

    public InternalException(ErrorMessage em) {
        super(em.getMessage());
        this.em = em;
    }

    @Override
    public Response toResponse(InternalException exception) {
        exception.getEm().setMessage(message);
        exception.getEm().setStatus(status.getStatusCode());
        return Response.status(status)
                .entity(exception.getEm())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
