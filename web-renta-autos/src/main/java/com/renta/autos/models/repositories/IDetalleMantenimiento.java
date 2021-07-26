package com.renta.autos.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.DetalleMantenimiento;

public interface IDetalleMantenimiento extends CrudRepository<DetalleMantenimiento,Integer>{

}
