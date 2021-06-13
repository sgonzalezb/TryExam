package edu.pingpong.school;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class Service {

    public Set<Student> getAllStudents(){
        Stream<Student> setStudent = Student.streamAll();
        return setStudent.collect(Collectors.toSet());

    }

    public Set<School> getAllSchools(){
        Stream<School> setSchool = School.streamAll();
        return setSchool.collect(Collectors.toSet());

    }

    public Set<Enrollment> getAllEnrollments(){
        Stream<Enrollment> setEnrollment = Enrollment.streamAll();
        return setEnrollment.collect(Collectors.toSet());
    }

    //Este metodo implementa el Create y Update
    public void addEnrollment(Enrollment enrollment){
        Optional <Enrollment> result = Enrollment.find("id", enrollment.getId()).firstResultOptional();
        if(result.isPresent()){

            result.get().delete();

            enrollment.school.delete();
            enrollment.school.persist();

            enrollment.student.delete();
            enrollment.student.persist();
            
        }else{
            enrollment.school.persist();

            enrollment.student.persist();
        }

        enrollment.persist();

    }

    public void deleteEnrollment(Enrollment enrollment){

        Optional<Enrollment> result = Enrollment.find("id", enrollment.id).firstResultOptional();

        if (result.isPresent()){

            result.get().delete();

        }
            
    }


    
    
}
