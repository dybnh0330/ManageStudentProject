package com.example.mvc.service;

import com.example.mvc.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DepartmentService {
    Department findByDepartmentID(long departmentID);
    List<Department> findAllDepartment();
    void addDepartment(Department department);
    void updateDepartmentByID(Department department, long departmentID);
    void deleteDepartmentByID(long departmentID);

}
