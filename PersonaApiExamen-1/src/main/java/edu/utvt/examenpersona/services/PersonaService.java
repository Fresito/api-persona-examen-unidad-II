package edu.utvt.examenpersona.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import edu.utvt.examenpersona.entities.Persona;


public interface PersonaService {
	
	public Persona save(Persona item);
	
	public Persona update(String id, Persona persona);
	
	public Optional<Persona> findById(String id);
	
	public ResponseEntity<Persona> deleteById(String id);

}
