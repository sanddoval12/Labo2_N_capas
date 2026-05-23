package com.capas.labo2_ncapas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CargoRequestDTO {

    @NotNull(message = "El acusador es obligatorio")
    private Long acusadorId;

    @NotNull(message = "El acusado es obligatorio")
    private Long acusadoId;

    @NotNull(message = "El tipo de cargo es obligatorio")
    private Long tipoCargoId;

    @NotNull(message = "El policía es obligatorio")
    private Long policiaId;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
}