package com.example.medicalappapi.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Specialties {
    @JsonProperty("orl")
    ORL,
    @JsonProperty("alergologie")
    Alergologie,
    @JsonProperty("cardiologie")
    Cardiologie,
    @JsonProperty("chirurgie")
    Chirurgie,
    @JsonProperty("cosmetica")
    Cosmetica,
    @JsonProperty("dermatologie")
    Dermatologie,
    @JsonProperty("endocrinologie")
    Endocrinologie,
    @JsonProperty("gastroenterologie")
    Gastroenterologie,
    @JsonProperty("kinetoterapie")
    Kinetoterapie,
    @JsonProperty("medicinaFamilie")
    MedicinaFamilie,
    @JsonProperty("nefrologie")
    Nefrologie,
    @JsonProperty("neurologie")
    Neurologie,
    @JsonProperty("obstreticaGinecologie")
    ObstreticaGinecologie,
    @JsonProperty("oftalmologie")
    Oftalmologie,
    @JsonProperty("pediatrie")
    Pediatrie,
    @JsonProperty("pneumologie")
    Pneumologie,
    @JsonProperty("urologie")
    Urologie
}
