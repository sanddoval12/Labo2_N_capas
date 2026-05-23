package com.capas.labo2_ncapas.Repository;

import com.capas.labo2_ncapas.Model.Cargo;
import com.capas.labo2_ncapas.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    // Cargos de una persona específica
    List<Cargo> findByAcusado(Persona acusado);

    // Personas que sí tienen cargos
    @Query("SELECT DISTINCT c.acusado FROM Cargo c")
    List<Persona> findPersonasConCargos();

    // 3 más acusados
    @Query("SELECT c.acusado, COUNT(c) as total FROM Cargo c GROUP BY c.acusado ORDER BY total DESC LIMIT 3")
    List<Object[]> findTop3MasAcusados();
}
