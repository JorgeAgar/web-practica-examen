package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Asistente;
import com.example.demo.entities.Participante;
import com.example.demo.entities.Sesion;
import com.example.demo.repositories.AsistenteRepository;

@Service
public class AsistenteService {

	@Autowired
	private AsistenteRepository asistenteRepository;
	
	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private SesionService sesionService;
	
	public List<Asistente> getAllAsistentes() {
		return asistenteRepository.findAll();
	}
	
	public Asistente getAsistenteById(Integer id) {
		return asistenteRepository.getReferenceById(id);
	}
	
	public void addAsistente(int sesionId, int asistenteId) {
		Asistente newAsistente = new Asistente();
		Participante participante = participanteService.getParticipanteById(asistenteId);
		newAsistente.setParticipante(participante);
		Sesion sesion = sesionService.getSesionById(sesionId);
		newAsistente.setSesion(sesion);
		asistenteRepository.save(newAsistente);
	}
	
	public void deleteAsistente(Integer id) {
		asistenteRepository.deleteById(id);
	}
}
