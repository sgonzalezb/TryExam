package edu.pingpong.school;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "enrollment")
public class Enrollment extends PanacheEntityBase{
    
    @Id
    public Long id;

    @OneToOne
    @JoinColumn(name = "id_school")
    public School school;

    @OneToOne
    @JoinColumn(name = "id_student")
    public Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Enrollment() {
    }

    public Enrollment(Long id, School school, Student student) {
        this.id = id;
        this.school = school;
        this.student = student;
    }

    
}
