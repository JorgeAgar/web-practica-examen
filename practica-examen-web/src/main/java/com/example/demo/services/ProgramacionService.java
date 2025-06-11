package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Programacion;
import com.example.demo.repositories.ProgramacionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgramacionService {

	@Autowired
	private ProgramacionRepository programacionRepository;
	
	public List<Programacion> getAllProgramaciones() {
		return programacionRepository.findAll();
	}
	
	public Programacion getProgramacionById(Integer id) {
		return programacionRepository.getReferenceById(id);
	}
	
	public void addProgramacion(Programacion newProgramacion) {
		programacionRepository.save(newProgramacion);
	}
	
	public void updateProgramacion(Integer id, Programacion programacion) {
		if(!programacionRepository.existsById(id))
			throw new EntityNotFoundException("Programación no encontrada con id: " + id);
		programacion.setId(id);
		programacionRepository.save(programacion);
	}
	
	public void deleteProgramacion(Integer id) {
		programacionRepository.deleteById(id);
	}
}
