package com.example.mvc.service;

import com.example.mvc.model.Class;
import org.springframework.stereotype.Component;


import java.util.List;

public interface ClassService {
    void findByClassId(long classID);
    void findByClassName(String className);
    void addClass(Class classes);
    List<Class> findAllClass();
    void updateClassByID(Class classes, long classID);
    void deleteClassByID(long classID);

}
