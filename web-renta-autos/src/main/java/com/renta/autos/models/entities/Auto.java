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
@Table(name = "auto")
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codigo_aut")
	private Integer idAuto;//Atributo que se mapea con la Primary Key

	@Column(name = "disponibilidad_aut")
	private boolean disponibilidad;
	
	@Column(name = "tipo_auto_aut")
	private String auto;

	@Column(name = "numero_placa_aut")
	private String numeroPlaca;
	
	@Column(name = "marca_aut")
	private String marca;

	@Column(name = "color_aut")
	private String color;

	@OneToMany(mappedBy = "auto", fetch = FetchType.LAZY)
	private List<Accesorios> divisiones;
	
	public Auto(Integer idAuto) {
		super();
		this.idAuto = idAuto;
	}
	
	public Auto() {
		super();
	}

	public Integer getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	public boolean isDisponible() {
		return disponibilidad;
	}

	public void setDisponible(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getNumPlaca() {
		return numeroPlaca;
	}

	public void setNumPlaca(String numPlaca) {
		this.numeroPlaca = numPlaca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
