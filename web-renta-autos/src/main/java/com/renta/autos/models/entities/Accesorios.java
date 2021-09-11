package com.renta.autos.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accesorios")
public class Accesorios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_acc")
	private Integer codigoAccesorios;//Atributo que se mapea con la Primary Key

	@Column(name = "nombre_acc")
	private String nombre;
	

	@JoinColumn(name= "fk_auto_accesorios",referencedColumnName = "codigo_aut") // Se mapea con una clave foranea
	@ManyToOne(fetch = FetchType.LAZY)
	private Automovil automovil;
	
	public Accesorios(Integer codigoAccesorios) {
		super();
		this.codigoAccesorios = codigoAccesorios;
	}

	public Accesorios() {
		super();
	}

	public Integer getCodigoAccesorios() {
		return codigoAccesorios;
	}

	public void setCodigoAccesorios(Integer codigoAccesorios) {
		this.codigoAccesorios = codigoAccesorios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	
}
