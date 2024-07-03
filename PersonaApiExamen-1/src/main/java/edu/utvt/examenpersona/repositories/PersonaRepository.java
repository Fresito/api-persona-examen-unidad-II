package edu.utvt.examenpersona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.examenpersona.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

}
