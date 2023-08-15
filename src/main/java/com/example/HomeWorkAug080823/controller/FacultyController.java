package com.example.HomeWorkAug080823.controller;

import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.model.Student;
import com.example.HomeWorkAug080823.repository.StudentRepository;
import com.example.HomeWorkAug080823.service.FacultyService;
import com.example.HomeWorkAug080823.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id){
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping(params = {"color"},value = "/color")
    public Collection<Faculty> getFiltered(@RequestParam(required = false) String color){
        return facultyService.getFilterByColor(color);
    }
    @PostMapping
    public Faculty addFaculty (@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }
    @PutMapping("{id}")
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty, @PathVariable Long id){
        Faculty foundFaculty = facultyService.editFaculty(id, faculty);
        if (foundFaculty == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/studentFaculty")
    public Collection<Student> getNameStudentFaculty (@RequestParam String name){
        return facultyService.findStudent(name);
    }

}
