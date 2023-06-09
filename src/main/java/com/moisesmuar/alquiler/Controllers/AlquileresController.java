package com.moisesmuar.alquiler.Controllers;


import com.moisesmuar.alquiler.Models.AlquileresModel;
import com.moisesmuar.alquiler.Repository.AlquileresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alquileres")
public class AlquileresController {

    @Autowired
    private AlquileresRepository alquileresRepository;

    @GetMapping("")
    public List<AlquileresModel> getAlquileres() {
        return alquileresRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlquileresModel> getAlquilerById(@PathVariable(value = "id") int idAlquiler) {
        Optional<AlquileresModel> alquiler = alquileresRepository.findById(idAlquiler);
        if (alquiler.isPresent()) {
            return ResponseEntity.ok().body(alquiler.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public AlquileresModel createAlquiler(@RequestBody AlquileresModel alquiler) {
        System.out.println("Contenido del objeto alquiler recibido: " + alquiler.toString());

        return alquileresRepository.save(alquiler);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlquileresModel> updateAlquiler(@PathVariable(value = "id") int idAlquiler,
                                                          @RequestBody AlquileresModel alquilerDetails) {
        Optional<AlquileresModel> alquiler = alquileresRepository.findById(idAlquiler);
        if ( alquiler.isPresent() ) {
            AlquileresModel alquilerToUpdate = alquiler.get();
            // alquilerToUpdate.setDias(alquilerDetails.getDias());
            // alquilerToUpdate.setPrecioDia(alquilerDetails.getPrecioDia());

            alquilerToUpdate.setFhinicio( alquilerDetails.getFhinicio() );
            alquilerToUpdate.setFhfin( alquilerDetails.getFhfin() );

            alquilerToUpdate.setInmueble( alquilerDetails.getInmueble() );
            alquilerToUpdate.setCliente( alquilerDetails.getCliente() );

            alquilerToUpdate.setPortal( alquilerDetails.getPortal() );
            alquilerToUpdate.setEmpresa( alquilerDetails.getEmpresa() );

            AlquileresModel updatedAlquiler = alquileresRepository.save(alquilerToUpdate);
            return ResponseEntity.ok().body(updatedAlquiler);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlquiler(@PathVariable(value = "id") int idAlquiler) {
        Optional<AlquileresModel> alquiler = alquileresRepository.findById(idAlquiler);
        if (alquiler.isPresent()) {
            alquileresRepository.delete(alquiler.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{mes}/{ano}/{idInmueble}")
    public List<AlquileresModel> getAlquileresMesAnoInmueble( @PathVariable(value = "mes") int mes,
                                                      @PathVariable(value = "ano") int ano,
                                                      @PathVariable(value = "idInmueble") int idInmueble) {

        List<AlquileresModel> alquileres = alquileresRepository.findByMesAndAnoAndCliente(mes, ano, idInmueble);

        if (alquileres.isEmpty()) {
            return Collections.emptyList();
        } else {
            return alquileres;
        }
    }



}
