package com.example.HomeWorkAug080823.repository;

import com.example.HomeWorkAug080823.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long studentID);
}
