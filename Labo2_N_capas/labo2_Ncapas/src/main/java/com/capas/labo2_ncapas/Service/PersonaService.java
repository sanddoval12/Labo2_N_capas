package com.capas.labo2_ncapas.Service;

import com.capas.labo2_ncapas.DTO.*;
import java.util.List;

public interface PersonaService {
    PersonaConCargosDTO registrarPersona(PersonaRequestDTO dto);
    PersonaConCargosDTO obtenerCargosDePersona(Long personaId);
    List<PersonaConCargosDTO> obtenerPersonasConCargos();
    List<masBuscadosDTO> obtenerTop3MasAcusados();
}