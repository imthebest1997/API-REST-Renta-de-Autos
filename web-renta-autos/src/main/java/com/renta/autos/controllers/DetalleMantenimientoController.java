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

import com.renta.autos.models.entities.DetalleMantenimiento;
import com.renta.autos.models.service.implementations.DetalleMantenimientoService;

@RestController
@RequestMapping("/detalle_mantenimiento")
public class DetalleMantenimientoController {

	@Autowired
	DetalleMantenimientoService service;
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody DetalleMantenimiento detalleMantenimiento) {
		try {
			service.save(detalleMantenimiento);
			return ResponseEntity.status(HttpStatus.CREATED).body(detalleMantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<DetalleMantenimiento> detalleMantenimiento = service.findById(codigo);
			if(detalleMantenimiento.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle de mantenimiento no encontrado");
			}
			return ResponseEntity.ok(detalleMantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody DetalleMantenimiento detalleMantenimiento) {
		try {
			detalleMantenimiento.setCodigoDetalleMantenimiento(codigo);
			service.save(detalleMantenimiento); 
			return ResponseEntity.ok(detalleMantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<DetalleMantenimiento> detalleMantenimiento = service.findById(codigo);
			if(detalleMantenimiento.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle de mantenimiento no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(detalleMantenimiento);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<DetalleMantenimiento> detalleMantenimientos = service.findAll();
			if(detalleMantenimientos.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay detalles de mantenimientos registrados");
			}
			return ResponseEntity.ok(detalleMantenimientos);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
