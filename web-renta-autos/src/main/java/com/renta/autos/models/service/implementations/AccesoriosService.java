package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Accesorios;
import com.renta.autos.models.repositories.IAccesorios;
import com.renta.autos.models.service.interfaces.IAccesoriosService;

@Service
public class AccesoriosService implements IAccesoriosService{

	@Autowired
	IAccesorios repository;//,<= DAO Data Access Object
	
	@Override
	@Transactional
	public void save(Accesorios accesorios) {
		repository.save(accesorios);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Accesorios> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Accesorios> findAll() {
		return (List<Accesorios>) repository.findAll();
	}

}
