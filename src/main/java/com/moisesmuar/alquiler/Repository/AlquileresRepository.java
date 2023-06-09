package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.AlquileresModel;
import org.springframework.data.jpa.repository.JpaRepository;  // interfaz
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// ambas interfaces interactuan con la base de datos mediante métodos predefinidos  para realizar CRUD
// en la entidad AlquileresModel. diferencia es que JpaRepository proporciona métodos adicionales para la paginación y ordenación de datos
@Repository
public interface AlquileresRepository extends JpaRepository<AlquileresModel, Integer> {

    @Query("SELECT a FROM AlquileresModel a WHERE ((MONTH(a.fhinicio) = :mes AND YEAR(a.fhinicio) = :ano) OR (MONTH(a.fhfin) = :mes AND YEAR(a.fhfin) = :ano)) AND a.inmueble.idInmueble = :idInmueble")
    List<AlquileresModel> findByMesAndAnoAndCliente(
            @Param("mes") int mes,
            @Param("ano") int ano,
            @Param("idInmueble") int idInmueble);

    /*
        @Query("SELECT a FROM AlquileresModel a WHERE (MONTH(a.fhinicio) = :mes AND YEAR(a.fhinicio) = :ano) OR (MONTH(a.fhfin) = :mes AND YEAR(a.fhfin) = :ano)")
        List<AlquileresModel> findByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);
    */

    /*
        SELECT *
        FROM alquileres
        WHERE (MONTH(fhinicio) = 5 AND YEAR(fhinicio) = 2023)
        OR (MONTH(fhfin) = 5 AND YEAR(fhfin) = 2023);
    */


}
