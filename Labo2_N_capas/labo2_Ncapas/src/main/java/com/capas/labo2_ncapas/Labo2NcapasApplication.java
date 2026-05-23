package com.capas.labo2_ncapas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Labo2NcapasApplication {

    public static void main(String[] args) {
        SpringApplication.run(Labo2NcapasApplication.class, args);
    }

}

// instancia de bd inicializada, crear bd dentro de nuestra instancia de bd. primero se crea la base de datos antes de conectarla
// controller, repository, service, model
// crear clase de user,

//Iservice, Iuserservice
//jpa es solo lectura,
//base datos de la policia (persona: nombre, dui, direccion (departamento, calle, colonia, municipio), telefono; Cargo:fecha en la que hizo el cargo, acusador, acusado, descripccion, tipo de cargo (proasil o penal); Policia: persona, no de codigo policial, estacion de policia, Estacion policial: direccion, nombre de estacion y director de esatcion)
//direccion, pesonas (2) , policia (4) y estacion policial (2) son un catalogo,
//todos los departamentos con sus zonas
//llamada a la api: cargos de una persona,: datos de la persona, lista de cargos
//en cargos: nombre, tipo de cargo, acusador (nombre y dui) y codigo de policia

//endpoint registar cargos, buscar personas que si tengan cargos,

//manejo de excepciones, hacer mapeos 