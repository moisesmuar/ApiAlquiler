package com.moisesmuar.alquiler.Repository;

import com.moisesmuar.alquiler.Models.InmueblesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmueblesRepository extends JpaRepository<InmueblesModel, Integer> {
}
