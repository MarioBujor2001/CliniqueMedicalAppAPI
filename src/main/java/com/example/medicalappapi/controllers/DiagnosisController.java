package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Diagnosis;
import com.example.medicalappapi.models.exception.MissingResourceException;
import com.example.medicalappapi.services.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
    @Autowired
    DiagnosisService diagnosisService;
    @GetMapping("/{id}")
    public ResponseEntity<Diagnosis> getDiagnosis(@PathVariable int id) throws MissingResourceException {
        return ResponseEntity.ok(this.diagnosisService.findById(id));
    }
}
