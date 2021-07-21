package com.renta.autos.models.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_cli")
	private Integer idCliente;//Atributo que se mapea con la Primary Key
	
	@Column(name = "numero_licencia_cli")
	private String numeroLicencia;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Renta> rentasClientes;

	
	public Cliente(Integer idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public Cliente() {
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNumLicencia() {
		return numeroLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numeroLicencia = numLicencia;
	}

	
}
