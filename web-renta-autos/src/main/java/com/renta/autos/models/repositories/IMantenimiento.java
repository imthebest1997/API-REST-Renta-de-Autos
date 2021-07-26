package com.renta.autos.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.Mantenimiento;

public interface IMantenimiento extends CrudRepository<Mantenimiento,Integer>{

}
