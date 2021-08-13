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

import com.renta.autos.models.entities.Empleado;
import com.renta.autos.models.service.interfaces.IEmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	IEmpleadoService service;

	//CRUD - L
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Empleado empleado) {
		try {
			service.save(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{codigo}")
	public ResponseEntity<?> retrieve(@PathVariable Integer codigo) {
		try {
			Optional<Empleado> empleado = service.findById(codigo);
			if(empleado.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
			}
			return ResponseEntity.ok(empleado);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Empleado empleado) {
		try {
			empleado.setCodigoEmpleado(codigo);
			service.save(empleado); 
			return ResponseEntity.ok(empleado);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			Optional<Empleado> empleado = service.findById(codigo);
			if(empleado.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
			}
			service.delete(codigo);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(empleado);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Empleado> empleados = service.findAll();
			if(empleados.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay empleados registrados");
			}
			return ResponseEntity.ok(empleados);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}

}
