package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProgramacionDto;
import com.example.demo.entities.Colegio;
import com.example.demo.entities.Instructor;
import com.example.demo.entities.Programacion;
import com.example.demo.entities.Taller;
import com.example.demo.entities.Ubicacion;
import com.example.demo.repositories.ProgramacionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProgramacionService {

	@Autowired
	private ProgramacionRepository programacionRepository;
	
	@Autowired
	private ColegioService colegioService;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private TallerService tallerService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	public List<Programacion> getAllProgramaciones() {
		return programacionRepository.findAll();
	}
	
	public Programacion getProgramacionById(Integer id) {
		return programacionRepository.getReferenceById(id);
	}
	
	public void addProgramacion(ProgramacionDto programacionDto) {
		Programacion newProgramacion = new Programacion();
		newProgramacion.setCantidad(programacionDto.getCantidad());
		newProgramacion.setFechaFin(programacionDto.getFechaFin());
		newProgramacion.setFechaInicio(programacionDto.getFechaInicio());
		newProgramacion.setGrado(programacionDto.getGrado());
		newProgramacion.setGrupo(programacionDto.getGrupo());
		newProgramacion.setObservación(programacionDto.getObservación());
		Colegio colegio = colegioService.getColegioById(programacionDto.getColegioId());
		newProgramacion.setColegio(colegio);
		Instructor instructor = instructorService.getInstructorById(programacionDto.getInstructorId());
		newProgramacion.setInstructor(instructor);
		Taller taller = tallerService.getTallerById(programacionDto.getTallerId());
		Ubicacion ubicacion = ubicacionService.getUbicacionById(programacionDto.getUbicacionId());
		newProgramacion.setUbicacion(ubicacion);
		newProgramacion.setTaller(taller);
		
		programacionRepository.save(newProgramacion);
	}
	
	public void updateProgramacion(Integer id, ProgramacionDto programacionDto) {
		if(!programacionRepository.existsById(id))
			throw new EntityNotFoundException("Programación no encontrada con id: " + id);
		Programacion programacion = programacionRepository.getReferenceById(id);
		programacion.setCantidad(programacionDto.getCantidad());
		programacion.setFechaFin(programacionDto.getFechaFin());
		programacion.setFechaInicio(programacionDto.getFechaInicio());
		programacion.setGrado(programacionDto.getGrado());
		programacion.setGrupo(programacionDto.getGrupo());
		programacion.setObservación(programacionDto.getObservación());
		Colegio colegio = colegioService.getColegioById(programacionDto.getColegioId());
		programacion.setColegio(colegio);
		Instructor instructor = instructorService.getInstructorById(programacionDto.getInstructorId());
		programacion.setInstructor(instructor);
		Taller taller = tallerService.getTallerById(programacionDto.getTallerId());
		Ubicacion ubicacion = ubicacionService.getUbicacionById(programacionDto.getUbicacionId());
		programacion.setUbicacion(ubicacion);
		programacion.setTaller(taller);
		programacionRepository.save(programacion);
	}
	
	public void deleteProgramacion(Integer id) {
		programacionRepository.deleteById(id);
	}
}
