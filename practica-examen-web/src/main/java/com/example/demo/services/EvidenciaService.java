package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Evidencia;
import com.example.demo.repositories.EvidenciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EvidenciaService {

	@Autowired
	private EvidenciaRepository evidenciaRepository;
	
	public List<Evidencia> getAllEvidencias() {
		return evidenciaRepository.findAll();
	}
	
	public Evidencia getEvidenciaById(Integer id) {
		return evidenciaRepository.getReferenceById(id);
	}
	
	public void addEvidencia(Evidencia newEvidencia) {
		evidenciaRepository.save(newEvidencia);
	}
	
	public void updateEvidencia(Integer id, Evidencia evidencia) {
		if(!evidenciaRepository.existsById(id))
			throw new EntityNotFoundException("Evidencia no encontrada con id: " + id);
		evidencia.setId(id);
		evidenciaRepository.save(evidencia);
	}
	
	public void deleteEvidencia(Integer id) {
		evidenciaRepository.deleteById(id);
	}
}
