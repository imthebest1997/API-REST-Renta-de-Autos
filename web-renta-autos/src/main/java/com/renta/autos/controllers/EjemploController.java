package com.renta.autos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.renta.autos.models.entities.Accesorios;

@RestController
@RequestMapping("/")
public class EjemploController {

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public ResponseEntity<?> inicio1(){
		return ResponseEntity.ok("Inicio correcto");
	}
	
	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public ResponseEntity<?> inicio2(){
		return ResponseEntity.ok("Programacion Web");
	}

	@GetMapping(value = "/param")
	public ResponseEntity<?> param(@RequestParam String nombre){
		return ResponseEntity.ok("Hola " + nombre);
	}
	
	@GetMapping(value = "/path/{name}")
	public ResponseEntity<?> path(@PathVariable String name){
		return ResponseEntity.ok("Hola " + name);
	}

	
	@GetMapping("/carrera")
	public ResponseEntity<?> inicio3(){
		return ResponseEntity.ok("Ingenieria de Software 2021");
	}

	
	@PostMapping(value = "/body")
	public ResponseEntity<?> body(@RequestBody String name){
		return ResponseEntity.ok("Hola " + name);
	}
	

	@PostMapping("/carrera")
	public ResponseEntity<?> inicio4(){
		return ResponseEntity.ok("ISOW 2021");
	}

	@GetMapping("/accesorios")
	public @ResponseBody ResponseEntity<?> inicio5(){
		Accesorios ac = new Accesorios();
		ac.setNombre("Air bag");
		ac.setCodigoAccesorios(1);
	//	return ResponseEntity.ok(ac);
		return ResponseEntity.status(HttpStatus.CREATED).body(ac);
	}

	@GetMapping("/accesorios_1")
	public @ResponseBody Accesorios inicio6(){
		Accesorios ac = new Accesorios();
		ac.setNombre("Air bag");
		ac.setCodigoAccesorios(1);
		return ac;
	}

	
}
