package com.example.HomeWorkAug080823.repository;

import com.example.HomeWorkAug080823.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName (String name);
    Collection<Faculty> findAllByColor(String color);


}