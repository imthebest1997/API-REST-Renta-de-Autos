package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.renta.autos.models.entities.Accesorios;
import com.renta.autos.models.repositories.IAccesorios;
import com.renta.autos.models.service.interfaces.IAccesoriosService;

public class AccesoriosService implements IAccesoriosService{

	@Autowired
	IAccesorios repository;//,<= DAO Data Access Object
	
	@Override
	public void save(Accesorios accesorios) {
		repository.save(accesorios);
	}

	@Override
	public Optional<Accesorios> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Accesorios> findAll() {
		return (List<Accesorios>) repository.findAll();
	}

}
