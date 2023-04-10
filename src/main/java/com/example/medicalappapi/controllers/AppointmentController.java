package com.example.medicalappapi.controllers;

import com.example.medicalappapi.models.Appointment;
import com.example.medicalappapi.models.dto.ResultDTO;
import com.example.medicalappapi.models.exception.MissingResourceException;
import com.example.medicalappapi.services.AppointmentService;
import com.example.medicalappapi.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments(
            @RequestParam(required = false) String idPac,
            @RequestParam(required = false) String idMedic,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy-HH-mm") LocalDateTime date) throws MissingResourceException {
        if (idPac != null && !idPac.isEmpty()) {
            return ResponseEntity.ok(this.appointmentService.findAllForPatient(idPac));
        }
        if (idMedic != null && !idMedic.isEmpty() && date != null) {
            List<Appointment> appointments = this.appointmentService.findAllForMedicAndDate(idMedic, date);
            if (appointments.size() != 0) {
                return ResponseEntity.ok(appointments);
            }else{
                throw new MissingResourceException();
            }
        }
        return ResponseEntity.ok(this.appointmentService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Integer id) throws MissingResourceException {
        boolean isDeleted = this.appointmentService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok(new ResultDTO(true, "deleted"));
        }
        throw new MissingResourceException();
    }
}
