package com.moisesmuar.alquiler.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes", schema = "calendario")
public class ClientesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long idCliente;

    @Basic
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Basic
    @Column(name = "telefono")
    private String telefono;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "calle")
    private String calle;

    @Basic
    @Column(name = "ciudad")
    private String ciudad;

    @Basic
    @Column(name = "pais")
    private String pais;

    @Basic
    @Column(name = "cp")
    private String cp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmpresa", nullable = false)
    private EmpresasModel empresa;

    public ClientesModel() {}

    public ClientesModel(String nombre, String telefono,
                         String email, String calle,
                         String ciudad, String pais,
                         String cp, EmpresasModel empresa) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cp = cp;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "ClientesModel{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", cp='" + cp + '\'' +
                ", empresa=" + empresa +
                '}';
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public EmpresasModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasModel empresa) {
        this.empresa = empresa;
    }
}
