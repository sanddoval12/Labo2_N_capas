package com.capas.labo2_ncapas.Controller;


import com.capas.labo2_ncapas.DTO.CargoRequestDTO;
import com.capas.labo2_ncapas.DTO.CargoResponseDTO;
import com.capas.labo2_ncapas.Service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @PostMapping
    public ResponseEntity<CargoResponseDTO> registrarCargo(@Valid @RequestBody CargoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.registrarCargo(dto));
    }
}