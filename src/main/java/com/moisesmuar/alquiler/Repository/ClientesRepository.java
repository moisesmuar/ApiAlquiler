package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Integer> {
}
