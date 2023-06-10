package com.example.mvc.service;

import com.example.mvc.dto.ClassRequest;
import com.example.mvc.model.Class;
import org.springframework.stereotype.Component;


import java.util.List;

public interface ClassService {
    Class findByClassId(long classID);

    void addClass(ClassRequest classRequest);

    List<Class> findAllClass();

    void updateClassByID(Class classes, long classID);

    void deleteClassByID(long classID);

}
