package com.renta.autos.models.entities;

import java.io.Serializable;
import java.util.Calendar;
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "renta")
public class Renta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_ren")
	private Integer codigoRenta;//Atributo que se mapea con la Primary Key

	@Column(name = "fecha_inicio_ren")
	private Calendar fechaInicio;
	
	@Column(name = "fecha_fin_ren")
	private Calendar fechaFin;
	
	@Column(name = "total_ren")
	private float total;

	@JoinColumn(name= "fk_automovil_renta",referencedColumnName = "codigo_aut")
	@ManyToOne(fetch = FetchType.LAZY)
	private Automovil automovil;

	@JoinColumn(name= "fk_empleado_renta",referencedColumnName = "codigo_emp") // Se mapea con una clave foranea
	@ManyToOne(fetch = FetchType.LAZY)	
	private Empleado empleado;
	
	@JoinColumn(name= "fk_cliente_renta",referencedColumnName = "codigo_cli") // Se mapea con una clave foranea
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Renta(Integer codigoRenta) {
		super();
		this.codigoRenta = codigoRenta;
	}

	public Renta() {
		super();
	}

	public Integer getCodigoRenta() {
		return codigoRenta;
	}

	public void setCodigoRenta(Integer codigoRenta) {
		this.codigoRenta = codigoRenta;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	@JsonIgnore
	public Automovil getAutomovil() {
		return automovil;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}
	
	@JsonIgnore
	public Empleado getEmpleado() {
		return empleado;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	@JsonIgnore
	public Cliente getCliente() {
		return cliente;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
