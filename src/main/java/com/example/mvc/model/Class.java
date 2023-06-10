package com.example.mvc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;


@Entity
@Table(name = "class")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "className")
    private String className;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @JsonBackReference
    public Department getDepartment(){
        return department;
    }




}
