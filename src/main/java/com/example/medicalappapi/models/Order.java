package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"orders", "appointments"})
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "orders_investigations",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "investigation_id"))
    List<Investigation> investigations;
}
