package com.example.medicalappapi.services;

import com.example.medicalappapi.models.BodyAnalysis;
import com.example.medicalappapi.models.Patient;
import com.example.medicalappapi.models.dto.BodyAnalysisDTO;
import com.example.medicalappapi.models.enums.Genders;
import com.example.medicalappapi.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

    @Autowired
    BodyAnalysisService bodyAnalysisService;

    public Patient save(Patient patient) {
        return this.patientRepo.save(patient);
    }

    public Iterable<Patient> findAll() {
        return this.patientRepo.findAll();
    }

    public Patient findById(String id) {
        Optional<Patient> patient = this.patientRepo.findById(id);
        return patient.orElse(null);
    }

    public Patient update(String id, Patient patient) {
        Patient pat = findById(id);
        if(pat!=null){
            pat.setFirstName(patient.getFirstName());
            pat.setLastName(patient.getLastName());
            pat.setEmail(patient.getEmail());
            pat.setCnp(patient.getCnp());
            pat.setAge(patient.getAge());
            pat.setAddress(patient.getAddress());
            pat.setPhotoUrl(patient.getPhotoUrl());
            return this.patientRepo.save(pat);
        }
        return null;
    }

    public BodyAnalysis addBodyAnalysis(String id, BodyAnalysisDTO bodyAnalysisDTO) {
        Patient patient = this.patientRepo.findById(id).orElse(null);
        if(patient==null){
            return null;
        }
        BodyAnalysis body = this.bodyAnalysisService.findByPatientId(id);
        if(body == null){
            body = new BodyAnalysis();
        }
        body.setPatient(patient);
        body.setHeight(bodyAnalysisDTO.getHeight());
        body.setWeight(bodyAnalysisDTO.getWeight());
        body.setGender(bodyAnalysisDTO.getGender());
        body.setActivityLevel(bodyAnalysisDTO.getActivityLevel());
        double bmr = 0;
        if(body.getGender() == Genders.Male){
            bmr = 10 * body.getWeight() + 6.25*body.getHeight()-5*patient.getAge()+5;
        }else{
            bmr = 10 * body.getWeight() + 6.25*body.getHeight()-5*patient.getAge()-161;
        }
        body.setBmr((float) bmr);
        double recommendedKcal = 0;
        switch (body.getActivityLevel()){
            case Sedentary -> recommendedKcal = bmr;
            case Light -> recommendedKcal = bmr * 1.2;
            case Moderate -> recommendedKcal = bmr * 1.4;
            case Active -> recommendedKcal = bmr * 1.6;
        }
        body.setRecommendedKcal((float) recommendedKcal);
        return this.bodyAnalysisService.save(body);
    }
}
