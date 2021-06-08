package edu.pingpong.school;

import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Resource {

    @Inject
    Service service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "HOLA ESTUDIANTES";
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students")
    public Set<Student> getStudents() {
        return service.listStudent();
    }

    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/school")
    public Set<School> getSchool() {
        return service.listSchool();
    }


    @GET
    @Path("students/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUniqueStudent(@PathParam("name") String name) {
        Optional<Student> student = service.getStudent(name);
        return student.isPresent()?
        Response.status(Response.Status.OK).entity(student.get()).build() :
        Response.status(Response.Status.NOT_FOUND).build();
    }

    
}