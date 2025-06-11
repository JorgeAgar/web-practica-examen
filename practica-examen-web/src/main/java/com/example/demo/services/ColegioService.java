package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Colegio;
import com.example.demo.repositories.ColegioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColegioService {

	@Autowired
	private ColegioRepository colegioRepository;
	
	public List<Colegio> getAllColegios() {
		return colegioRepository.findAll();
	}
	
	public Colegio getColegioById(Integer id) {
		return colegioRepository.getReferenceById(id);
	}
	
	public void addColegio(Colegio newColegio) {
		colegioRepository.save(newColegio);
	}
	
	public void updateColegio(Integer id, Colegio colegio) {
		if(!colegioRepository.existsById(id))
			throw new EntityNotFoundException("Colegio no encontrado con id: " + id);
		colegio.setId(id);
		colegioRepository.save(colegio);
	}
	
	public void deleteColegio(Integer id) {
		colegioRepository.deleteById(id);
	}
}
