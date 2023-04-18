package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "diagnosis")
@Getter
@Setter
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "diagnosis", orphanRemoval = true)
    private List<Recommendation> recommendations;

    @ManyToMany
    @JoinTable(name = "patients_diagnosis",
            joinColumns = @JoinColumn(name = "diagnosis_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    @JsonIgnore
    private List<Patient> patients;
}
