package com.example.mvc.service;

import com.example.mvc.model.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SubjectService {
    void addSubject(Subject subject);
    List<Subject> findAllSubject();
    void findSubjectById(long id);
    void findSubjectByName(String name);
    void updateSubjectByID(Subject subject, long id);
    void deleteSubjectByID(long id);

}
