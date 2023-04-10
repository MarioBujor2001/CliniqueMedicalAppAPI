package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Medic;
import com.example.medicalappapi.models.Specialty;
import com.example.medicalappapi.repositories.SpecialtyRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    SpecialtyRepo specialtyRepo;

    public Specialty save(Specialty specialty){
        return specialtyRepo.save(specialty);
    }

    public Iterable<Specialty> findAll(){
        return specialtyRepo.findAll();
    }

    public Optional<Specialty> findById(Integer id){
        return specialtyRepo.findById(id);
    }
}
