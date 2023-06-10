package com.example.mvc.repository;

import com.example.mvc.model.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {}


