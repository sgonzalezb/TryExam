package edu.pingpong.school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="student")
public class Student extends PanacheEntityBase{

    @Id
    @Column(unique=true ,name = "name")
    public String name;

    @Column(name = "age")
    public int age;

   
    @ManyToOne
    @JoinColumn(name = "school_name")
    public School school;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student() {
    }

    
    




    
}
