package com.capas.labo2_ncapas.Repository;

import com.capas.labo2_ncapas.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}