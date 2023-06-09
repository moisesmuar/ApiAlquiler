package com.moisesmuar.alquiler.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas", schema = "calendario")
public class EmpresasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Long idEmpresa;

    @Basic
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nif", unique = true, nullable = false, length = 9)
    private String nif;
    public EmpresasModel() {}
    public EmpresasModel(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

}
