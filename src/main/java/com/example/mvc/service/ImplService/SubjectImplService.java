package com.example.mvc.service.ImplService;

import com.example.mvc.model.Subject;
import com.example.mvc.repository.SubjectRepository;
import com.example.mvc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectImplService implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    private List<Subject> subjectList;
//    public SubjectImplService(SubjectRepository subjectRepository){
//        this.subjectRepository = subjectRepository;
//
//    }
    @Override
    public void addSubject(Subject subject){
        subjectRepository.save(subject);
    }
    @Override
    public List<Subject> findAllSubject(){
        return subjectRepository.findAll();
    }
    @Override
    public void updateSubjectByID(Subject subject, long subbjectID){
        Subject subjectFound = null;
        for (Subject s : subjectList) {
            if(s.getSubjectId() == subbjectID){
                subjectFound = s;
            }
        }

        assert subjectFound!= null;
        subjectFound.setSubjectName(subject.getSubjectName());

        subjectRepository.save(subjectFound);

    }
    @Override
    public void deleteSubjectByID(long subjectID){
        Subject subjectFound = null;
        for (Subject s: subjectList) {
            if(s.getSubjectId() == subjectID){
                subjectFound = s;
            }
        }

        assert subjectFound != null;
        subjectRepository.delete(subjectFound);
    }


    @Override
    public void findSubjectById(long subjectID){
        for (Subject s: subjectList) {
            if(s.getSubjectId() == subjectID){
                System.out.println(s);
            }
        }
    }

    @Override
    public void findSubjectByName(String subjectName){
        for (Subject s: subjectList) {
            if(Objects.equals(s.getSubjectName(), subjectName)){
                System.out.println(s);
            }
        }
    }


}
