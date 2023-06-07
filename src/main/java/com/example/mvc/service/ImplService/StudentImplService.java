package com.example.mvc.service.ImplService;

import com.example.mvc.model.Student;
import com.example.mvc.repository.StudentRepository;
import com.example.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentImplService implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private List<Student> studentList;
    private List<Student> femaleStudentList;
    private List<Student> maleStudentList;

    private List<Student> AZStudentList;

    private List<Student> ZAStudentList;


//    public StudentImplService(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//
//    }
    @Override
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    @Override
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
    @Override
    public void updateStudentByID(Student student, long studentID){
        Student studentFound = null;
        for (Student s : studentList) {
            if(s.getStudentId() == studentID){
                studentFound = s;
            }
        }

        assert studentFound!= null;
        studentFound.setStudentName(student.getStudentName());
        studentFound.setSex(student.getSex());
        studentFound.setBirthDay(student.getBirthDay());
        studentRepository.save(studentFound);

    }
    @Override
    public void deleteStudentByID(long studentID){
        Student studentFound = null;
        for (Student s: studentList) {
            if(s.getStudentId() == studentID){
                studentFound = s;
            }
        }

        assert studentFound != null;
        studentRepository.delete(studentFound);
    }


    @Override
    public void findStudentById(long studentID){
        for (Student s: studentList) {
            if(s.getStudentId() == studentID){
                System.out.println(s);
            }
        }
    }

    @Override
    public void findStudentByName(String studentName){
        for (Student s: studentList) {
            if(Objects.equals(s.getStudentName(), studentName)){
                System.out.println(s);
            }
        }
    }
    @Override
    public List<Student> findAllFemaleStudent(){
        for (Student s: studentList) {
            if (Objects.equals(s.getSex(), "F")){
                femaleStudentList.add(s);
            }
        }

        return femaleStudentList;
    }

    @Override
    public List<Student> findAllMaleStudent(){
        for (Student s: studentList) {
            if (Objects.equals(s.getSex(), "M")){
                maleStudentList.add(s);
            }
        }

        return maleStudentList;
    }
    @Override
    public List<Student> sortStudentByNameAZ(){
        AZStudentList = studentList.stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());

        return AZStudentList;
    }
    @Override
    public List<Student> sortStudentByNameZA(){
        ZAStudentList  = studentList.stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());
        Collections.reverse(ZAStudentList);

        return ZAStudentList;

    }



}
