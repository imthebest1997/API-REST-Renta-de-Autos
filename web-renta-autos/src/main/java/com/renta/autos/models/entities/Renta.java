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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Calendar inicio;
	
	@Column(name = "fecha_fin_ren")
	private Calendar fin;
	
	@Column(name = "total_ren")
	private float total;


	@JoinColumn(name = "codigo_aut", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)        
	private Automovil automovil;

	
	@JoinColumn(name= "fk_empleado",referencedColumnName = "codigo_emp") // Se mapea con una clave foranea
	@ManyToOne
	private Empleado empleado;
	
	@JoinColumn(name = "codigo_cli", nullable = false)
	@OneToOne(fetch = FetchType.LAZY)        
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

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFin() {
		return fin;
	}

	public void setFin(Calendar fin) {
		this.fin = fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
