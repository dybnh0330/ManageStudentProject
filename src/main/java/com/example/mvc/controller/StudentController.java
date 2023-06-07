package com.example.mvc.controller;

import com.example.mvc.model.Class;
import com.example.mvc.model.Student;
import com.example.mvc.service.ImplService.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentImplService studentImplService;
    public StudentController(StudentImplService studentImplService){
        this.studentImplService = studentImplService;
    }

    @GetMapping(value = "/student/getAll")
    public List<Student> findAllStudent(){
        return studentImplService.findAllStudent();
    }


    @GetMapping(value = "/student/findByID/{id}")
    public void findStudentById(@PathVariable long id) {
        studentImplService.findStudentById(id);
    }


    @GetMapping(value = "/student/findByName/{name}")
    public void findStudentByName(@PathVariable String name) {
        studentImplService.findStudentByName(name);
    }

    @PostMapping(value = "/student/add")
    public void addStudent(@RequestBody Student student) {
        studentImplService.addStudent(student);
    }

    @PutMapping(value = "/student/update/{id}")
    public void updateStudent(@RequestBody Student student,@PathVariable long id ) {
        studentImplService.updateStudentByID(student, id);
    }


    @DeleteMapping(value = "/student/delete/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentImplService.deleteStudentByID(id);

    }


    @GetMapping(value = "/student/findAllFemaleStudent")
    public List<Student> findAllFemaleStudent() {
        return studentImplService.findAllFemaleStudent();
    }


    @GetMapping(value = "/student/findAllMaleStudent")
    public List<Student> findAllMaleStudent() {
        return studentImplService.findAllMaleStudent();
    }


    @GetMapping(value = "/student/sortStudentAZ")
    public List<Student> sortStudentByNameAZ() {
        return studentImplService.sortStudentByNameAZ();
    }


    @GetMapping(value = "/student/sortStudentZA")
    public List<Student> sortStudentByNameZA() {
        return studentImplService.  sortStudentByNameZA();
    }

}
