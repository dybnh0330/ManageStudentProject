package com.example.mvc.service.ImplService;

import com.example.mvc.dto.MarkRequest;
import com.example.mvc.model.Mark;
import com.example.mvc.model.Student;
import com.example.mvc.model.Subject;
import com.example.mvc.repository.MarkRepository;
import com.example.mvc.repository.StudentRepository;
import com.example.mvc.repository.SubjectRepository;
import com.example.mvc.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class MarkImplService implements MarkService {
    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    private List<Mark> listMarkOfStudent;

    private List<Mark> highList;

    private List<Mark> lowList;


    private List<Mark> listMarkByStudentIDAndSubjectID;

    @Override
    public void addMark(MarkRequest markRequest){
        Mark markNew = new Mark();
        markNew.setMark(markRequest.getMark());

        Optional<Student> studentOptional = studentRepository.findById(markRequest.getStudentID());
        Optional<Subject> subjectOptional = subjectRepository.findById(markRequest.getSubjectID());

        if(studentOptional.isEmpty() && subjectOptional.isEmpty()){
            throw new RuntimeException("mark is not existed");
        }

        markNew.setStudent(studentOptional.get());
        markNew.setSubject(subjectOptional.get());
        markRepository.save(markNew);


    }
    @Override
    public void updateMarkByID(Mark mark,long markID){

        Optional<Mark> markOptional = markRepository.findById(markID);


        if(markOptional.isEmpty()){
            throw new RuntimeException("mark is not existed");
        }

        markOptional.get().setMark(mark.getMark());

        markRepository.save(markOptional.get());


    }



    @Override
    public List<Mark> findListMarkOfStudentByID(long studentID){
        this.listMarkOfStudent = new ArrayList<>();

        for (Mark m: markRepository.findAll()) {
            if(m.getStudent().getId() == studentID){
                listMarkOfStudent.add(m);
            }
        }

        return listMarkOfStudent;

    }
    @Override
    public List<Mark> findMarkByStudentIDAndSubjectID(long studentID, long subjectID){
        this.listMarkByStudentIDAndSubjectID = new ArrayList<>();


        for (Mark m: markRepository.findAll()) {
            if(m.getStudent().getId() == studentID && m.getSubject().getId() == subjectID){
                listMarkByStudentIDAndSubjectID.add(m);
            }
        }

        return listMarkByStudentIDAndSubjectID;

    }

    @Override
    public Mark findSubjectWithHighestMark(){
        this.highList = new ArrayList<>();
        highList =   markRepository.findAll().stream().sorted(Comparator.comparingDouble(Mark::getMark)).collect(Collectors.toList());
        Collections.reverse(highList);
        return highList.stream().reduce((first, second) -> first).orElse(null);
    }

    @Override
    public Mark findSubjectWithLowestMark(){
        this.lowList = new ArrayList<>();
        lowList= markRepository.findAll().stream().sorted(Comparator.comparingDouble(Mark::getMark)).collect(Collectors.toList());
        return lowList.stream().reduce((first, second) -> first).orElse(null);
    }
















}
