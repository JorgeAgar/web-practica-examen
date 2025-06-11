package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Sesion;
import com.example.demo.repositories.SesionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SesionService {

	@Autowired
	private SesionRepository sesionRepository;
	
	public List<Sesion> getAllSesiones() {
		return sesionRepository.findAll();
	}
	
	public Sesion getSesionById(Integer id) {
		return sesionRepository.getReferenceById(id);
	}
	
	public void addSesion(Sesion newSesion) {
		sesionRepository.save(newSesion);
	}
	
	public void updateSesion(Integer id, Sesion sesion) {
		if(!sesionRepository.existsById(id))
			throw new EntityNotFoundException("Sesión no encontrada con id: " + id);
		sesion.setId(id);
		sesionRepository.save(sesion);
	}
	
	public void deleteSesion(Integer id) {
		sesionRepository.deleteById(id);
	}
}
