package edu.pingpong.school;

import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Path("/student")
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
    @Path("student/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUniqueStudent(@PathParam("name") String name) {
        Optional<Student> student = service.getStudent(name);
        return student.isPresent()?
        Response.status(Response.Status.OK).entity(student.get()).build() :
        Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/school/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<School> addSchool(School school) {
        service.addSchool(school);
        return service.listSchool();
    }

    @POST
    @Path("/student/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Student> addStudent(Student student) {
        service.addStudent(student);
        return service.listStudent();
    }

    @DELETE
    @Path("/school/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<School> deleteSchool(School school) {
        service.deleteSchool(school);
        return service.listSchool();
    }

    @DELETE
    @Path("/student/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Student> deleteStudent(Student student) {
        service.deleteStudent(student);
        return service.listStudent();
    }


   
}