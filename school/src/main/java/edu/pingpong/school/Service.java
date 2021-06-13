package edu.pingpong.school;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

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

    public Optional<School> getSchool(String name){
        return name.isBlank()? Optional.ofNullable(null):
        School.find("name",name).firstResultOptional();
        //Hace una query por la busqueda de la columna name y el parametro que le pasamos
        //el valor de este find puede ser NULL por lo que debemos encapsularlo en un Optional
        //
    }

    public void addSchool(School school){
        Optional <School> result = School.find("name", school.getName()).firstResultOptional();
        if (!result.isPresent()) {
            school.persist();
        }

    }

    public void addStudent(Student student){
        Optional <School> resultSchool = School.find("name", student.school.getName()).firstResultOptional();

        if (resultSchool.isPresent()) {

            //Si la escuela existe, se le asigna a la propiedad 
            //escuela del estudiante que entra como input
            student.school = resultSchool.get();
        }

        else{
            //Si la School no existe, la persiste
            student.school.persist();
        }
        //Finalmente persiste el objeto student
        //una vez comprobado y creado la escuela a la que 
        //pertenece
        student.persist();

    }

    public void deleteSchool(School school){
        Optional <School> result = School.find("name",school.getName()).firstResultOptional();
        if (result.isPresent()) {
            result.get().delete();
        }
    }

    public void deleteStudent(Student student){
        Optional <Student> result = Student.find("name", student.getName()).firstResultOptional();
        if (result.isPresent()) {
            result.get().delete();
        }
    }
}

