package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.BodyAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyAnalysisRepo extends JpaRepository<BodyAnalysis, Integer> {
    BodyAnalysis findByPatient_Id(String id);
}
