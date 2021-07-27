package com.renta.autos.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_emp")
	private Integer codigoEmpleado;//Atributo que se mapea con la Primary Key

	@Column(name = "numero_autos_rentados_emp")
	private int numeroAutosRentados;
	
	public Empleado(Integer codigoEmpleado) {
		super();
		this.codigoEmpleado = codigoEmpleado;
	}

	public Empleado() {
		super();
	}

	public Integer getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Integer codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public int getNumAutosRentados() {
		return numeroAutosRentados;
	}

	public void setNumAutosRentados(int numAutosRentados) {
		this.numeroAutosRentados = numAutosRentados;
	}

	public int getNumeroAutosRentados() {
		return numeroAutosRentados;
	}

	public void setNumeroAutosRentados(int numeroAutosRentados) {
		this.numeroAutosRentados = numeroAutosRentados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
}
