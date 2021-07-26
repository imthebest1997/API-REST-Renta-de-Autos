package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.renta.autos.models.entities.DetalleMantenimiento;
import com.renta.autos.models.repositories.IDetalleMantenimiento;
import com.renta.autos.models.service.interfaces.IDetalleMantenimientoService;

public class DetalleMantenimientoService implements IDetalleMantenimientoService{

	@Autowired
	IDetalleMantenimiento repository;

	@Override
	public void save(DetalleMantenimiento detalleMantenimiento) {
		repository.save(detalleMantenimiento);
	}

	@Override
	public Optional<DetalleMantenimiento> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	public List<DetalleMantenimiento> findAll() {
		return (List<DetalleMantenimiento>) repository.findAll();
	}
	

}
