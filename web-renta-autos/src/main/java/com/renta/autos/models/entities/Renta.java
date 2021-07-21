package com.renta.autos.models.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "renta")
public class Renta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_ren")
	private Integer idRenta;//Atributo que se mapea con la Primary Key

	@Column(name = "fecha_inicio_ren")
	private Calendar inicio;
	
	@Column(name = "fecha_fin_ren")
	private Calendar fin;
	
	@Column(name = "metodo_pago_ren")
	private String metodoPago;

	@JoinColumn(name= "fk_auto_renta",referencedColumnName = "codigo_aut") // Se mapea con una clave foranea
	@ManyToOne
	private Auto auto;

	@JoinColumn(name= "fk_cliente",referencedColumnName = "codigo_cli") // Se mapea con una clave foranea
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name= "fk_empleado",referencedColumnName = "codigo_emp") // Se mapea con una clave foranea
	@ManyToOne
	private Empleado empleado;
	
	@OneToMany(mappedBy = "renta", fetch = FetchType.LAZY)
	private List<Factura> facturaRenta;
	
	public Renta(Integer idRenta) {
		super();
		this.idRenta = idRenta;
	}

	public Renta() {
		super();
	}

	public Integer getIdRenta() {
		return idRenta;
	}

	public void setIdRenta(Integer idRenta) {
		this.idRenta = idRenta;
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

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	
}
