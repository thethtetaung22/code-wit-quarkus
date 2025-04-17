package org.acme.resource;

import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.domain.Person;
import org.acme.model.PersonModel;
import org.acme.service.PersonService;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public Response getPersons() {
        return Response.ok(PersonService.getPersons()).build();
    }

    @POST
    @Transactional
    public Response createPerson(@NotNull PersonModel personModel) {
        return Response.ok(PersonService.createPerson(personModel)).build();
    }
}
