package edu.utvt.examenpersona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.examenpersona.entities.Persona;
import edu.utvt.examenpersona.services.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		return ResponseEntity.created(null).body(this.personaService.save(persona));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> update(@PathVariable String id, @RequestBody Persona persona) {
		return ResponseEntity.ok(this.personaService.update(id, persona)) ;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Persona> findById(@PathVariable String id) {
		return ResponseEntity.of(this.personaService.findById(id));
	}

}
