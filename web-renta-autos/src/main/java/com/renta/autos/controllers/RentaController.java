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

import com.renta.autos.models.entities.Renta;
import com.renta.autos.models.service.interfaces.IRentaService;

@RestController
@RequestMapping("/renta")
public class RentaController {

	@Autowired
	IRentaService service;
	
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Renta renta) {
		try {
			service.save(renta);
			return ResponseEntity.status(HttpStatus.CREATED).body(renta);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Renta> renta = service.findById(codigo);
			if(renta.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro de renta de auto no encontrado");
			}
			return ResponseEntity.ok(renta);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Renta renta) {
		try {
			renta.setCodigoRenta(codigo);
			service.save(renta); 
			return ResponseEntity.ok(renta);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Renta> renta = service.findById(codigo);
			if(renta.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro de renta de auto no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(renta);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Renta> renta = service.findAll();
			if(renta.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay registros de renta de autos");
			}
			return ResponseEntity.ok(renta);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
