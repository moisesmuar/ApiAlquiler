package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Integer> {
}
