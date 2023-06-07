package com.example.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "mark")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Mark {
    @Id

    @Column(name = "markId")
    private long markId;

    @Column(name = "mark")
    private double mark;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Student student;

    @OneToOne(mappedBy = "mark")
    private Subject subject;




}
