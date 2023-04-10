package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumPostRepo extends JpaRepository<ForumPost, Integer> {
}
