package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    @Column(name="comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    @JsonIgnoreProperties("appointments")
//    @JsonIgnore
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
//    @JsonIgnoreProperties("appointments")
    @JsonIgnore
    private Patient patient;

    public Appointment(LocalDateTime date, String comments, Medic medic, Patient patient) {
        this.date = date;
        this.comments = comments;
        this.medic = medic;
        this.patient = patient;
    }
}
