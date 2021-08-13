package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Cliente;
import com.renta.autos.models.repositories.ICliente;
import com.renta.autos.models.service.interfaces.IClienteService;

@Service
public class ClienteService implements IClienteService{
	@Autowired
	ICliente repository;

	@Override
	@Transactional
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) repository.findAll();
	}
	
}
