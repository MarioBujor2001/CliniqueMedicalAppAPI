package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Medic;
import com.example.medicalappapi.models.Specialty;
import com.example.medicalappapi.models.exception.RepoSaveException;
import com.example.medicalappapi.services.SpecialtyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/specs")
public class SpecialtyController {
    @Autowired
    SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<Specialty> addSpec(@RequestBody Specialty specialty) throws RepoSaveException {
        Specialty spec = specialtyService.save(specialty);
        if(spec!=null){
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(spec.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(spec);
        }
        throw new RepoSaveException();
    }

    @GetMapping
    public ResponseEntity<Iterable<Specialty>> allSpec() {
        return ResponseEntity.ok(specialtyService.findAll());
    }
}
