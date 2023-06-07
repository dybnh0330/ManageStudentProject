package com.example.mvc.repository;

import com.example.mvc.model.Mark;
import com.example.mvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

}
