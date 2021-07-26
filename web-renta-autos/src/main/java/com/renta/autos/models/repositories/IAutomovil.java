package com.renta.autos.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.Automovil;

public interface IAutomovil extends CrudRepository<Automovil,Integer>{

}
