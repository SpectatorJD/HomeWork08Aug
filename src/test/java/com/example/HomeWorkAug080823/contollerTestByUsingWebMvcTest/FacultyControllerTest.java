package com.example.HomeWorkAug080823.contollerTestByUsingWebMvcTest;

import com.example.HomeWorkAug080823.controller.FacultyController;
import com.example.HomeWorkAug080823.controller.StudentController;
import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.model.Student;
import com.example.HomeWorkAug080823.repository.FacultyRepository;
import com.example.HomeWorkAug080823.repository.StudentRepository;
import com.example.HomeWorkAug080823.service.FacultyService;
import com.example.HomeWorkAug080823.service.FacultyServiceImpl;
import com.example.HomeWorkAug080823.service.StudentService;
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

@WebMvcTest(FacultyController.class)
public class FacultyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FacultyRepository facultyRepository;
    @SpyBean
    private FacultyServiceImpl facultyService;
    @InjectMocks
    private FacultyController facultyController;


    @Test
    public void saveFacultyTest() throws Exception {
        final String name = "MTF";
        final String color = "orange";

        final String name2 = "MBF";
        final String color2 = "yellow";

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);

        JSONObject facultyObject2 = new JSONObject();
        facultyObject2.put("name", name2);
        facultyObject2.put("color", color2);

        Faculty faculty = new Faculty();
        faculty.setId(1);
        faculty.setName(name);
        faculty.setColor(color);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

        faculty.setName(name2);
        faculty.setColor(color2);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculty/1")
                        .content(facultyObject2.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value(name2))
                .andExpect(jsonPath("$.color").value(color2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/faculty/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
