package com.example.mvc.service.ImplService;

import com.example.mvc.dto.StudentRequest;
import com.example.mvc.model.Class;
import com.example.mvc.model.Student;
import com.example.mvc.repository.ClassRepository;
import com.example.mvc.repository.StudentRepository;
import com.example.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentImplService implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    private List<Student> femaleStudentList;
    private List<Student> maleStudentList;

    private List<Student> AZStudentList;

    private List<Student> ZAStudentList;



    @Override
    public void addStudent(StudentRequest studentRequest){
        Student studentNew = new Student();
        Optional<Class> optionalClass = classRepository.findById(studentRequest.getClassID());
        studentNew.setStudentName(studentRequest.getStudentName());
        studentNew.setSex(studentRequest.getSex());
        studentNew.setBirthDay(studentRequest.getBirthDay());

        if(optionalClass.isEmpty()){
            throw new RuntimeException("class not existed");
        }

        studentNew.setClasses(optionalClass.get());
        studentRepository.save(studentNew);

    }
    @Override
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
    @Override
    public void updateStudentByID(Student student, long studentID){

        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("student is not existed");
        }
        optionalStudent.get().setStudentName(student.getStudentName());
        optionalStudent.get().setBirthDay(student.getBirthDay());
        optionalStudent.get().setSex(student.getSex());

        studentRepository.save(optionalStudent.get());

    }
    @Override
    public void deleteStudentByID(long studentID){

        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("student is not existed");
        }

        studentRepository.delete(optionalStudent.get());

    }


    @Override
    public Student findStudentById(long studentID){

        Optional<Student> optionalStudent = studentRepository.findById(studentID);
        if (optionalStudent.isEmpty()){
            throw new RuntimeException("student is not existed");
        }

    return optionalStudent.get();


    }


    @Override
    public List<Student> findAllFemaleStudent(){
        this.femaleStudentList = new ArrayList<>();
        for (Student s: studentRepository.findAll()) {
            if (Objects.equals(s.getSex(), "F")){
                femaleStudentList.add(s);
            }
        }

        return femaleStudentList;
    }

    @Override
    public List<Student> findAllMaleStudent(){
        this.maleStudentList = new ArrayList<>();
        for (Student s: studentRepository.findAll()) {
            if (Objects.equals(s.getSex(), "M")){
                maleStudentList.add(s);
            }
        }

        return maleStudentList;
    }
    @Override
    public List<Student> sortStudentByNameAZ(){
        AZStudentList = studentRepository.findAll().stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());

        return AZStudentList;
    }
    @Override
    public List<Student> sortStudentByNameZA(){
        ZAStudentList  = studentRepository.findAll().stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());
        Collections.reverse(ZAStudentList);

        return ZAStudentList;

    }



}
