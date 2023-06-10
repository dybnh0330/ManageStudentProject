package com.example.mvc.controller;

import com.example.mvc.dto.SubjectRequest;
import com.example.mvc.model.Subject;
import com.example.mvc.service.ImplService.SubjectImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Subject")
public class SubjectController {
    @Autowired
    private SubjectImplService subjectImplService;

    @GetMapping(value = "/getAll")
    public List<Subject> findAllSubject(){
        return subjectImplService.findAllSubject();
    }


    @GetMapping(value = "/findByID/{id}")
    public Subject findSubjectByID(@PathVariable long id) {
        return subjectImplService.findSubjectById(id);
    }



    @PostMapping(value = "/add")
    public ResponseEntity<String> addSubject(@RequestBody SubjectRequest subjectRequest) {
        subjectImplService.addSubject(subjectRequest);
        return ResponseEntity.ok().body("\"Add subject successfully\"");    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateSubject(@RequestBody Subject subject,@PathVariable long id ) {
        subjectImplService.updateSubjectByID(subject, id);
        return ResponseEntity.ok().body("\"Update subject successfully\"");
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable long id) {
        subjectImplService.deleteSubjectByID(id);
        return ResponseEntity.ok().body("\"Delete subject successfully\"");

    }
}
