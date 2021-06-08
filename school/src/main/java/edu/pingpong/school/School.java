package edu.pingpong.school;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="school")
public class School extends PanacheEntityBase{

    @Id    
    @Column(name="school_name",unique = true,nullable = false)
    public String name;

    @Column(name = "location")
    public String location;

    @JsonIgnore
    @OneToMany(mappedBy = "school")//Esto hace referencia al objeto school (a la entidad completa)
    public List<Student> students;

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

    public School(){}

    public School(String name, String location) {
        this.name = name;
        this.location = location;
    }

    

    
    


}
