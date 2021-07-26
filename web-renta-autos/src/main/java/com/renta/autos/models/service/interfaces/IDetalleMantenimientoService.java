package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.DetalleMantenimiento;

public interface IDetalleMantenimientoService {
	public void save(DetalleMantenimiento detalleMantenimiento);//Guardar -> Create / Update
	public Optional<DetalleMantenimiento> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<DetalleMantenimiento> findAll(); // Consultar en conjunto -> List
}
