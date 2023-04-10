package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Investigation;
import com.example.medicalappapi.services.InvestigationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investigations")
public class InvestigationController {
    @Autowired
    InvestigationService investigationService;
    @GetMapping
    public ResponseEntity<Iterable<Investigation>> getInvestigations(){
        return ResponseEntity.ok(this.investigationService.findAll());
    }
}
