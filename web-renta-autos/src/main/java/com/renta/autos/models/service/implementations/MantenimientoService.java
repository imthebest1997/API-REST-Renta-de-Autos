package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Mantenimiento;
import com.renta.autos.models.repositories.IMantenimiento;
import com.renta.autos.models.service.interfaces.IMantenimientoService;

@Service
public class MantenimientoService implements IMantenimientoService{
	@Autowired
	IMantenimiento repository;

	@Override
	@Transactional
	public void save(Mantenimiento mantenimiento) {
		repository.save(mantenimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mantenimiento> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mantenimiento> findAll() {
		return (List<Mantenimiento>) repository.findAll();
	}
	
	
}
