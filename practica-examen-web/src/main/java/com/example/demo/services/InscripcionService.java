package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inscripcion;
import com.example.demo.repositories.InscripcionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	
	public List<Inscripcion> getAllInscripciones() {
		return inscripcionRepository.findAll();
	}
	
	public Inscripcion getInscripcionById(Integer id) {
		return inscripcionRepository.getReferenceById(id);
	}
	
	public void addInscripcion(Inscripcion newInscripcion) {
		inscripcionRepository.save(newInscripcion);
	}
	
	public void updateInscripcion(Integer id, Inscripcion inscripcion) {
		if(!inscripcionRepository.existsById(id))
			throw new EntityNotFoundException("Inscripción no encontrada con id: " + id);
		inscripcion.setId(id);
		inscripcionRepository.save(inscripcion);
	}
	
	public void deleteInscripcion(Integer id) {
		inscripcionRepository.deleteById(id);
	}
}
