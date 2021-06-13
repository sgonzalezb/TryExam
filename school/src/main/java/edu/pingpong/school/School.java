package edu.pingpong.school;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "school")
public class School extends PanacheEntityBase {

    @Id
    public Long id_school;

    public String name;


    public Long getId_school() {
        return id_school;
    }

    public void setId_school(Long id_school) {
        this.id_school = id_school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School(Long id_school, String name) {
        this.id_school = id_school;
        this.name = name;
    }

    public School(){}

    


    
}
