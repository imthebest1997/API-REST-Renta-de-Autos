package com.renta.autos.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.Empleado;

public interface IEmpleado extends CrudRepository<Empleado,Integer>{

}
