package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Empleado;

public interface IEmpleadoService {
	public void save(Empleado empleado);//Guardar -> Create / Update
	public Optional<Empleado> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Empleado> findAll(); // Consultar en conjunto -> List
}
