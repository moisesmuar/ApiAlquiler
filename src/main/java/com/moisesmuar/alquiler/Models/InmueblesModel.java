package com.moisesmuar.alquiler.Models;
import jakarta.persistence.*;


@Entity
@Table(name = "inmuebles", schema = "calendario")
public class InmueblesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInmueble")
    private Long idInmueble;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "calle")
    private String calle;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "numPersonas")
    private int numPersonas;

    @Column(name = "numHabitaciones")
    private int numHabitaciones;

    @Column(name = "numBanos")
    private int numBanos;

    @Column(name = "numAseos")
    private int numAseos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEmpresa", nullable = false)
    private EmpresasModel empresa;

    public InmueblesModel() {
    }

    public InmueblesModel(String nombre, String calle,
                          String ciudad, int numPersonas,
                          int numHabitaciones, int numBanos,
                          int numAseos, EmpresasModel empresa) {
        this.nombre = nombre;
        this.calle = calle;
        this.ciudad = ciudad;
        this.numPersonas = numPersonas;
        this.numHabitaciones = numHabitaciones;
        this.numBanos = numBanos;
        this.numAseos = numAseos;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "InmueblesModel{" +
                "idInmueble=" + idInmueble +
                ", nombre='" + nombre + '\'' +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numPersonas=" + numPersonas +
                ", numHabitaciones=" + numHabitaciones +
                ", numBanos=" + numBanos +
                ", numAseos=" + numAseos +
                ", empresa=" + empresa +
                '}';
    }

    public Long getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Long idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public int getNumAseos() {
        return numAseos;
    }

    public void setNumAseos(int numAseos) {
        this.numAseos = numAseos;
    }

    public EmpresasModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasModel empresa) {
        this.empresa = empresa;
    }
}
