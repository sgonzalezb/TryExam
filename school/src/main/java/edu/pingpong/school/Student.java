package edu.pingpong.school;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "student")
public class Student extends PanacheEntityBase {

    @Id
    public Long id_student;

    public String name;

    public String location;

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student(Long id_student, String name, String location) {
        this.id_student = id_student;
        this.name = name;
        this.location = location;
    }

    public Student(){}
}
