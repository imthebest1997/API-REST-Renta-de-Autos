package com.renta.autos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Renta;
import com.renta.autos.models.service.implementations.RentaService;

@RestController
@RequestMapping("/renta")

public class RentaController {
	//Inyectar el servicio
	@Autowired
	RentaService service;

	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Renta r){
		try {
			service.save(r);
			return ResponseEntity.status(HttpStatus.CREATED).body(r);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());			
		}
	}
	
		
	//Retrieve
	@GetMapping("/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Renta> r = service.findById(codigo);
			if(r.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Variedad no encontrada");
			}
			return ResponseEntity.ok(r);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
