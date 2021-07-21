package com.renta.autos.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "accesorios")
public class Accesorios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_acc")
	private Integer idAccesorios;//Atributo que se mapea con la Primary Key

	@Column(name = "nombre_acc")
	private String nombre;
	
	@JoinColumn(name= "fk_auto",referencedColumnName = "codigo_aut") // Se mapea con una clave foranea
	@ManyToOne
	private Auto auto;
	
	public Accesorios(Integer idAccesorios) {
		super();
		this.idAccesorios = idAccesorios;
	}

	public Accesorios() {
		super();
	}

	public Integer getIdAccesorios() {
		return idAccesorios;
	}

	public void setIdAccesorios(Integer idAccesorios) {
		this.idAccesorios = idAccesorios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
