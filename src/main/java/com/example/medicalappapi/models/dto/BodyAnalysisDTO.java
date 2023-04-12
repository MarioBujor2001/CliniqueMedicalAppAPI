package com.example.medicalappapi.models.dto;

import com.example.medicalappapi.models.enums.ActivityLevels;
import com.example.medicalappapi.models.enums.Genders;
import lombok.Data;

@Data
public class BodyAnalysisDTO {
    private float weight;
    private float height;

    private Genders gender;
    private ActivityLevels activityLevel;
}
