package com.capas.labo2_ncapas.servicIMPL;

import com.capas.labo2_ncapas.DTO.CargoRequestDTO;
import com.capas.labo2_ncapas.DTO.CargoResponseDTO;
import com.capas.labo2_ncapas.Exception.ResourceNotFoundExcep;
import com.capas.labo2_ncapas.Model.*;
import com.capas.labo2_ncapas.Repository.*;
import com.capas.labo2_ncapas.Service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final PersonaRepository personaRepository;
    private final TipoCargoRepository tipoCargoRepository;
    private final PoliciaRepository policiaRepository;

    @Override
    public CargoResponseDTO registrarCargo(CargoRequestDTO dto) {
        Persona acusador = personaRepository.findById(dto.getAcusadorId())
                .orElseThrow(() -> new ResourceNotFoundExcep("Acusador no encontrado con id: " + dto.getAcusadorId()));

        Persona acusado = personaRepository.findById(dto.getAcusadoId())
                .orElseThrow(() -> new ResourceNotFoundExcep("Acusado no encontrado con id: " + dto.getAcusadoId()));

        TipoCargo tipoCargo = tipoCargoRepository.findById(dto.getTipoCargoId())
                .orElseThrow(() -> new ResourceNotFoundExcep("Tipo de cargo no encontrado con id: " + dto.getTipoCargoId()));

        Policia policia = policiaRepository.findById(dto.getPoliciaId())
                .orElseThrow(() -> new ResourceNotFoundExcep("Policía no encontrado con id: " + dto.getPoliciaId()));

        Cargo cargo = new Cargo();
        cargo.setFecha(LocalDate.now());
        cargo.setDescripcion(dto.getDescripcion());
        cargo.setAcusador(acusador);
        cargo.setAcusado(acusado);
        cargo.setTipoCargo(tipoCargo);
        cargo.setPolicia(policia);

        cargoRepository.save(cargo);

        CargoResponseDTO response = new CargoResponseDTO();
        response.setId(cargo.getId());
        response.setFechaCargo(cargo.getFecha().toString());
        response.setTipoCargo(tipoCargo.getNombre());
        response.setDescripcion(cargo.getDescripcion());
        response.setNombreAcusador(acusador.getNombre());
        response.setDuiAcusador(acusador.getDui());
        response.setCodigoPolicia(policia.getCodigo());

        return response;
    }
}