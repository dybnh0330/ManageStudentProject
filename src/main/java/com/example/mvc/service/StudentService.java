package com.example.mvc.service;

import com.example.mvc.dto.StudentRequest;
import com.example.mvc.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentService {
    Student findStudentById(long studentID);
    List<Student> findAllFemaleStudent();
    List<Student> findAllMaleStudent();
    List<Student> sortStudentByNameAZ();
    List<Student> sortStudentByNameZA();
    public void addStudent(StudentRequest studentRequest);
    public List<Student> findAllStudent();
    public void updateStudentByID(Student student, long studentID);
    public void deleteStudentByID(long studentID);

}
