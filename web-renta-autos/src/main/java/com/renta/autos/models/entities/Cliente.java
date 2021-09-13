package com.renta.autos.models.entities;

import java.io.Serializable;
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
public class Cliente extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_cli")
	private Integer codigoCliente;//Atributo que se mapea con la Primary Key
	
	@Column(name = "numero_licencia_cli")
	private String numeroLicencia;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Renta> renta;
	
	
	public Cliente(Integer codigoCliente) {
		super();
		this.codigoCliente = codigoCliente;
	}

	public Cliente() {
		super();
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	public List<Renta> getRenta() {
		return renta;
	}

	public void setRenta(List<Renta> renta) {
		this.renta = renta;
	}

	
}
