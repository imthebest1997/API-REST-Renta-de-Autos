package com.renta.autos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Mantenimiento;
import com.renta.autos.models.service.implementations.MantenimientoService;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	@Autowired
	MantenimientoService service;

	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Mantenimiento r){
		try {
			service.save(r);
			return ResponseEntity.status(HttpStatus.CREATED).body(r);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());			
		}
	}
	

}
