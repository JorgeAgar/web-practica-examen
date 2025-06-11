package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ParticipanteDto;
import com.example.demo.entities.Colegio;
import com.example.demo.entities.Participante;
import com.example.demo.entities.TipoDocumento;
import com.example.demo.repositories.ParticipanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Autowired
	private ColegioService colegioService;
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	public List<Participante> getAllParticipantes() {
		return participanteRepository.findAll();
	}
	
	public Participante getParticipanteById(Integer id) {
		return participanteRepository.getReferenceById(id);
	}
	
	public void addParticipante(ParticipanteDto participanteDto) {
		Participante newParticipante = new Participante();
		newParticipante.setNombre(participanteDto.getNombre());
		Colegio colegio = colegioService.getColegioById(participanteDto.getColegioId());
		newParticipante.setColegio(colegio);
		TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(participanteDto.getTipoDocumentoId());
		newParticipante.setTipoDocumento(tipoDocumento);
		participanteRepository.save(newParticipante);
	}
	
	public void updateParticipante(Integer id, ParticipanteDto participanteDto) {
		if(!participanteRepository.existsById(id))
			throw new EntityNotFoundException("Participante no encontrado con id: " + id);
		Participante participante = participanteRepository.getReferenceById(id);
		participante.setNombre(participanteDto.getNombre());
		Colegio colegio = colegioService.getColegioById(participanteDto.getColegioId());
		participante.setColegio(colegio);
		TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(participanteDto.getTipoDocumentoId());
		participante.setTipoDocumento(tipoDocumento);
		participanteRepository.save(participante);
	}
	
	public void deleteParticipante(Integer id) {
		participanteRepository.deleteById(id);
	}
}
