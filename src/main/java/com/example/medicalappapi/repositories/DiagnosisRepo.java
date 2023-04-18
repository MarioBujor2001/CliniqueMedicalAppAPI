package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer> {
}
