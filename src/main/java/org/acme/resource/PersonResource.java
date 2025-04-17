package org.acme.resource;

import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.PersonModel;
import org.acme.service.PersonService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public Response getPersons() {
        return Response.ok(PersonService.getPersons()).build();
    }

    @GET
    @Path("{id}")
    public Response getPersonById(@PathParam Long id) {
        return Response.ok(PersonService.getPersonById(id)).build();
    }

    @POST
    @Transactional
    public Response createPerson(@NotNull PersonModel personModel) {
        return Response.ok(PersonService.createPerson(personModel)).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updatePerson(@PathParam Long id, @NotNull PersonModel personModel) {
        return Response.ok(PersonService.updatePerson(id, personModel)).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletePersonById(@PathParam Long id) {
        return Response.ok(PersonService.deletePersonById(id)).build();
    }
}
