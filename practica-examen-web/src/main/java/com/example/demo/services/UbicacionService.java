package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ubicacion;
import com.example.demo.repositories.UbicacionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UbicacionService {

	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public List<Ubicacion> getAllUbicaciones() {
		return ubicacionRepository.findAll();
	}
	
	public void addUbicacion(Ubicacion newUbicacion) {
		ubicacionRepository.save(newUbicacion);
	}
	
	public void updateUbicacion(Integer id, Ubicacion ubicacion) {
		if(!ubicacionRepository.existsById(id))
			throw new EntityNotFoundException("Ubicación no encontrada con id: " + id);
		ubicacion.setId(id);
		ubicacionRepository.save(ubicacion);
	}
	
	public void deleteUbicacion(Integer id) {
		ubicacionRepository.deleteById(id);
	}
}
