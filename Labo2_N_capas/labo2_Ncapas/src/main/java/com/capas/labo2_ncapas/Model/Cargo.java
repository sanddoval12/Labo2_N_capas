package com.capas.labo2_ncapas.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "acusador_id", nullable = false)
    private Persona acusador;

    @ManyToOne
    @JoinColumn(name = "acusado_id", nullable = false)
    private Persona acusado;

    @ManyToOne
    @JoinColumn(name = "tipo_cargo_id", nullable = false)
    private TipoCargo tipoCargo;

    @ManyToOne
    @JoinColumn(name = "policia_id", nullable = false)
    private Policia policia;
}