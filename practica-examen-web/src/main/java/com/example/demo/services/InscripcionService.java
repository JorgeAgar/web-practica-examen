package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.InscripcionDto;
import com.example.demo.entities.Inscripcion;
import com.example.demo.entities.Participante;
import com.example.demo.entities.Programacion;
import com.example.demo.repositories.InscripcionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	
	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private ProgramacionService programacionService;
	
	public List<Inscripcion> getAllInscripciones() {
		return inscripcionRepository.findAll();
	}
	
	public Inscripcion getInscripcionById(Integer id) {
		return inscripcionRepository.getReferenceById(id);
	}
	
	public void addInscripcion(InscripcionDto inscripcionDto) {
		Inscripcion newInscripcion = new Inscripcion();
		newInscripcion.setFecha(inscripcionDto.getFecha());
		Participante participante = participanteService.getParticipanteById(inscripcionDto.getParticipanteId());
		newInscripcion.setParticipante(participante);
		Programacion programacion = programacionService.getProgramacionById(inscripcionDto.getProgramaciónId());
		newInscripcion.setProgramacion(programacion);
		inscripcionRepository.save(newInscripcion);
	}
	
	public void deleteInscripcion(Integer id) {
		inscripcionRepository.deleteById(id);
	}
}
