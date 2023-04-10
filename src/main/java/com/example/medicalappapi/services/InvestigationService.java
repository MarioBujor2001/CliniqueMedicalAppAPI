package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Appointment;
import com.example.medicalappapi.models.Investigation;
import com.example.medicalappapi.repositories.InvestigationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestigationService {
    @Autowired
    InvestigationRepo investigationRepo;


    public Iterable<Investigation> findAll() {
        return this.investigationRepo.findAll();
    }
}
