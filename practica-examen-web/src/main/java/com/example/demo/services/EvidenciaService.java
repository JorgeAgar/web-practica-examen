package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EvidenciaDto;
import com.example.demo.entities.Evidencia;
import com.example.demo.entities.Sesion;
import com.example.demo.repositories.EvidenciaRepository;

@Service
public class EvidenciaService {

	@Autowired
	private EvidenciaRepository evidenciaRepository;
	
	@Autowired
	private SesionService sesionService;
	
	public List<Evidencia> getAllEvidencias() {
		return evidenciaRepository.findAll();
	}
	
	public List<Evidencia> getEvidenciaSesion(int sesionId) {
		return sesionService.getSesionById(sesionId).getEvidencias();
	}
	
	public Evidencia getEvidenciaById(Integer id) {
		return evidenciaRepository.getReferenceById(id);
	}
	
	public void addEvidencia(EvidenciaDto evidenciaDto) {
		Evidencia newEvidencia = new Evidencia();
		newEvidencia.setFecha(evidenciaDto.getFecha());
		newEvidencia.setObservación(evidenciaDto.getObservación());
		Sesion sesion = sesionService.getSesionById(evidenciaDto.getSesionId());
		newEvidencia.setSesion(sesion);
		evidenciaRepository.save(newEvidencia);
	}
}
