package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.DetalleMantenimiento;
import com.renta.autos.models.repositories.IDetalleMantenimiento;
import com.renta.autos.models.service.interfaces.IDetalleMantenimientoService;

@Service
public class DetalleMantenimientoService implements IDetalleMantenimientoService{

	@Autowired
	IDetalleMantenimiento repository;

	@Override
	@Transactional
	public void save(DetalleMantenimiento detalleMantenimiento) {
		repository.save(detalleMantenimiento);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleMantenimiento> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleMantenimiento> findAll() {
		return (List<DetalleMantenimiento>) repository.findAll();
	}
	
}
