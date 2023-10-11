package com.example.HomeWorkAug080823;

import com.example.HomeWorkAug080823.controller.FacultyController;
import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.repository.FacultyRepository;
import com.example.HomeWorkAug080823.service.FacultyService;
import com.example.HomeWorkAug080823.service.FacultyServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FacultyServiceImplTest {

        private FacultyService facultyService;
        private FacultyRepository facultyRepository;

        @BeforeEach
        public void setUp() {
        facultyRepository = Mockito.mock(FacultyRepository.class);
        facultyService = new FacultyServiceImpl(facultyRepository);
    }

        @Test
        public void addFacultyTest() {
        assertEquals("name", "name");
        Faculty faculty = new Faculty(1,"red","MTF");
        when(facultyRepository.save(faculty)).thenReturn(faculty);
        assertEquals(facultyService.addFaculty(faculty), faculty);
    }




}
