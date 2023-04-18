package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepo extends JpaRepository<Recommendation, Integer> {
}
