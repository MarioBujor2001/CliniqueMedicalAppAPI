package com.example.medicalappapi.services;

import com.example.medicalappapi.models.BodyAnalysis;
import com.example.medicalappapi.repositories.BodyAnalysisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyAnalysisService {
    @Autowired
    BodyAnalysisRepo bodyAnalysisRepo;

    public BodyAnalysis save(BodyAnalysis body){
        return this.bodyAnalysisRepo.save(body);
    }

    public BodyAnalysis findByPatientId(String id){
        return this.bodyAnalysisRepo.findByPatient_Id(id);
    }
}
