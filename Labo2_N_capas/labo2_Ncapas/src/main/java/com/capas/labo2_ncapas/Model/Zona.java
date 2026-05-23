package com.capas.labo2_ncapas.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String departamento;
}