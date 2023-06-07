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
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Subject {
    @Id

    @Column(name = "subjectID")
    private long subjectId;

    @Column(name = "subjectName")
    private String subjectName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subjectID_mark")
    private Mark mark;




}
