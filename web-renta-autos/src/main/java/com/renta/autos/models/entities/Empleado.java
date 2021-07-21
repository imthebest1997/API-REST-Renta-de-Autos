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
@Table(name = "empleado")
public class Empleado extends Persona{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_emp")
	private Integer idEmpleado;//Atributo que se mapea con la Primary Key

	@Column(name = "numero_autos_rentados_emp")
	private int numeroAutosRentados;

	@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
	private List<Renta> rentaEmpleados;

	
	public Empleado(Integer idEmpleado) {
		super();
		this.idEmpleado = idEmpleado;
	}

	public Empleado() {
		super();
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getNumAutosRentados() {
		return numeroAutosRentados;
	}

	public void setNumAutosRentados(int numAutosRentados) {
		this.numeroAutosRentados = numAutosRentados;
	}	
}
