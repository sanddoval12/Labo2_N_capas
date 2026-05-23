package com.capas.labo2_ncapas.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estacion_policial")
public class EstacionPolicial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String colonia;

    @ManyToOne
    @JoinColumn(name = "zona_id", nullable = false)
    private Zona zona;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Policia director;
}
