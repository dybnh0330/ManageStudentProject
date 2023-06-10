package com.example.mvc.controller;

import com.example.mvc.dto.StudentRequest;
import com.example.mvc.model.Class;
import com.example.mvc.model.Student;
import com.example.mvc.service.ImplService.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Student")
public class StudentController {
    @Autowired
    private StudentImplService studentImplService;

    @GetMapping(value = "/getAll")
    public List<Student> findAllStudent(){
        return studentImplService.findAllStudent();
    }


    @GetMapping(value = "/findByID/{id}")
    public Student findStudentById(@PathVariable long id) {
       return  studentImplService.findStudentById(id);
    }




    @PostMapping(value = "/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequest studentRequest) {
        studentImplService.addStudent(studentRequest);
        return ResponseEntity.ok().body("\"Add student successfully\"");

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable long id ) {
        studentImplService.updateStudentByID(student, id);
        return ResponseEntity.ok().body("\"Add student successfully\"");

    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        studentImplService.deleteStudentByID(id);
        return ResponseEntity.ok().body("\"Delete student successfully\"");

    }


    @GetMapping(value = "/findAllFemaleStudent")
    public List<Student> findAllFemaleStudent() {
        return studentImplService.findAllFemaleStudent();
    }


    @GetMapping(value = "/findAllMaleStudent")
    public List<Student> findAllMaleStudent() {
        return studentImplService.findAllMaleStudent();
    }


    @GetMapping(value = "/sortStudentAZ")
    public List<Student> sortStudentByNameAZ() {
        return studentImplService.sortStudentByNameAZ();
    }


    @GetMapping(value = "/sortStudentZA")
    public List<Student> sortStudentByNameZA() {
        return studentImplService.  sortStudentByNameZA();
    }

}
