package com.capas.labo2_ncapas.servicIMPL;

import com.capas.labo2_ncapas.DTO.*;
import com.capas.labo2_ncapas.Exception.ResourceNotFoundExcep;
import com.capas.labo2_ncapas.Model.*;
import com.capas.labo2_ncapas.Repository.*;
import com.capas.labo2_ncapas.Service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final ZonaRepository zonaRepository;
    private final CargoRepository cargoRepository;

    @Override
    public PersonaConCargosDTO registrarPersona(PersonaRequestDTO dto) {
        Zona zona = zonaRepository.findById(dto.getZonaId())
                .orElseThrow(() -> new ResourceNotFoundExcep("Zona no encontrada con id: " + dto.getZonaId()));

        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setDui(dto.getDui());
        persona.setTelefono(dto.getTelefono());
        persona.setCalle(dto.getCalle());
        persona.setColonia(dto.getColonia());
        persona.setZona(zona);

        personaRepository.save(persona);
        return mapToPersonaConCargosDTO(persona);
    }

    @Override
    public PersonaConCargosDTO obtenerCargosDePersona(Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundExcep("Persona no encontrada con id: " + personaId));
        return mapToPersonaConCargosDTO(persona);
    }

    @Override
    public List<PersonaConCargosDTO> obtenerPersonasConCargos() {
        return cargoRepository.findPersonasConCargos()
                .stream()
                .map(this::mapToPersonaConCargosDTO)
                .toList();
    }

    @Override
    public List<masBuscadosDTO> obtenerTop3MasAcusados() {
        return cargoRepository.findTop3MasAcusados()
                .stream()
                .map(row -> {
                    masBuscadosDTO dto = new masBuscadosDTO();
                    Persona p = (Persona) row[0];
                    dto.setId(p.getId());
                    dto.setNombre(p.getNombre());
                    dto.setDui(p.getDui());
                    dto.setTotalCargos((Long) row[1]);
                    return dto;
                })
                .toList();
    }

    private PersonaConCargosDTO mapToPersonaConCargosDTO(Persona persona) {
        PersonaConCargosDTO dto = new PersonaConCargosDTO();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setDui(persona.getDui());
        dto.setTelefono(persona.getTelefono());

        List<CargoResponseDTO> cargos = cargoRepository.findByAcusado(persona)
                .stream()
                .map(cargo -> {
                    CargoResponseDTO cargoDTO = new CargoResponseDTO();
                    cargoDTO.setId(cargo.getId());
                    cargoDTO.setFechaCargo(cargo.getFecha().toString());
                    cargoDTO.setTipoCargo(cargo.getTipoCargo().getNombre());
                    cargoDTO.setDescripcion(cargo.getDescripcion());
                    cargoDTO.setNombreAcusador(cargo.getAcusador().getNombre());
                    cargoDTO.setDuiAcusador(cargo.getAcusador().getDui());
                    cargoDTO.setCodigoPolicia(cargo.getPolicia().getCodigo());
                    return cargoDTO;
                })
                .toList();

        dto.setCargos(cargos);
        return dto;
    }
}
