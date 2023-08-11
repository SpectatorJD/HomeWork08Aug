package com.example.HomeWorkAug080823.service;

import com.example.HomeWorkAug080823.model.Student;

public interface StudentService {
    Student addStudent (Student student);
    Student findStudent (long id);
    Student editStudent (long id, Student student);
    void deleteStudent (long id);

}
