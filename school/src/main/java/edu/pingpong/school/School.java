package edu.pingpong.school;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="school")
public class School extends PanacheEntityBase{
    
    @Id
    private Long id;

    @Column(name="school_name",unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "school")//Esto hace refrencia a la columna university de la entidad Student
    private List<Student> students;


}
