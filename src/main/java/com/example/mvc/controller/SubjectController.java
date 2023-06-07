package com.example.mvc.controller;

import com.example.mvc.model.Subject;
import com.example.mvc.service.ImplService.SubjectImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectImplService subjectImplService;
    public SubjectController(SubjectImplService subjectImplService){
        this.subjectImplService = subjectImplService;
    }

    @GetMapping(value = "/subject/getAll")
    public List<Subject> findAllSubject(){
        return subjectImplService.findAllSubject();
    }


    @GetMapping(value = "/subject/findByID/{id}")
    public void findSubjectByID(@PathVariable long id) {
        subjectImplService.findSubjectById(id);
    }


    @GetMapping(value = "/subject/findByName/{name}")
    public void findSubjectByName(@PathVariable String name) {
        subjectImplService.findSubjectByName(name);
    }

    @PostMapping(value = "/subject/add")
    public void addSubject(@RequestBody Subject subject) {
        subjectImplService.addSubject(subject);
    }

    @PutMapping(value = "/subject/update/{id}")
    public void updateSubject(@RequestBody Subject subject,@PathVariable long id ) {
        subjectImplService.updateSubjectByID(subject, id);
    }


    @DeleteMapping(value = "/subject/delete/{id}")
    public void deleteSubject(@PathVariable long id) {
        subjectImplService.deleteSubjectByID(id);

    }
}
