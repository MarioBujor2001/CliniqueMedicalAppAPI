package com.example.medicalappapi.models;

import com.example.medicalappapi.models.enums.Specialties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "specialties")
@Getter
@Setter
@NoArgsConstructor
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", nullable = false)
    private Specialties type;

    @Column(name = "description", nullable = false)
    private String description;

    public Specialty(Specialties type, String description) {
        this.type = type;
        this.description = description;
    }
}
