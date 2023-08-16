package com.example.HomeWorkAug080823.repository;

import com.example.HomeWorkAug080823.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository  extends JpaRepository<Student, Long> {
    Student findStudent (String name);
    Collection<Student> findByAgeBetween(Integer min, Integer max);
}
