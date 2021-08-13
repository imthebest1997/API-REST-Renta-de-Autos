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

import com.renta.autos.models.entities.Cliente;
import com.renta.autos.models.service.interfaces.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    //Inyectar el servicio
	@Autowired
	IClienteService service;
		    
	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		try {
			service.save(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Cliente> cliente = service.findById(codigo);
			if(cliente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
			}
			return ResponseEntity.ok(cliente);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Cliente cliente) {
		try {
			cliente.setCodigoCliente(codigo);
			service.save(cliente); 
			return ResponseEntity.ok(cliente);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Cliente> cliente = service.findById(codigo);
			if(cliente.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(cliente);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Cliente> clientes = service.findAll();
			if(clientes.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay clientes registrados");
			}
			return ResponseEntity.ok(clientes);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
}
