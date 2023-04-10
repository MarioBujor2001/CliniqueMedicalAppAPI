package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Investigation;
import org.springframework.data.repository.CrudRepository;

public interface InvestigationRepo extends CrudRepository<Investigation, Integer> {
}
