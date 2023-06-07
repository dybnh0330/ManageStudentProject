package com.example.mvc.service.ImplService;

import com.example.mvc.model.Class;
import com.example.mvc.model.Department;
import com.example.mvc.repository.DepartmentRepository;
import com.example.mvc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentImplService implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    private List<Class> classList;
    private List<Department> departmentList;

//    public DepartmentImplService(DepartmentRepository departmentRepository, List<Class> classList, List<Department> departmentList) {
//        this.departmentRepository = departmentRepository;
//
//        this.classList = classList;
//        this.departmentList = departmentList;
//    }
    @Override
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartmentByID(Department department, long departmentID){
        Department departmentFound = null;
        for (Department d: departmentList) {
            if(d.getId() == departmentID){
                    departmentFound = d;
            }
        }

        assert departmentFound != null;
        departmentFound.setId(department.getId());
        departmentFound.setDepartmentName(department.getDepartmentName());
        departmentRepository.save(departmentFound);

    }


    @Override
    public List<Department> findAllDepartment(){
        return departmentRepository.findAll();
    }


    @Override
    public void findByDepartmentID(long departmentID) {

        for (Department d : departmentList) {
            if (d.getId() == departmentID) {
                System.out.println(d);
                for (Class c : classList) {
                    if (c.getDepartment().getId() == departmentID) {
                        System.out.println(c);
                    }


                }

            }
        }


    }

    @Override
    public void findByDepartmentName(String departmentName) {
        for (Department d : departmentList) {
            if (Objects.equals(d.getDepartmentName(), departmentName)) {
                System.out.println(d);
                for (Class c : classList) {
                    if (c.getDepartment().equals(departmentName)) {
                        System.out.println(c);
                    }


                }

            }
        }


    }

    @Override
    public void deleteDepartmentByID(long departmentID){
        Department departmentFound = null;
        for (Department d: departmentList) {
            if(d.getId() == departmentID){
                departmentFound = d;
            }
        }

        assert departmentFound != null;
        departmentRepository.delete(departmentFound);
    }


}
