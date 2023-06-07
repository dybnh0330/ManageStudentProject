package com.example.mvc.service.ImplService;

import com.example.mvc.model.Mark;
import com.example.mvc.repository.MarkRepository;
import com.example.mvc.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MarkImplService implements MarkService {
    @Autowired
    private MarkRepository markRepository;
    private List<Mark> markList;

//    public MarkImplService(MarkRepository markRepository){
//        this.markRepository = markRepository;
//
//    }
    @Override
    public void addMark(Mark mark){
        markRepository.save(mark);
    }
    @Override
    public void updateMarkByStudentIDandSubjectID(Mark mark, long studentID, long subjectID){
        Mark markFound = null;
        for (Mark m:markList) {
            if(m.getStudent().getStudentId() == studentID && m.getSubject().getSubjectId() == subjectID){
                markFound = m;
            }
        }

        assert markFound!= null;
        markRepository.save(markFound);
    }




    @Override
    public void findListMarkOfStudentByID(long studentID){
        for (Mark m: markList) {
            if(m.getStudent().getStudentId() == studentID){
                System.out.println(m);
            }
        }
    }
    @Override
    public void findMarkByStudentIDAndSubjectID(long studentID, long subjectID){
        for (Mark m: markList) {
            if(m.getStudent().getStudentId() == studentID && m.getSubject().getSubjectId() == subjectID){
                System.out.println(m.getSubject().getSubjectName() + " : " + m.getMark());
            }
        }
    }

    @Override
    public void findSubjectWithHighestMark(){
        List<Mark> highList = markList.stream().sorted(Comparator.comparingDouble(Mark::getMark)).collect(Collectors.toList());
        Mark highestMark = highList.stream().reduce((first, second) -> first).orElse(null);
        System.out.println(highestMark);
    }

    @Override
    public void findSubjectWithLowestMark(){
        List<Mark> lowList = markList.stream().sorted(Comparator.comparingDouble(Mark::getMark)).collect(Collectors.toList());
        Collections.reverse(lowList);
        Mark lowestMark = lowList.stream().reduce((first, second) -> first).orElse(null);
        System.out.println(lowestMark);
    }










}
