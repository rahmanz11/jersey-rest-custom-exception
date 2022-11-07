package rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.api.exception.BadRequestException;
import rest.api.exception.ErrorMessage;
import rest.api.exception.InternalException;
import rest.api.exception.NotFoundException;
import rest.api.exception.UnauthorizedException;
import rest.api.payload.Data;

@Path("/rest")
public class RESTServer {

    /**
     * GET
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam(value = "id") String id) throws NotFoundException {
        throw new NotFoundException(ErrorMessage.builder()
        .code(111)
        .reason("Content with the given id is not available")
        .build());
    }

    /**
     * ADD
     */
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Data data) throws BadRequestException {
        throw new BadRequestException(ErrorMessage.builder()
                .code(112)
                .reason("The content in the info field of data must be available")
                .build());
    }

    /**
     * UPDATE
     */
    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Data data) throws InternalException {
        throw new InternalException(ErrorMessage.builder()
                .code(113)
                .reason("Internal error occurred. Please try again later.")
                .build());
    }

    /**
     * DELETE
     */
    @DELETE
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Data data) throws UnauthorizedException {
        throw new UnauthorizedException(ErrorMessage.builder()
                .code(114)
                .reason("Delete a record requires proper authorization. You are not authorized!")
                .build());
    }
}
