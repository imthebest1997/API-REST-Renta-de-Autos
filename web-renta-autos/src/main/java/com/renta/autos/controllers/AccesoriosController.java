package com.renta.autos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Accesorios;
import com.renta.autos.models.service.interfaces.IAccesoriosService;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/accesorios")
public class AccesoriosController {
	@Autowired
	IAccesoriosService service;
		    
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Accesorios accesorios) {
		try {
			service.save(accesorios);
			return ResponseEntity.status(HttpStatus.CREATED).body(accesorios);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Accesorios> accesorios = service.findById(codigo);
			if(accesorios.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Accesorio no encontrado");
			}
			return ResponseEntity.ok(accesorios);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Accesorios accesorios) {
		try {
			accesorios.setCodigoAccesorios(codigo);
			service.save(accesorios); 
			return ResponseEntity.ok(accesorios);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Accesorios> accesorios = service.findById(codigo);
			if(accesorios.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Accesorio no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(accesorios);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Accesorios> accesorios = service.findAll();
			if(accesorios.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay accesorios registrados");
			}
			return ResponseEntity.ok(accesorios);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
