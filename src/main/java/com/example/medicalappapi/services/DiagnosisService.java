package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Diagnosis;
import com.example.medicalappapi.models.exception.MissingResourceException;
import com.example.medicalappapi.repositories.DiagnosisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisService {
    @Autowired
    DiagnosisRepo diagnosisRepo;

    public Diagnosis findById(int id) throws MissingResourceException {
        return this.diagnosisRepo.findById(id)
                .orElseThrow(MissingResourceException::new);
    }
}
