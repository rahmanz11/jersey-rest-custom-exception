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
public class BadRequestException extends Exception implements ExceptionMapper<BadRequestException> {
    private ErrorMessage em;
    private String message = "Required Parameter Missing";
    private Status status = Status.BAD_REQUEST;

    public BadRequestException(ErrorMessage em) {
        super();
        this.em = em;
    }

    @Override
    public Response toResponse(BadRequestException exception) {
        exception.getEm().setMessage(message);
        exception.getEm().setStatus(status.getStatusCode());
        return Response.status(status)
                .entity(exception.getEm())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
