package com.example.mvc.service.ImplService;

import com.example.mvc.dto.SubjectRequest;
import com.example.mvc.model.Student;
import com.example.mvc.model.Subject;
import com.example.mvc.repository.StudentRepository;
import com.example.mvc.repository.SubjectRepository;
import com.example.mvc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectImplService implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void addSubject(SubjectRequest subjectRequest){
        Subject subjectNew = new Subject();
        subjectNew.setSubjectName(subjectRequest.getSubjectName());
        Optional<Student> optionalSubjectStudent = studentRepository.findById(subjectRequest.getStudentID());

        if (optionalSubjectStudent.isEmpty()){
            throw new RuntimeException("student is not existed");
        }

        subjectNew.setStudent(optionalSubjectStudent.get());

        subjectRepository.save(subjectNew);

    }
    @Override
    public List<Subject> findAllSubject(){
        return subjectRepository.findAll();
    }
    @Override
    public void updateSubjectByID(Subject subject, long subbjectID){
        Optional<Subject> optionalSubjectStudent = subjectRepository.findById(subbjectID);

        if (optionalSubjectStudent.isEmpty()){
            throw new RuntimeException("subject is not existed");
        }

        optionalSubjectStudent.get().setSubjectName(subject.getSubjectName());

        subjectRepository.save(optionalSubjectStudent.get());

    }
    @Override
    public void deleteSubjectByID(long subjectID){
        Optional<Subject> optionalSubjectStudent = subjectRepository.findById(subjectID);

        if (optionalSubjectStudent.isEmpty()){
            throw new RuntimeException("subject is not existed");
        }

        subjectRepository.deleteById(subjectID);


    }


    @Override
    public Subject findSubjectById(long subjectID){
        Optional<Subject> optionalSubjectStudent = subjectRepository.findById(subjectID);

        if (optionalSubjectStudent.isEmpty()){
            throw new RuntimeException("subject is not existed");
        }

        return optionalSubjectStudent.get();

    }




}
