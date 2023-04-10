package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient extends Person implements Serializable {
    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    @JsonIgnoreProperties("patient")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    @JsonIgnoreProperties("patient")
    private List<Order> orders = new ArrayList<>();

    public Patient(String id, String firstName, String lastName, String email, String cnp, Integer age, String address) {
        super(id, firstName, lastName, email, cnp, age, address);
    }
}
