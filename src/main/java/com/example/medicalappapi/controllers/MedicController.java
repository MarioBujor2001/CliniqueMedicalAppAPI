package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Medic;
import com.example.medicalappapi.models.exception.MissingResourceException;
import com.example.medicalappapi.models.exception.RepoSaveException;
import com.example.medicalappapi.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/medics")
public class MedicController {
    @Autowired
    MedicService medicService;

    @PostMapping
    public ResponseEntity<Medic> addMedic(@RequestBody Medic medic) throws RepoSaveException {
        Medic medicSaved = medicService.save(medic);
        if(medicSaved!=null){
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(medic.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(medicSaved);
        }
        throw new RepoSaveException();
    }

    @PutMapping(path = "/{idMedic}")
    public ResponseEntity<Medic> addMedicSpec(@PathVariable(name = "idMedic") String idMedic,
                                        @RequestParam(name = "idSpec") Integer idSpec) throws MissingResourceException {
        Medic medic = medicService.addMedicSpec(idMedic, idSpec);
        if(medic!=null){
            return ResponseEntity.ok(medic);
        }
        throw new MissingResourceException();
    }

    @GetMapping
    public ResponseEntity<Iterable<Medic>> allMedic() {
        return ResponseEntity.ok(this.medicService.findAll());
    }
}
