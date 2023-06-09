package com.moisesmuar.alquiler.Controllers;

import com.moisesmuar.alquiler.Models.EmpresasModel;
import com.moisesmuar.alquiler.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasRepository empresasRepository;

    @GetMapping("")
    public List<EmpresasModel> getAll() {
        return empresasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresasModel> getById(@PathVariable(value = "id") int idEmpresa) {
        Optional<EmpresasModel> empresa = empresasRepository.findById(idEmpresa);
        if ( empresa.isPresent() ) {
            return ResponseEntity.ok().body( empresa.get() );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public EmpresasModel create( @RequestBody EmpresasModel empresa) {
        return empresasRepository.save( empresa );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresasModel> update(@PathVariable(value = "id") int idEmpresa,
                                                @RequestBody EmpresasModel empresaDetails) {
        Optional<EmpresasModel> empresa = empresasRepository.findById( idEmpresa );
        if ( empresa.isPresent() ) {
            EmpresasModel empresaToUpdate = empresa.get();

            empresaToUpdate.setNombre( empresaDetails.getNombre() );

            EmpresasModel updatedEmpresa = empresasRepository.save( empresaToUpdate );
            return ResponseEntity.ok().body( updatedEmpresa );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresasModel> delete(@PathVariable(value = "id") int idEmpresa) {
        Optional<EmpresasModel> empresa = empresasRepository.findById( idEmpresa );
        if ( empresa.isPresent() ) {
            empresasRepository.delete( empresa.get() );
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
