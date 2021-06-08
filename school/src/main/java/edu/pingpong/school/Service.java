package edu.pingpong.school;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Service {

    public Service(){}

    public Set<School> listSchool(){
        Stream<School> list = School.streamAll();
        return list.collect(Collectors.toSet());
    }

    public Set<Student> listStudent(){
        Stream<Student> student = Student.streamAll();
        return student.collect(Collectors.toSet());
    }
    
    public Optional<Student> getStudent(String name){
        return name.isBlank()? Optional.ofNullable(null):
        Student.find("name",name).firstResultOptional();
        //Hace una query por la busqueda de la columna name y el parametro que le pasamos
        //el valor de este find puede ser NULL por lo que debemos encapsularlo en un Optional
        //
    }
}
