package com.capas.labo2_ncapas;

import com.capas.labo2_ncapas.Model.*;
import com.capas.labo2_ncapas.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ZonaRepository zonaRepository;
    private final TipoCargoRepository tipoCargoRepository;
    private final PersonaRepository personaRepository;
    private final EstacionPolicialRepository estacionPolicialRepository;
    private final PoliciaRepository policiaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (zonaRepository.count() > 0) return; // evitar duplicados al reiniciar

        //ZONAS
        Zona ssCentro = zonaRepository.save(zona("San Salvador Centro", "San Salvador"));
        Zona ssEste = zonaRepository.save(zona("San Salvador Este", "San Salvador"));
        Zona ssOeste = zonaRepository.save(zona("San Salvador Oeste", "San Salvador"));
        Zona ssNorte = zonaRepository.save(zona("San Salvador Norte", "San Salvador"));
        Zona ssSur = zonaRepository.save(zona("San Salvador Sur", "San Salvador"));
        Zona laCentro = zonaRepository.save(zona("La Libertad Centro", "La Libertad"));

        //TIPOS DE CARGO
        tipoCargoRepository.save(tipoCargo("PROCESAL"));
        tipoCargoRepository.save(tipoCargo("PENAL"));

        //PERSONAS 6
        Persona p1 = personaRepository.save(persona("Juan Pérez", "01234567-8", "7111-1111", "Calle Principal", "Colonia Escalón", ssCentro));
        Persona p2 = personaRepository.save(persona("María López", "02345678-9", "7222-2222", "Calle Segunda", "Colonia Miramonte", ssEste));
        Persona p3 = personaRepository.save(persona("Carlos Martínez", "03456789-0", "7333-3333", "Calle Tercera", "Colonia Santa Marta", ssOeste));
        Persona p4 = personaRepository.save(persona("Ana García", "04567890-1", "7444-4444", "Calle Cuarta", "Residencial Las Flores", ssNorte));
        Persona p5 = personaRepository.save(persona("Luis Hernández", "05678901-2", "7555-5555", "Calle Quinta", "Colonia Jardines", ssSur));
        Persona p6 = personaRepository.save(persona("Rosa Flores", "06789012-3", "7666-6666", "Calle Sexta", "Colonia San Benito", laCentro));

        //ESTACIONES POLICIALES 4
        EstacionPolicial e1 = estacionPolicialRepository.save(estacion("Delegación San Salvador Centro", "1a Calle Poniente", "Colonia Centro", ssCentro));
        EstacionPolicial e2 = estacionPolicialRepository.save(estacion("Delegación San Salvador Este", "Calle Soyapango", "Colonia Iberia", ssEste));
        EstacionPolicial e3 = estacionPolicialRepository.save(estacion("Delegación San Salvador Norte", "Calle Apopa", "Colonia Las Palmas", ssNorte));
        EstacionPolicial e4 = estacionPolicialRepository.save(estacion("Delegación La Libertad", "Calle Opico", "Colonia El Rosario", laCentro));

        //POLICÍAS 2 por estacion
        Policia pol1 = policiaRepository.save(policia("POL-001", p1, e1));
        Policia pol2 = policiaRepository.save(policia("POL-002", p2, e1));
        Policia pol3 = policiaRepository.save(policia("POL-003", p3, e2));
        Policia pol4 = policiaRepository.save(policia("POL-004", p4, e2));
        Policia pol5 = policiaRepository.save(policia("POL-005", p5, e3));
        Policia pol6 = policiaRepository.save(policia("POL-006", p6, e3));
        Policia pol7 = policiaRepository.save(policia("POL-007", p1, e4));
        Policia pol8 = policiaRepository.save(policia("POL-008", p2, e4));

        //ASIGNAR DIRECTORES A ESTACIONES
        e1.setDirector(pol1);
        e2.setDirector(pol3);
        e3.setDirector(pol5);
        e4.setDirector(pol7);
        estacionPolicialRepository.saveAll(List.of(e1, e2, e3, e4));
    }

    private Zona zona(String nombre, String departamento) {
        Zona z = new Zona();
        z.setNombre(nombre);
        z.setDepartamento(departamento);
        return z;
    }

    private TipoCargo tipoCargo(String nombre) {
        TipoCargo t = new TipoCargo();
        t.setNombre(nombre);
        return t;
    }

    private Persona persona(String nombre, String dui, String telefono, String calle, String colonia, Zona zona) {
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setDui(dui);
        p.setTelefono(telefono);
        p.setCalle(calle);
        p.setColonia(colonia);
        p.setZona(zona);
        return p;
    }

    private EstacionPolicial estacion(String nombre, String calle, String colonia, Zona zona) {
        EstacionPolicial e = new EstacionPolicial();
        e.setNombre(nombre);
        e.setCalle(calle);
        e.setColonia(colonia);
        e.setZona(zona);
        return e;
    }

    private Policia policia(String codigo, Persona persona, EstacionPolicial estacion) {
        Policia p = new Policia();
        p.setCodigo(codigo);
        p.setPersona(persona);
        p.setEstacion(estacion);
        return p;
    }
}