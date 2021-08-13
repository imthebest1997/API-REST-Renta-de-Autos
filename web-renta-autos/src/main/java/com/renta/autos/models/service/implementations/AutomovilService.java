package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Automovil;
import com.renta.autos.models.repositories.IAutomovil;
import com.renta.autos.models.service.interfaces.IAutomovilService;

@Service
public class AutomovilService implements IAutomovilService{

	@Autowired
	IAutomovil repository;

	@Override
	@Transactional
	public void save(Automovil automovil) {
		repository.save(automovil);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Automovil> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Automovil> findAll() {
		return (List<Automovil>) repository.findAll();
	}
}
