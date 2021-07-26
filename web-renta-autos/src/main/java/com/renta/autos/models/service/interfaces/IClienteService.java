package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Cliente;

public interface IClienteService {
	public void save(Cliente cliente);//Guardar -> Create / Update
	public Optional<Cliente> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Cliente> findAll(); // Consultar en conjunto -> List
}
