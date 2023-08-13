package com.example.HomeWorkAug080823;

import com.example.HomeWorkAug080823.model.Faculty;
import com.example.HomeWorkAug080823.repository.FacultyRepository;
import com.example.HomeWorkAug080823.service.FacultyService;
import com.example.HomeWorkAug080823.service.FacultyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class FacultyServiceImplTest {
    private FacultyService facultyService;
    private FacultyRepository facultyRepository;
    @BeforeEach
    public void setUp(){
        facultyRepository = Mockito.mock(FacultyRepository.class);
        facultyService = new FacultyServiceImpl(facultyRepository);
    }
    @Test
    public void shouldReturnFacultyWhenFacultyExists(){
        when(facultyRepository.findById(1L)).thenReturn(Optional.of(new Faculty(1L,"New", "black")));
        facultyService.findFaculty(1L);
        verify(facultyRepository, times(1)).findById(1L);
    }

}
