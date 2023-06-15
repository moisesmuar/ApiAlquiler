package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.AlquileresModel;
import com.moisesmuar.alquiler.Models.InmueblesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InmueblesRepository extends JpaRepository<InmueblesModel, Integer> {

    @Query("SELECT a FROM InmueblesModel a INNER JOIN a.empresa e WHERE e.nombre = :nombreEmpresa")
    List<InmueblesModel> getInmueblesEmpresa(@Param("nombreEmpresa") String nombreEmpresa);

}
