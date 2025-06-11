package com.example.demo.services;

import java.util.LinkedList;
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
	
	public List<Sesion> getProgramacionSesiones(int programacionId) {
		List<Sesion> sesiones = getAllSesiones();
		List<Sesion> sesionesProg = new LinkedList<Sesion>();
		for(Sesion s : sesiones) {
			if(s.getProgramacion().getId() == programacionId)
				sesionesProg.add(s);
		}
		return sesionesProg;
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
