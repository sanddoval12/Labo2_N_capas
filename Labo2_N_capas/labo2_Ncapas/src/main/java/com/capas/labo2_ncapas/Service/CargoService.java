package com.capas.labo2_ncapas.Service;

import com.capas.labo2_ncapas.DTO.CargoRequestDTO;
import com.capas.labo2_ncapas.DTO.CargoResponseDTO;

public interface CargoService {
    CargoResponseDTO registrarCargo(CargoRequestDTO dto);
}