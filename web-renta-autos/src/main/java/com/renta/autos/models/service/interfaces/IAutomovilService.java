package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Automovil;

public interface IAutomovilService {
	public void save(Automovil automovil);//Guardar -> Create / Update
	public Optional<Automovil> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Automovil> findAll(); // Consultar en conjunto -> List
	public List<Automovil> findByDisponibilidad(boolean disponibilidad);
}
