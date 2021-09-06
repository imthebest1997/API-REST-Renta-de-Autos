package com.renta.autos.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "detalle_mantenimiento")
public class DetalleMantenimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_det")
	private Integer codigoDetalleMantenimiento;//Atributo que se mapea con la Primary Key

	@Column(name = "nombre_det")
	private String nombre;
	
	@Column(name = "descripcion_det")
	private String descripcion;

	@JsonIgnore
	@JoinColumn(name= "fk_manteniento",referencedColumnName = "codigo_man") // Se mapea con una clave foranea
	@ManyToOne
	private Mantenimiento mantenimiento;

	public DetalleMantenimiento(Integer codigoDetalleMantenimiento) {
		super();
		this.codigoDetalleMantenimiento = codigoDetalleMantenimiento;
	}

	public DetalleMantenimiento() {
		super();
	}

	public Integer getCodigoDetalleMantenimiento() {
		return codigoDetalleMantenimiento;
	}

	public void setCodigoDetalleMantenimiento(Integer codigoDetalleMantenimiento) {
		this.codigoDetalleMantenimiento = codigoDetalleMantenimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
