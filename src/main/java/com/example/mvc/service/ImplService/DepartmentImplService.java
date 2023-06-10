package com.example.mvc.service.ImplService;


import com.example.mvc.model.Department;
import com.example.mvc.repository.ClassRepository;
import com.example.mvc.repository.DepartmentRepository;
import com.example.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class DepartmentImplService implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ClassRepository classRepository;



    @Override
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartmentByID(Department department, long departmentID){
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentID);
        if(optionalDepartment.isEmpty()){
            throw new RuntimeException("department is not existed");
        }

        optionalDepartment.get().setDepartmentName(department.getDepartmentName());
        departmentRepository.save(optionalDepartment.get());

    }


    @Override
    public List<Department> findAllDepartment(){
        return departmentRepository.findAll();
    }


    @Override
    public Department findByDepartmentID(long departmentID) {

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentID);
        if(optionalDepartment.isEmpty()){
            throw new RuntimeException("department is not existed");
        }
        return optionalDepartment.get();

    }



    @Override
    public void deleteDepartmentByID(long departmentID){

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentID);
        if(optionalDepartment.isEmpty()){
            throw new RuntimeException("department is not existed");
        }
        departmentRepository.delete(optionalDepartment.get());

    }


}
