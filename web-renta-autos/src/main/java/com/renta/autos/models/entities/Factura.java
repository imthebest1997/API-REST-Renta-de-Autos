package com.renta.autos.models.entities;

import java.util.Calendar;

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
@Table(name = "factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_fac")
	private Integer idFactura;//Atributo que se mapea con la Primary Key

	@Column(name = "fecha_fac")	
	private Calendar fecha;
	
	@Column(name = "total_fac")	
	private float total;

	@JoinColumn(name= "fk_renta",referencedColumnName = "codigo_ren") // Se mapea con una clave foranea
	@ManyToOne
	private Renta renta;	
	
	public Factura(Integer idFactura) {
		super();
		this.idFactura = idFactura;
	}
	
	public Factura() {
		super();
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
