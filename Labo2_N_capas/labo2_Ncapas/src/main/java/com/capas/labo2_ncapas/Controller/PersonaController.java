package com.capas.labo2_ncapas.Controller;


import com.capas.labo2_ncapas.DTO.*;
import com.capas.labo2_ncapas.Service.PersonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaConCargosDTO> registrarPersona(@Valid @RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.registrarPersona(dto));
    }

    @GetMapping("/{id}/cargos")
    public ResponseEntity<PersonaConCargosDTO> obtenerCargosDePersona(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.obtenerCargosDePersona(id));
    }

    @GetMapping("/con-cargos")
    public ResponseEntity<List<PersonaConCargosDTO>> obtenerPersonasConCargos() {
        return ResponseEntity.ok(personaService.obtenerPersonasConCargos());
    }

    @GetMapping("/mas-buscados")
    public ResponseEntity<List<masBuscadosDTO>> obtenerTop3MasAcusados() {
        return ResponseEntity.ok(personaService.obtenerTop3MasAcusados());
    }
}
