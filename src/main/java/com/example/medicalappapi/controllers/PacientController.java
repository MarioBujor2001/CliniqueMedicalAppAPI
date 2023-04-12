package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.*;
import com.example.medicalappapi.models.dto.BodyAnalysisDTO;
import com.example.medicalappapi.models.exception.MissingResourceException;
import com.example.medicalappapi.models.exception.RepoSaveException;
import com.example.medicalappapi.services.AppointmentService;
import com.example.medicalappapi.services.OrderService;
import com.example.medicalappapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patients")
public class PacientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) throws RepoSaveException {
        Patient pat = patientService.save(patient);
        if (pat != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(pat.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(pat);
        }
        throw new RepoSaveException();
    }

    @GetMapping
    public ResponseEntity<Iterable<Patient>> getAllPatients() {
        return ResponseEntity.ok(this.patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getSinglePatient(@PathVariable String id) throws MissingResourceException {
        Patient patient = this.patientService.findById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        }
        throw new MissingResourceException();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id,
                                                 @RequestBody Patient patient) throws MissingResourceException {
        Patient pat = this.patientService.update(id, patient);
        if (pat != null) {
            return ResponseEntity.ok(pat);
        }
        throw new MissingResourceException();
    }

    @PostMapping("/{id}/appointments")
    public ResponseEntity<Appointment> addAppointment(@PathVariable String id,
                                                      @RequestBody Appointment appointment) throws MissingResourceException {
        Appointment appointmentNew = this.appointmentService.newAppointment(id, appointment);

        if (appointmentNew != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(appointmentNew.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(appointmentNew);
        }
        throw new MissingResourceException();
    }

    @PostMapping("/{id}/orders")
    public ResponseEntity<Order> addOrder(@PathVariable String id,
                                          @RequestBody Order order) throws MissingResourceException, RepoSaveException {
        if(order.getInvestigations() == null){
            throw new RepoSaveException();
        }
        Order orderNew = this.orderService.newOrder(id, order);
        if(orderNew!=null){
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(orderNew.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(orderNew);
        }
        throw new MissingResourceException();
    }

    @PutMapping("/{id}/analysis")
    public ResponseEntity<BodyAnalysis> addBodyAnalysis(@PathVariable String id, @RequestBody BodyAnalysisDTO bodyAnalysisDTO) throws MissingResourceException {
        BodyAnalysis bodyAnalysis = this.patientService.addBodyAnalysis(id, bodyAnalysisDTO);
        if(bodyAnalysis == null){
            throw new MissingResourceException();
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bodyAnalysis.getId())
                .toUri();
        return ResponseEntity.created(uri).body(bodyAnalysis);
    }
}
