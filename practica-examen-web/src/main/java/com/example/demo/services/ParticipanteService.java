package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Participante;
import com.example.demo.repositories.ParticipanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public List<Participante> getAllParticipantes() {
		return participanteRepository.findAll();
	}
	
	public Participante getParticipanteById(Integer id) {
		return participanteRepository.getReferenceById(id);
	}
	
	public void addParticipante(Participante newParticipante) {
		participanteRepository.save(newParticipante);
	}
	
	public void updateParticipante(Integer id, Participante participante) {
		if(!participanteRepository.existsById(id))
			throw new EntityNotFoundException("Participante no encontrado con id: " + id);
		participante.setId(id);
		participanteRepository.save(participante);
	}
	
	public void deleteParticipante(Integer id) {
		participanteRepository.deleteById(id);
	}
}
