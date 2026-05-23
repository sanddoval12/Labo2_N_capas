package com.capas.labo2_ncapas.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "policia")
public class Policia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "estacion_id", nullable = false)
    private EstacionPolicial estacion;
}