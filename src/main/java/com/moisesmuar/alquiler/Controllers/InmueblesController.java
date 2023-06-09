package com.moisesmuar.alquiler.Controllers;


import com.moisesmuar.alquiler.Models.InmueblesModel;
import com.moisesmuar.alquiler.Repository.InmueblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inmuebles")
public class InmueblesController {

    @Autowired
    private InmueblesRepository inmueblesRepository;

    @GetMapping("")
    public List<InmueblesModel> getAllInmuebles() {
        return inmueblesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InmueblesModel> getInmuebleById(@PathVariable(value = "id") int idInmueble) {
        Optional<InmueblesModel> inmueble = inmueblesRepository.findById(idInmueble);
        if (inmueble.isPresent()) {
            return ResponseEntity.ok().body(inmueble.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public InmueblesModel createInmueble( @RequestBody InmueblesModel inmueble) {
        return inmueblesRepository.save(inmueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InmueblesModel> updateInmueble(@PathVariable(value = "id") int idInmueble,
                                                          @RequestBody InmueblesModel inmuebleDetails) {
        Optional<InmueblesModel> optionalInmueble = inmueblesRepository.findById(idInmueble);
        if (optionalInmueble.isPresent()) {
            InmueblesModel inmueble = optionalInmueble.get();
            inmueble.setNombre(inmuebleDetails.getNombre());
            inmueble.setCalle(inmuebleDetails.getCalle());
            inmueble.setCiudad(inmuebleDetails.getCiudad());
            inmueble.setNumPersonas(inmuebleDetails.getNumPersonas());
            inmueble.setNumHabitaciones(inmuebleDetails.getNumHabitaciones());
            inmueble.setNumBanos(inmuebleDetails.getNumBanos());
            inmueble.setNumAseos(inmuebleDetails.getNumAseos());

            InmueblesModel updatedInmueble = inmueblesRepository.save(inmueble);
            return ResponseEntity.ok(updatedInmueble);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable(value = "id") int idInmueble) {
        Optional<InmueblesModel> optionalInmueble = inmueblesRepository.findById(idInmueble);
        if (optionalInmueble.isPresent()) {
            inmueblesRepository.delete(optionalInmueble.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
