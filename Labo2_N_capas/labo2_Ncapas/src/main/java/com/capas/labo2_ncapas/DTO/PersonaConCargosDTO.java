package com.capas.labo2_ncapas.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PersonaConCargosDTO {
    private Long id;
    private String nombre;
    private String dui;
    private String telefono;
    private List<CargoResponseDTO> cargos;
}