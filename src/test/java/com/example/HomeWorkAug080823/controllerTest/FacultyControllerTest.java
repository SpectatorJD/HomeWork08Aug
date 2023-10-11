package com.example.HomeWorkAug080823.controllerTest;

import com.example.HomeWorkAug080823.controller.FacultyController;
import com.example.HomeWorkAug080823.model.Faculty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTest {


    @LocalServerPort
    private int port;
    @Autowired
    private FacultyController facultyController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(facultyController).isNotNull();
    }
    @Test
    public void postFacultyControllerTest() throws Exception{
        Faculty faculty = new Faculty();
        faculty.setId(5L);
        faculty.setName("Had");
        faculty.setColor("blue");
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty",faculty, String.class))
                .isNotNull();
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty/color",faculty, String.class))
                .isNotNull();

    }
    @Test
    public void getNameStudentFacultyTest() throws Exception{
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/studentFaculty", String.class))
                .isNotNull();
    }
}
