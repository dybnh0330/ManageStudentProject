package com.example.mvc.service;

import com.example.mvc.dto.MarkRequest;
import com.example.mvc.model.Mark;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MarkService {
    List<Mark> findListMarkOfStudentByID(long studentID);

    Mark findSubjectWithHighestMark();
    Mark findSubjectWithLowestMark();
    void addMark(MarkRequest markRequest);
    void updateMarkByID(Mark mark,long markID);

    List<Mark> findMarkByStudentIDAndSubjectID(long studentID, long subjectID);

}
