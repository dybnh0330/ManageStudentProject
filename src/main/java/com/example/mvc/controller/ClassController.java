package com.example.mvc.controller;

import com.example.mvc.dto.ClassRequest;
import com.example.mvc.model.Class;
import com.example.mvc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Class")
public class ClassController {
    @Autowired
    private ClassService classService;


    @GetMapping( "/getAll")
    public List<Class> findAllClass(){
        return classService.findAllClass();
    }

    @GetMapping( "/findByID/{id}")
    public Class findClassByID(@PathVariable long id) {
        return classService.findByClassId(id);
    }



    @PostMapping("/add")
    public ResponseEntity<String> addClass(@RequestBody ClassRequest classes) {
        classService.addClass(classes);
        return ResponseEntity.ok().body("\"Add class successfully\"");
    }

    @PutMapping( "/update/{id}")
    public ResponseEntity<String> updateClass(@RequestBody Class classes,@PathVariable long id ) {
        classService.updateClassByID(classes, id);
        return ResponseEntity.ok().body("\"Update class successfully\"");

    }


    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable long id) {
        classService.deleteClassByID(id);
        return ResponseEntity.ok().body("\"Delete class successfully\"");

    }



}
