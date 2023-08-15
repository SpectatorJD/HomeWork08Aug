package com.example.HomeWorkAug080823.controller;

import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.model.Student;
import com.example.HomeWorkAug080823.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id){
        Student student = studentService.findStudent(id);
        if (student==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public Student createStudent (@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable long id){
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(params = {"min", "max"}, value = "/age")
    public Collection<Student> getByAge (@RequestParam Integer min, @RequestParam Integer max){
return studentService.getByAge(min, max);
    }
    @GetMapping(value = "/facultyStudent")
    public Collection<Faculty> getNameFacultyStudent (@RequestParam String name){
        return studentService.findFaculty(name);
    }
}