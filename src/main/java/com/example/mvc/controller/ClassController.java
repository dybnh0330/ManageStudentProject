package com.example.mvc.controller;

import com.example.mvc.model.Class;
import com.example.mvc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Class")
public class ClassController {
    @Autowired
    private ClassService classService;

//    public ClassController(ClassService classService){
//        this.classService = classService;
//    }

    @GetMapping( "/class/getAll")
    public List<Class> findAllClass(){
        return classService.findAllClass();
    }

    @GetMapping( "/class/findByID/{id}")
    public void findClassByID(@PathVariable long id) {
        classService.findByClassId(id);
    }

    @GetMapping( "/class/findByName/{name}")
    public void findClassByName(@PathVariable String name) {
        classService.findByClassName(name);
    }

    @PostMapping("/class/add")
    public void addClass(@RequestBody Class classes) {
        classService.addClass(classes);
    }

    @PutMapping( "/class/update/{id}")
    public void updateClass(@RequestBody Class classes,@PathVariable long id ) {
        classService.updateClassByID(classes, id);
    }


    @DeleteMapping( "/class/delete/{id}")
    public void deleteClass(@PathVariable long id) {
        classService.deleteClassByID(id);

    }



}
