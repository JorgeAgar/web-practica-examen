package com.example.demo.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.SesionDto;
import com.example.demo.entities.Instructor;
import com.example.demo.entities.Programacion;
import com.example.demo.entities.Sesion;
import com.example.demo.entities.Ubicacion;
import com.example.demo.repositories.SesionRepository;

@Service
public class SesionService {

	@Autowired
	private SesionRepository sesionRepository;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private ProgramacionService programacionService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	public List<Sesion> getAllSesiones() {
		return sesionRepository.findAll();
	}
	
	public List<Sesion> getProgramacionSesiones(int programacionId) {
		List<Sesion> sesiones = getAllSesiones();
		List<Sesion> sesionesProg = new LinkedList<Sesion>();
		for(Sesion s : sesiones) {
			if(s.getProgramacion().getId() == programacionId)
				sesionesProg.add(s);
		}
		return sesionesProg;
	}
	
	public Sesion getSesionById(Integer id) {
		return sesionRepository.getReferenceById(id);
	}
	
	public void addSesion(SesionDto sesionDto) {
		Sesion newSesion = new Sesion();
		newSesion.setFecha(sesionDto.getFecha());
		newSesion.setHora(sesionDto.getHora());
		Instructor instructor = instructorService.getInstructorById(sesionDto.getInstructorId());
		newSesion.setInstructor(instructor);
		Programacion programacion = programacionService.getProgramacionById(sesionDto.getProgramacionId());
		newSesion.setProgramacion(programacion);
		Ubicacion ubicacion = ubicacionService.getUbicacionById(sesionDto.getUbicacionId());
		newSesion.setUbicacion(ubicacion);
		sesionRepository.save(newSesion);
	}
}
