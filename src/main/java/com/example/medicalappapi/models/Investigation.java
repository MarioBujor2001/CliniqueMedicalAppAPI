package com.example.medicalappapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name = "investigations")
@Getter
@Setter
@NoArgsConstructor
public class Investigation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="id_spec", referencedColumnName = "id")
    private Specialty specialty;
    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "investigations")
    private List<Order> orders;

    public Investigation(String name, Specialty specialty, Float price, String description, List<Order> orders) {
        this.name = name;
        this.specialty = specialty;
        this.price = price;
        this.description = description;
        this.orders = orders;
    }
}
