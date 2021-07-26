package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Mantenimiento;

public interface IMantenimientoService {
	public void save(Mantenimiento mantenimiento);//Guardar -> Create / Update
	public Optional<Mantenimiento> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Mantenimiento> findAll(); // Consultar en conjunto -> List
}
