package com.capas.labo2_ncapas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El DUI es obligatorio")
    private String dui;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @NotBlank(message = "La calle es obligatoria")
    private String calle;

    @NotBlank(message = "La colonia es obligatoria")
    private String colonia;

    @NotNull(message = "La zona es obligatoria")
    private Long zonaId;
}