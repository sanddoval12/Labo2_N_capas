package com.capas.labo2_ncapas.DTO;

import lombok.Data;

@Data
public class CargoResponseDTO {
    private Long id;
    private String fechaCargo;
    private String tipoCargo;
    private String descripcion;
    private String nombreAcusador;
    private String duiAcusador;
    private String codigoPolicia;
}