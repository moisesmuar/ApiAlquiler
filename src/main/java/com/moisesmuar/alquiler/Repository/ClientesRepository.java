package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.AlquileresModel;
import com.moisesmuar.alquiler.Models.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Integer> {

    @Query("SELECT a FROM ClientesModel a INNER JOIN a.empresa e WHERE e.nombre = :nombreEmpresa")
    List<ClientesModel> getClientesEmpresa(@Param("nombreEmpresa") String nombreEmpresa);

}
