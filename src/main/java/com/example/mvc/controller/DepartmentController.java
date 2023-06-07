package com.example.mvc.controller;


import com.example.mvc.model.Department;
import com.example.mvc.service.DepartmentService;
import com.example.mvc.service.ImplService.DepartmentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Department")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

//    public DepartmentController(DepartmentImplService departmentImplService){
//        this.departmentImplService = departmentImplService;
//
//    }
    @GetMapping( "/department/getAll")
    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @GetMapping("/department/findByID/{id}")
    public void findByDepartmentID(@PathVariable long id) {
        departmentService.findByDepartmentID(id);
    }

    @GetMapping( "/department/findByName/{name}")
    public void findDepartmentByName(@PathVariable String name) {
        departmentService.findByDepartmentName(name);
    }

    @PostMapping( "/department/add")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @PutMapping( "/department/update/{id}")
    public void updateDepartment(@RequestBody Department department,@PathVariable long id ) {
        departmentService.updateDepartmentByID(department, id);
    }


    @DeleteMapping( "/department/delete/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartmentByID(id);

    }



}
