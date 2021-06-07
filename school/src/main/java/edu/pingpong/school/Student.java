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
    private Long id;

    @Column
    private String name;

   
    @ManyToOne
    @JoinColumn(name = "school")
    private School school;




    
}
