package edu.pingpong.school;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Resource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "HOLA ESTUDIANTES";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/students")
    public String getStudents() {
        return "Aquí aparecerán todos los Estudiantes";
    }
}