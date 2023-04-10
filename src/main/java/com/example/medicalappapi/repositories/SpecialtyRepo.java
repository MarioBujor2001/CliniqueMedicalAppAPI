package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Specialty, Integer> {
}
