package com.moisesmuar.alquiler.Models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "alquileres", schema = "calendario")
public class AlquileresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlquiler")
    private int idAlquiler;

  /*  @Column(name = "fhinicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhinicio;

    @Column(name = "fhfin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fhfin;
*/
    @Column(name = "fhinicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fhinicio;

    @Column(name = "fhfin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fhfin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idInmueble", nullable = false)
    private InmueblesModel inmueble;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente", nullable = false)
    private ClientesModel cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPortal", nullable = false)
    private PortalesModel portal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmpresa", nullable = false)
    private EmpresasModel empresa;

    public AlquileresModel() {
    }

    public AlquileresModel(/*int dias, BigDecimal precioDia,*/
            LocalDate fhinicio, LocalDate fhfin,
            InmueblesModel inmueble, ClientesModel cliente,
            PortalesModel portal, EmpresasModel empresa ) {

        this.fhinicio = fhinicio;
        this.fhfin = fhfin;
        this.inmueble = inmueble;
        this.cliente = cliente;
        this.portal = portal;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "AlquileresModel{" +
                "idAlquiler=" + idAlquiler +
                ", fhinicio=" + fhinicio +
                ", fhfin=" + fhfin +
                ", inmueble=" + inmueble +
                ", cliente=" + cliente +
                ", portal=" + portal +
                ", empresa=" + empresa +
                '}';
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public LocalDate getFhinicio() {
        return fhinicio;
    }

    public void setFhinicio(LocalDate fhinicio) {
        this.fhinicio = fhinicio;
    }

    public LocalDate getFhfin() {
        return fhfin;
    }

    public void setFhfin(LocalDate fhfin) {
        this.fhfin = fhfin;
    }

    public InmueblesModel getInmueble() {
        return inmueble;
    }

    public void setInmueble(InmueblesModel inmueble) {
        this.inmueble = inmueble;
    }

    public ClientesModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModel cliente) {
        this.cliente = cliente;
    }

    public PortalesModel getPortal() {
        return portal;
    }

    public void setPortal(PortalesModel portal) {
        this.portal = portal;
    }

    public EmpresasModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasModel empresa) {
        this.empresa = empresa;
    }
}
