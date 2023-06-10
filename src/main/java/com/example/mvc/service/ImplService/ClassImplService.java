package com.example.mvc.service.ImplService;
import com.example.mvc.dto.ClassRequest;
import com.example.mvc.model.Class;

import com.example.mvc.model.Department;
import com.example.mvc.repository.ClassRepository;
import com.example.mvc.repository.DepartmentRepository;
import com.example.mvc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassImplService implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private DepartmentRepository departmentRepository;



    @Override
    public Class findByClassId(long classID) {
        Optional<Class> optionalClass = classRepository.findById(classID);
        if (optionalClass.isEmpty()) {
            throw new RuntimeException("class not existed");
        }

        return optionalClass.get();
    }





    @Override
    public void addClass(ClassRequest classes) {

        Class newClass = new Class();
        newClass.setClassName(classes.getClassName());

        Optional<Department> optionalDepartment = departmentRepository.findById(classes.getDepartmentId());

        if (optionalDepartment.isEmpty()) {
            throw new RuntimeException("department not existed");
        }

        newClass.setDepartment(optionalDepartment.get());

        classRepository.save(newClass);
    }

    @Override
    public List<Class> findAllClass() {
        return classRepository.findAll();
    }

    @Override
    public void updateClassByID(Class classes, long classID) {

        Optional<Class> optionalClass = classRepository.findById(classes.getId());

        if (optionalClass.isEmpty()) {
            throw new RuntimeException("class not existed");
        }

        optionalClass.get().setClassName(classes.getClassName());
        classRepository.save(optionalClass.get());

    }

    @Override
    public void deleteClassByID(long classID) {

        Optional<Class> optionalClass = classRepository.findById(classID);

        if (optionalClass.isEmpty()) {
            throw new RuntimeException("class not existed");
        }

        classRepository.delete(optionalClass.get());

    }


}
