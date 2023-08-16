package com.example.HomeWorkAug080823.service;

import com.example.HomeWorkAug080823.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (long id);

    Collection<Student> getByAge(Integer min, Integer max);

    Student editStudent (long id, Student student);
    void deleteStudent (long id);

    Student findFaculty(String name);
}
