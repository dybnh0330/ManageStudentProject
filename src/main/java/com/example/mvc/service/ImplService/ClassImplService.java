package com.example.mvc.service.ImplService;

import com.example.mvc.model.Class;

import com.example.mvc.repository.ClassRepository;
import com.example.mvc.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClassImplService implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    private List<Class> classList;

    @Override
    public void findByClassId(long classID) {
        for (Class c : classList) {
            if (c.getId() == classID) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void findByClassName(String className) {
        for (Class c : classList) {
            if (Objects.equals(c.getClassName(), className)) {
                System.out.println(c);
            }
        }
    }


    @Override
    public void addClass(Class classes) {
        classRepository.save(classes);
    }

    @Override
    public List<Class> findAllClass() {
        return classRepository.findAll();
    }

    @Override
    public void updateClassByID(Class classes, long classID) {
        Class classFound = null;
        for (Class c : classList) {
            if (c.getId() == classID) {
                classFound = c;
            }
        }

        assert classFound != null;
        classFound.setId(classes.getId());
        classFound.setClassName(classes.getClassName());
        classRepository.save(classes);
    }

    @Override
    public void deleteClassByID(long classID) {
        Class classFound = null;
        for (Class c : classList) {
            if (c.getId() == classID) {
                classFound = c;
            }
        }

        assert classFound != null;
        classRepository.delete(classFound);
    }


}
