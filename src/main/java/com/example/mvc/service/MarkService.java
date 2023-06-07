package com.example.mvc.service;

import com.example.mvc.model.Mark;
import org.springframework.stereotype.Component;

@Component
public interface MarkService {
    void findListMarkOfStudentByID(long studentID);
    void findMarkByStudentIDAndSubjectID(long studentID, long subjectID);
    void findSubjectWithHighestMark();
    void findSubjectWithLowestMark();
    void addMark(Mark mark);
    void updateMarkByStudentIDandSubjectID(Mark mark, long studentID, long subjectID);

}
