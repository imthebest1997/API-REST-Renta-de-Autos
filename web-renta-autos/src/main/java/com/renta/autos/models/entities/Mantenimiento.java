package com.renta.autos.models.entities;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_man")
	private Integer idMantenimiento;//Atributo que se mapea con la Primary Key

	@Column(name = "fecha_inicio_man")
	private Calendar fechaInicio;

	@Column(name = "fecha_fin_man")
	private Calendar fechaFin;

	public Mantenimiento(Integer idMantenimiento) {
		super();
		this.idMantenimiento = idMantenimiento;
	}	

	public Mantenimiento() {
		super();
	}

	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}	

}
