package com.moisesmuar.alquiler.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "portales", schema = "calendario")
public class PortalesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPortal")
    private Long idPortal;

    @Basic
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Basic
    @Column(name = "colorHex", nullable = false)
    private String colorHex;

    public PortalesModel() {}
    public PortalesModel ( String nombre, String colorHex) {
        this.nombre = nombre;
        this.colorHex = colorHex;
    }

    public Long getIdPortal() {
        return idPortal;
    }

    public void setIdPortal(Long idPortal) {
        this.idPortal = idPortal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

}
