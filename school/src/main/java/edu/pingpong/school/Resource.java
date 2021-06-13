package edu.pingpong.school;

import java.nio.file.OpenOption;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Resource {

    @Inject
    Service service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Student> getAllStudents() {
        return service.getAllStudents();
        
    }

    @GET
    @Path("/schools")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<School> getAllSchools() {
        return service.getAllSchools();
        
    }

    @GET
    @Path("/enrollments")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
        
    }

    @POST
    @Path("/enrollments/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Enrollment> addEnrollments(Enrollment enrollment) {
        service.addEnrollment(enrollment);
        return service.getAllEnrollments();
        
    }

    @DELETE
    @Path("/enrollments/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Enrollment> deleteEnrollment(Enrollment enrollment){

        service.deleteEnrollment(enrollment);

        return service.getAllEnrollments();
    }
}