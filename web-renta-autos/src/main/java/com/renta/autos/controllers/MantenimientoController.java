package com.renta.autos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Mantenimiento;
import com.renta.autos.models.service.interfaces.IMantenimientoService;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {

	@Autowired
	IMantenimientoService service;
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Mantenimiento mantenimiento) {
		try {
			service.save(mantenimiento);
			return ResponseEntity.status(HttpStatus.CREATED).body(mantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Mantenimiento> mantenimiento = service.findById(codigo);
			if(mantenimiento.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro de mantenimiento no encontrado");
			}
			return ResponseEntity.ok(mantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Mantenimiento mantenimiento) {
		try {
			mantenimiento.setCodigoMantenimiento(codigo);
			service.save(mantenimiento); 
			return ResponseEntity.ok(mantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Mantenimiento> mantenimiento = service.findById(codigo);
			if(mantenimiento.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro de mantenimiento no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(mantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Mantenimiento> mantenimientos = service.findAll();
			if(mantenimientos.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay registros de mantenimiento");
			}
			return ResponseEntity.ok(mantenimientos);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
