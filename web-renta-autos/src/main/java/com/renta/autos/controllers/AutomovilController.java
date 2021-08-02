package com.renta.autos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Automovil;
import com.renta.autos.models.service.implementations.AutomovilService;

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

@RestController
@RequestMapping("/automovil")
public class AutomovilController{
    //Inyectar el servicio
	@Autowired
	AutomovilService service;
		    
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Automovil auto) {
		try {
			service.save(auto);
			return ResponseEntity.status(HttpStatus.CREATED).body(auto);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Automovil> auto = service.findById(codigo);
			if(auto.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Auto no encontrado");
			}
			return ResponseEntity.ok(auto);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Automovil auto) {
		try {
			auto.setCodigoAuto(codigo);
			service.save(auto); 
			return ResponseEntity.ok(auto);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Automovil> auto = service.findById(codigo);
			if(auto.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Auto no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(auto);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Automovil> autos = service.findAll();
			if(autos.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay autos registrados");
			}
			return ResponseEntity.ok(autos);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

	
}