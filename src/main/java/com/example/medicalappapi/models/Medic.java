package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "medics")
@Getter
@Setter
@NoArgsConstructor
public class Medic extends Person implements Serializable {
    @OneToOne
    @JoinColumn(name="id_spec", referencedColumnName = "id")
    private Specialty specialty;

    @Column(name = "seniority", nullable = false)
    private Integer seniority;

    @Column(name="rating", nullable = false)
    private Float rating;

    @OneToMany(mappedBy = "medic", orphanRemoval = true)
    @JsonIgnoreProperties("medic")
    private List<Appointment> appointments = new ArrayList<>();

}
