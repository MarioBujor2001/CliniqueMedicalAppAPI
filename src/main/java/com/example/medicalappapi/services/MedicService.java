package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Medic;
import com.example.medicalappapi.models.Specialty;
import com.example.medicalappapi.repositories.MedicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicService {
    @Autowired
    MedicRepo medicRepo;

    @Autowired
    SpecialtyService specialtyService;

    public Medic save(Medic medic) {
        return medicRepo.save(medic);
    }

    public Iterable<Medic> findAll() {
        return medicRepo.findAll();
    }

    public Medic findById(String idMedic) {
        return medicRepo.findById(idMedic).orElse(null);
    }

    public Medic addMedicSpec(String idMedic, Integer idSpec) {
        Medic targetMedic = medicRepo.findById(idMedic).orElse(null);
        Specialty targetSpec = specialtyService.findById(idSpec).orElse(null);
        if (targetMedic != null) {
            if (targetSpec!=null) {
                targetMedic.setSpecialty(targetSpec);
                medicRepo.save(targetMedic);
                return targetMedic;
            }
            return null;
        }
        return null;
    }
}
