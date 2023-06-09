package com.moisesmuar.alquiler.Controllers;


import com.moisesmuar.alquiler.Models.PortalesModel;
import com.moisesmuar.alquiler.Repository.PortalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portales")
public class PortalesController {

    @Autowired
    private PortalesRepository portalesRepository;

    @GetMapping("")
    public List<PortalesModel> getAll() {
        return portalesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortalesModel> getById(@PathVariable(value = "id") int clienteId) {
        Optional<PortalesModel> cliente = portalesRepository.findById(clienteId);
        if ( cliente.isPresent() ) {
            return ResponseEntity.ok().body( cliente.get() );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public PortalesModel create( @RequestBody PortalesModel portal) {
        return portalesRepository.save( portal );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortalesModel> update(@PathVariable(value = "id") int idPortal,
                                                       @RequestBody PortalesModel portalDetails) {
        Optional<PortalesModel> portal = portalesRepository.findById( idPortal );
        if ( portal.isPresent() ) {
            PortalesModel portalToUpdate = portal.get();

            portalToUpdate.setNombre( portalDetails.getNombre() );
            portalToUpdate.setColorHex( portalDetails.getColorHex() );

            PortalesModel updatedPortal = portalesRepository.save( portalToUpdate );
            return ResponseEntity.ok().body( updatedPortal );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PortalesModel> delete(@PathVariable(value = "id") int idPortal) {
        Optional<PortalesModel> portal = portalesRepository.findById( idPortal );
        if ( portal.isPresent() ) {
            portalesRepository.delete( portal.get() );
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
