package com.example.mvc.service;

import com.example.mvc.dto.SubjectRequest;
import com.example.mvc.model.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SubjectService {
    void addSubject(SubjectRequest subjectRequest);
    List<Subject> findAllSubject();
    Subject findSubjectById(long id);
    void updateSubjectByID(Subject subject, long id);
    void deleteSubjectByID(long id);

}
