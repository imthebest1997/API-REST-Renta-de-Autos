package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Accesorios;

public interface IAccesoriosService {
	public void save(Accesorios accesorios);//Guardar -> Create / Update
	public Optional<Accesorios> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Accesorios> findAll(); // Consultar en conjunto -> List
}
