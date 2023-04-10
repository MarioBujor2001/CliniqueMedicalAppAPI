package com.example.medicalappapi.services;

import com.example.medicalappapi.models.Appointment;
import com.example.medicalappapi.models.Medic;
import com.example.medicalappapi.models.Patient;
import com.example.medicalappapi.repositories.AppointmentRepo;
import com.example.medicalappapi.repositories.MedicRepo;
import com.example.medicalappapi.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;

    @Autowired
    PatientService patientService;

    @Autowired
    MedicService medicService;

    public Appointment newAppointment(String idPac, Appointment appointment) {
        Patient p = patientService.findById(idPac);
        if (p != null) {
            appointment.setPatient(p);
            appointment.setMedic(this.medicService.findById(appointment.getMedic().getId()));
            this.appointmentRepo.save(appointment);
            return this.appointmentRepo.findById(appointment.getId()).orElse(null);
        }
        return null;
    }

    public List<Appointment> findAll() {
        return (List<Appointment>) this.appointmentRepo.findAll();
    }


    public List<Appointment> findAllForPatient(String idPac) {
        return this.appointmentRepo.findByPatient_Id(idPac);
    }

    public boolean delete(Integer id) {
        Appointment app = (this.appointmentRepo.findById(id)).orElse(null);
        if(app!=null){
            this.appointmentRepo.delete(app);
            return true;
        }
        return false;
    }

    public List<Appointment> findAllForMedicAndDate(String idMedic, LocalDateTime date) {
        return this.appointmentRepo.findByMedic_IdAndDate(idMedic, date);
    }
}
