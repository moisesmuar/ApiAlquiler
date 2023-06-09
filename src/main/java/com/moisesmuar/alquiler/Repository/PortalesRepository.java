package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.PortalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalesRepository extends JpaRepository<PortalesModel, Integer> {
}
