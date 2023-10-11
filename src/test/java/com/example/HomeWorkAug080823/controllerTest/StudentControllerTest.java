package com.example.HomeWorkAug080823.controllerTest;

import com.example.HomeWorkAug080823.controller.FacultyController;
import com.example.HomeWorkAug080823.controller.StudentController;
import com.example.HomeWorkAug080823.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

public class StudentControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }
    @Test
    public void postStudentControllerTest () throws  Exception{
        Student student = new Student();
        student.setId(10L);
        student.setName("Misha");
        student.setAge(18);
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student",student, String.class))
                .isNotNull();
    }
    @Test
    public void getStudentControllerTest() throws Exception{
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/age", String.class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/facultyStudent", String.class))
                .isNotNull();
    }
}
