package com.renta.autos.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renta.autos.models.entities.Empleado;
import com.renta.autos.models.entities.Renta;
import com.renta.autos.models.repositories.IEmpleado;
import com.renta.autos.models.repositories.IRenta;
import com.renta.autos.models.service.interfaces.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService{
	@Autowired
	IEmpleado repository;

	@Autowired
	IRenta repositoryRenta;
	
	@Override
	@Transactional
	public void save(Empleado empleado) {
		repository.save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findById(Integer codigo) {
		return repository.findById(codigo);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) {
		Optional<Empleado> empleado = repository.findById(codigo);
		if(empleado == null) return;
		for(Renta renta: empleado.get().getRentas()) {
			repositoryRenta.deleteById(renta.getCodigoRenta());
		}

		repository.deleteById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return (List<Empleado>) repository.findAll();
	}	
}
