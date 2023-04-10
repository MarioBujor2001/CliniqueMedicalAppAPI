package com.example.medicalappapi.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDTO {
    private boolean succes;
    private String message;
}
