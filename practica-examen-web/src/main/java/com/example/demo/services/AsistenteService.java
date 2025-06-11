package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Asistente;
import com.example.demo.repositories.AsistenteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AsistenteService {

	@Autowired
	private AsistenteRepository asistenteRepository;
	
	public List<Asistente> getAllAsistentes() {
		return asistenteRepository.findAll();
	}
	
	public Asistente getAsistenteById(Integer id) {
		return asistenteRepository.getReferenceById(id);
	}
	
	public void addAsistente(Asistente newAsistente) {
		asistenteRepository.save(newAsistente);
	}
	
	public void updateAsistente(Integer id, Asistente asistente) {
		if(!asistenteRepository.existsById(id))
			throw new EntityNotFoundException("Asistente no encontrado con id: " + id);
		asistente.setId(id);
		asistenteRepository.save(asistente);
	}
	
	public void deleteAsistente(Integer id) {
		asistenteRepository.deleteById(id);
	}
}
