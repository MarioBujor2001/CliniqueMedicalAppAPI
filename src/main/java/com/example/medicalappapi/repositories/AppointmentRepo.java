package com.example.medicalappapi.repositories;

import com.example.medicalappapi.models.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepo extends CrudRepository<Appointment, Integer> {
    List<Appointment> findByPatient_Id(String id);

    List<Appointment> findByMedic_IdAndDate(String id, LocalDateTime date);


}
