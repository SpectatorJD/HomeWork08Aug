package com.example.HomeWorkAug080823.contollerTestByUsingWebMvcTest;

import com.example.HomeWorkAug080823.controller.StudentController;
import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.model.Student;
import com.example.HomeWorkAug080823.repository.FacultyRepository;
import com.example.HomeWorkAug080823.repository.StudentRepository;
import com.example.HomeWorkAug080823.service.StudentService;
import com.example.HomeWorkAug080823.service.StudentServiceImpl;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(StudentController.class)
public class StudentControllerTest {


        @Autowired
        private MockMvc mockMvc;
        @MockBean
        private StudentRepository studentRepository;
        @SpyBean
        private StudentServiceImpl studentService;
        @InjectMocks
        private StudentController studentController;


        @Test
        public void saveStudentTest() throws Exception {
            final String name = "Egor";
            final int age = 18;

            final String name2 = "Igor";
            final int age2 = 25;

            JSONObject facultyObject = new JSONObject();
            facultyObject.put("name", name);
            facultyObject.put("age", age);

            JSONObject facultyObject2 = new JSONObject();
            facultyObject2.put("name", name2);
            facultyObject2.put("age", age2);

            Student student = new Student();
            student.setId(1);
            student.setName(name);
            student.setAge(age);


            when(studentRepository.save(any(Student.class))).thenReturn(student);
            when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

            mockMvc.perform(MockMvcRequestBuilders
                            .post("/student")
                            .content(facultyObject.toString())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("1"))
                    .andExpect(jsonPath("$.name").value(name))
                    .andExpect(jsonPath("$.age").value(age));

            mockMvc.perform(MockMvcRequestBuilders
                            .get("/student/1")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("1"))
                    .andExpect(jsonPath("$.name").value(name))
                    .andExpect(jsonPath("$.age").value(age));

            student.setName(name2);
            student.setAge(age2);

            mockMvc.perform(MockMvcRequestBuilders
                            .put("/student/1")
                            .content(facultyObject2.toString())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("1"))
                    .andExpect(jsonPath("$.name").value(name2))
                    .andExpect(jsonPath("$.age").value(age2));

            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/student/1")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }
    }