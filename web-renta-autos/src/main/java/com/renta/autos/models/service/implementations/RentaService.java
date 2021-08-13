package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Renta;
import com.renta.autos.models.repositories.IRenta;
import com.renta.autos.models.service.interfaces.IRentaService;

@Service
public class RentaService implements IRentaService{
	@Autowired
	IRenta repository;

	@Override
	@Transactional
	public void save(Renta renta) {
		repository.save(renta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Renta> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Renta> findAll() {
		return (List<Renta>) repository.findAll();
	}
}
