package com.renta.autos.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.Automovil;

public interface IAutomovil extends CrudRepository<Automovil,Integer>{

	public List<Automovil> findByDisponibilidad(boolean disponibilidad);

}
