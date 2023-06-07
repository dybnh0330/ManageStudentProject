package com.example.mvc.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "departmentName")
    private String departmentName;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private List<Class> classes;

    @JsonManagedReference
    public List<Class> getClasses(){
        return classes;
    }


}
