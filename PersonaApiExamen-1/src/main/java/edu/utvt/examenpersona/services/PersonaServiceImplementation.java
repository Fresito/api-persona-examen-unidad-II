package edu.utvt.examenpersona.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.examenpersona.entities.Persona;
import edu.utvt.examenpersona.repositories.PersonaRepository;

@Service
public class PersonaServiceImplementation implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona save(Persona item) {
		// TODO Auto-generated method stub
		return this.personaRepository.save(item);
	}

	@Override
	public Persona update(String id, Persona persona) {
		// TODO Auto-generated method stub
		
		Optional<Persona> personaOptional = null;
		personaOptional = this.personaRepository.findById(id);
		
		if (personaOptional.isPresent()) {
			
			personaOptional.get().setId(persona.getId());
			personaOptional.get().setNombre(persona.getNombre());
			personaOptional.get().setEdad(persona.getEdad());
			personaOptional.get().setFecha_nacimiento(persona.getFecha_nacimiento());
			
			this.personaRepository.save(personaOptional.get());
			
		}
		
		return personaOptional.orElseThrow();
		
	}

	@Override
	public Optional<Persona> findById(String id) {
		// TODO Auto-generated method stub
		return this.personaRepository.findById(id);
	}

	@Override
	public ResponseEntity<Persona> deleteById(String id) {
		// TODO Auto-generated method stub
		
		Optional<Persona> personaOptional = null;
		ResponseEntity<Persona> responseEntity = null;
		
		personaOptional = this.personaRepository.findById(id);
		
		if (personaOptional.isPresent()) {
			
			this.personaRepository.delete(personaOptional.get());
			responseEntity = ResponseEntity.noContent().build();
			
		}
		else {
			responseEntity = ResponseEntity.notFound().build();
		}
		
		return responseEntity;
		
	}

}
