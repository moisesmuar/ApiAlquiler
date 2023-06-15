package com.moisesmuar.alquiler.Controllers;

import com.moisesmuar.alquiler.Models.AlquileresModel;
import com.moisesmuar.alquiler.Models.ClientesModel;
import com.moisesmuar.alquiler.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("")
    public List<ClientesModel> getAllClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesModel> getClienteById(@PathVariable(value = "id") int clienteId) {
        Optional<ClientesModel> cliente = clientesRepository.findById(clienteId);
        if (cliente.isPresent()) {
            return ResponseEntity.ok().body(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ClientesModel createCliente( @RequestBody ClientesModel cliente) {
        return clientesRepository.save( cliente );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesModel> updateCliente(@PathVariable(value = "id") int clienteId,
                                                       @RequestBody ClientesModel clienteDetails) {
        Optional<ClientesModel> cliente = clientesRepository.findById(clienteId);
        if ( cliente.isPresent() ) {
            ClientesModel clienteToUpdate = cliente.get();
            clienteToUpdate.setNombre(clienteDetails.getNombre());
            clienteToUpdate.setTelefono(clienteDetails.getTelefono());
            clienteToUpdate.setEmail(clienteDetails.getEmail());
            clienteToUpdate.setCalle(clienteDetails.getCalle());
            clienteToUpdate.setCiudad(clienteDetails.getCiudad());
            clienteToUpdate.setPais(clienteDetails.getPais());
            clienteToUpdate.setCp(clienteDetails.getCp());
            ClientesModel updatedCliente = clientesRepository.save(clienteToUpdate);
            return ResponseEntity.ok().body(updatedCliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientesModel> deleteCliente(@PathVariable(value = "id") int clienteId) {
        Optional<ClientesModel> cliente = clientesRepository.findById(clienteId);
        if (cliente.isPresent()) {
            clientesRepository.delete(cliente.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empresa/{nombreEmpresa}")
    public List<ClientesModel> getInmueblesEmpresa(@PathVariable(value = "nombreEmpresa") String nombreEmpresa) {

        List<ClientesModel> clientes = clientesRepository.getClientesEmpresa( nombreEmpresa );

        if (clientes.isEmpty()) {
            return Collections.emptyList();
        } else {
            return clientes;
        }
    }

}
