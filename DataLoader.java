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
        if (zonaRepository.count() > 0) return; //para evitar los duplicados al reiniciar

        //zonas del pais

        //san salvador
        Zona ssCentro = zonaRepository.save(zona("San Salvador Centro", "San Salvador"));
        Zona ssEste = zonaRepository.save(zona("San Salvador Este", "San Salvador"));
        Zona ssOeste = zonaRepository.save(zona("San Salvador Oeste", "San Salvador"));
        Zona ssNorte = zonaRepository.save(zona("San Salvador Norte", "San Salvador"));
        Zona ssSur = zonaRepository.save(zona("San Salvador Sur", "San Salvador"));

        //la libertad
        Zona laCentro = zonaRepository.save(zona("La Libertad Centro", "La Libertad"));
        Zona laNorte = zonaRepository.save(zona("La Libertad Norte", "La Libertad"));
        Zona laOeste = zonaRepository.save(zona("La Libertad Oeste", "La Libertad"));
        Zona laEste = zonaRepository.save(zona("La Libertad Este", "La Libertad"));
        Zona laCosta = zonaRepository.save(zona("La Libertad Costa", "La Libertad"));
        Zona laSur = zonaRepository.save(zona("La Libertad Sur", "La Libertad"));

        //ahuachapan
        Zona ahuaNorte = zonaRepository.save(zona("Ahuachapan Norte", "Ahuachapan"));
        Zona ahuaCentro = zonaRepository.save(zona("Ahuachapan Centro", "Ahuachapan"));
        Zona ahuaSur = zonaRepository.save(zona("Ahuachapan Sur", "Ahuachapan"));

        //chalatenango
        Zona chalaNorte = zonaRepository.save(zona("Chalatenango Norte", "Chalatenango"));
        Zona chalaCentro = zonaRepository.save(zona("Chalatenango Centro", "Chalatenango"));
        Zona chalaSur = zonaRepository.save(zona("Chalatenango Sur", "Chalatenango"));

        //cuscatlan
        Zona cuscaNorte = zonaRepository.save(zona("Cuscatlan Norte", "Cuscatlan"));
        Zona cuscaSur = zonaRepository.save(zona("Cuscatlan Sur", "Cuscatlan"));

        //cabañas
        Zona cabaEste = zonaRepository.save(zona("Cabañas Este", "Cabañas"));
        Zona cabaOeste = zonaRepository.save(zona("Cabañas Oste", "Cabañas"));

        //la paz
        Zona pazOeste = zonaRepository.save(zona("La Paz Oeste", "La Paz"));
        Zona pazCentro = zonaRepository.save(zona("La Paz Centro", "La Paz"));
        Zona pazEste = zonaRepository.save(zona("La Paz Este", "La Paz"));

        //la union
        Zona uniNorte = zonaRepository.save(zona("La Union Norte", "La Union"));
        Zona uniSur = zonaRepository.save(zona("La Union Sur", "La Union"));

        //usulutan
        Zona usuNorte = zonaRepository.save(zona("Usulutan Norte", "Usulutan"));
        Zona usuEste = zonaRepository.save(zona("Usulutan Este", "Usulutan"));
        Zona usuOeste = zonaRepository.save(zona("Usulutan Oeste", "Usulutan"));

        //sonsonate
        Zona sonsoNorte = zonaRepository.save(zona("Sonsonate Norte", "Sonsonate"));
        Zona sonsoCentro = zonaRepository.save(zona("Sonsonate Centro", "Sonsonate"));
        Zona sonsoEste = zonaRepository.save(zona("Sonsonate Este", "Sonsonate"));
        Zona sonsoOeste = zonaRepository.save(zona("Sonsonate Oeste", "Sonsonate"));

        //santa ana
        Zona anaNorte = zonaRepository.save(zona("Santa Ana Norte", "Santa Ana"));
        Zona anaCentro = zonaRepository.save(zona("Santa Ana Centro", "Santa Ana"));
        Zona anaEste = zonaRepository.save(zona("Santa Ana Este", "Santa Ana"));
        Zona anaOeste = zonaRepository.save(zona("Santa Ana Oeste", "Santa Ana"));

        //san vicente
        Zona viceNorte = zonaRepository.save(zona("San Vicente Norte", "San Vicente"));
        Zona viceSur = zonaRepository.save(zona("San Vicente Sur", "San Vicente"));

        //san miguel
        Zona sanmiNorte = zonaRepository.save(zona("San Miguel Norte", "San Miguel"));
        Zona sanmiCentro = zonaRepository.save(zona("San Miguel Centro", "San Miguel"));
        Zona sanmiOeste = zonaRepository.save(zona("San Miguel Oete", "San Miguel"));

        //morazan
        Zona moraNorte = zonaRepository.save(zona("Morazan Norte", "Morazan"));
        Zona moraSur = zonaRepository.save(zona("Morazan Sur", "Morazan"));


        tipoCargoRepository.save(tipoCargo("PROCESAL"));
        tipoCargoRepository.save(tipoCargo("PENAL"));

        //personas (6)
        Persona p1 = personaRepository.save(persona("Juan Pérez", "01234567-8", "7111-1111", "Calle Principal", "Colonia Escalón", ssCentro));
        Persona p2 = personaRepository.save(persona("María López", "02345678-9", "7222-2222", "Calle Segunda", "Colonia Miramonte", ssEste));
        Persona p3 = personaRepository.save(persona("Carlos Martínez", "03456789-0", "7333-3333", "Calle Tercera", "Colonia Santa Marta", ssOeste));
        Persona p4 = personaRepository.save(persona("Ana García", "04567890-1", "7444-4444", "Calle Cuarta", "Residencial Las Flores", ssNorte));
        Persona p5 = personaRepository.save(persona("Luis Hernández", "05678901-2", "7555-5555", "Calle Quinta", "Colonia Jardines", ssSur));
        Persona p6 = personaRepository.save(persona("Rosa Flores", "06789012-3", "7666-6666", "Calle Sexta", "Colonia San Benito", laCentro));

        //estaciones de policia (4)
        EstacionPolicial e1 = estacionPolicialRepository.save(estacion("Delegación San Salvador Centro", "1a Calle Poniente", "Colonia Centro", ssCentro));
        EstacionPolicial e2 = estacionPolicialRepository.save(estacion("Delegación San Salvador Este", "Calle Soyapango", "Colonia Iberia", ssEste));
        EstacionPolicial e3 = estacionPolicialRepository.save(estacion("Delegación San Salvador Norte", "Calle Apopa", "Colonia Las Palmas", ssNorte));
        EstacionPolicial e4 = estacionPolicialRepository.save(estacion("Delegación La Libertad", "Calle Opico", "Colonia El Rosario", laCentro));

        //policias (2 por estacion)
        Policia pol1 = policiaRepository.save(policia("POL-001", p1, e1));
        Policia pol2 = policiaRepository.save(policia("POL-002", p2, e1));
        Policia pol3 = policiaRepository.save(policia("POL-003", p3, e2));
        Policia pol4 = policiaRepository.save(policia("POL-004", p4, e2));
        Policia pol5 = policiaRepository.save(policia("POL-005", p5, e3));
        Policia pol6 = policiaRepository.save(policia("POL-006", p6, e3));
        Policia pol7 = policiaRepository.save(policia("POL-007", p1, e4));
        Policia pol8 = policiaRepository.save(policia("POL-008", p2, e4));

        //asignar los directores a las estaciones
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