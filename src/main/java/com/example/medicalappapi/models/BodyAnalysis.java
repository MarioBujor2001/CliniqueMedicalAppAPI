package com.example.medicalappapi.models;

import com.example.medicalappapi.models.enums.ActivityLevels;
import com.example.medicalappapi.models.enums.Genders;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "body_analysis")
@NoArgsConstructor
@Getter
@Setter
public class BodyAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float weight;
    @Column(nullable = false)
    private float height;
    @Column(nullable = false)
    private Genders gender;
    @Column(nullable = false)
    private ActivityLevels activityLevel;
    private float bmr;
    private float recommendedKcal;

    @OneToOne
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    private Patient patient;
}
