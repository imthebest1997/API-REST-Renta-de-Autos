package com.renta.autos.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.renta.autos.models.entities.Renta;

public interface IRentaService {
	public void save(Renta renta);//Guardar -> Create / Update
	public Optional<Renta> findById(Integer codigo); //Consultar -> Retrieve
	public void delete(Integer codigo); //Borrar -> Delete
	public List<Renta> findAll(); // Consultar en conjunto -> List
}
