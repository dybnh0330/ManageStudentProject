package com.example.mvc.service;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentService {
    void findStudentById(long studentID);
    void findStudentByName(String studentName);
    List<Student> findAllFemaleStudent();
    List<Student> findAllMaleStudent();
    List<Student> sortStudentByNameAZ();
    List<Student> sortStudentByNameZA();
    public void addStudent(Student student);
    public List<Student> findAllStudent();
    public void updateStudentByID(Student student, long studentID);
    public void deleteStudentByID(long studentID);

}
