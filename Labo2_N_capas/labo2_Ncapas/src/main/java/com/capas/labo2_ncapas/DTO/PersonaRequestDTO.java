package com.capas.labo2_ncapas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo puede contener letras")
    private String nombre;

    @NotBlank(message = "El DUI es obligatorio")
    @Pattern(regexp = "^\\d{8}-\\d$", message = "El DUI debe tener el formato 00000000-0")
    private String dui;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^\\d{4}-\\d{4}$", message = "El teléfono debe tener el formato 0000-0000")
    private String telefono;

    @NotBlank(message = "La calle es obligatoria")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s0-9]+$", message = "La calle solo puede contener letras y números")
    private String calle;

    @NotBlank(message = "La colonia es obligatoria")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s0-9]+$", message = "La colonia solo puede contener letras y números")
    private String colonia;

    @NotNull(message = "La zona es obligatoria")
    private Long zonaId;
}