package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Accesorios;
import com.renta.autos.models.entities.Automovil;
import com.renta.autos.models.entities.Mantenimiento;
import com.renta.autos.models.repositories.IAccesorios;
import com.renta.autos.models.repositories.IAutomovil;
import com.renta.autos.models.repositories.IMantenimiento;
import com.renta.autos.models.service.interfaces.IAutomovilService;

@Service
public class AutomovilService implements IAutomovilService{

	@Autowired
	IAutomovil repository;
	
	@Autowired
	IAccesorios repositoryAccesorios;
	
	@Autowired
	IMantenimiento repositoryMantenimiento;
	
	@Override
	@Transactional
	public void save(Automovil automovil) {
		repository.save(automovil);
		
		for(Accesorios a : automovil.getListaAccesorios()) {
			a.setAutomovil(automovil);
			repositoryAccesorios.save(a);			
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Automovil> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		Optional<Automovil> automovil = repository.findById(codigo);
		if(automovil == null) return;
		for(Accesorios accesorios : automovil.get().getListaAccesorios()) {
			repositoryAccesorios.deleteById(accesorios.getCodigoAccesorios());
		}
		
		for(Mantenimiento mantenimiento: automovil.get().getMantenimiento()) {
			repositoryMantenimiento.deleteById(mantenimiento.getCodigoMantenimiento());
		}
		
		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Automovil> findAll() {
		return (List<Automovil>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Automovil> findByDisponibilidad(boolean disponibilidad) {
		return (List<Automovil>) repository.findByDisponibilidad(disponibilidad);
	}
}
