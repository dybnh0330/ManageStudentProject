package com.example.mvc.controller;


import com.example.mvc.model.Department;
import com.example.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Department")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping( "/getAll")
    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @GetMapping("/findByID/{id}")
    public Department findByDepartmentID(@PathVariable long id) {
        return departmentService.findByDepartmentID(id);

    }



    @PostMapping( "/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return ResponseEntity.ok().body("\"Add department successfully\"");

    }

    @PutMapping( "/update/{id}")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department,@PathVariable long id ) {
        departmentService.updateDepartmentByID(department, id);
        return ResponseEntity.ok().body("\"Update department successfully\"");

    }


    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartmentByID(id);
        return ResponseEntity.ok().body("\"Delete department successfully\"");


    }



}
