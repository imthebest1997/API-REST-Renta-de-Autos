package com.renta.autos.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.renta.autos.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente,Integer>{

}
