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
	
//	@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
//	private List<Renta> rentas;
	
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

	public int getNumeroAutosRentados() {
		return numeroAutosRentados;
	}

	public void setNumeroAutosRentados(int numeroAutosRentados) {
		this.numeroAutosRentados = numeroAutosRentados;
	}

//	public List<Renta> getRentas() {
//		return rentas;
//	}

//	public void setRentas(List<Renta> rentas) {
//		this.rentas = rentas;
//	}
	
}
