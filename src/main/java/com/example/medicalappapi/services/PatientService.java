package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Patient;
import com.example.medicalappapi.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

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
}
