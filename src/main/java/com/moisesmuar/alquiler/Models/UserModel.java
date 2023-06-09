package com.moisesmuar.alquiler.Models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name = "users" , schema = "calendario")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private long idUsuario;
	@NotBlank
	private  String userName;
	@NotBlank
	private  String password;
	@Column(name = "rol", columnDefinition = "int default 1")  // 1 invitado  0 admin
	private int rol;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEmpresa", nullable = false)
	private EmpresasModel empresa;

	private String nif; // Solo uso para crear el user

	public UserModel() {}

	// Crear un usuario en bd
	public UserModel(
			@NotBlank String userName, @NotBlank String password,
			EmpresasModel empresa) {
		this.userName = userName;
		this.password = password;
		this.empresa = empresa;
		this.rol= 1; // rol por defecto 1 invitado
	}

	// Mapear objetos recibidos cliente
	public UserModel(
			@NotBlank String userName, @NotBlank String password,
			 String nif) {
		this.userName = userName;
		this.password = password;
		this.nif = nif;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public EmpresasModel getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresasModel empresa) {
		this.empresa = empresa;
	}
}
