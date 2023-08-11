package com.example.HomeWorkAug080823.service;

import com.example.HomeWorkAug080823.model.Student;
import com.example.HomeWorkAug080823.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent (Student student){
        return studentRepository.save(student);
    }

    public Student findStudent(long id){
        return studentRepository.findById(id).get();
    }

    @Override
    public Student editStudent(long id, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

}
