package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.renta.autos.models.entities.Cliente;
import com.renta.autos.models.repositories.ICliente;
import com.renta.autos.models.service.interfaces.IClienteService;

public class ClienteService implements IClienteService{
	@Autowired
	ICliente repository;

	@Override
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Optional<Cliente> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) repository.findAll();
	}
	
}
