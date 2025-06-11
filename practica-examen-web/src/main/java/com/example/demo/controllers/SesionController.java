package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.SesionDto;
import com.example.demo.entities.Sesion;
import com.example.demo.services.AsistenteService;
import com.example.demo.services.SesionService;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

	@Autowired
	private SesionService sesionService;
	
	@Autowired
	private AsistenteService asistenteService;
	
	@GetMapping("/{programacionId}")
	public List<Sesion> listarSesiones(@PathVariable int programacionId) {
		return sesionService.getProgramacionSesiones(programacionId);
	}
	
	@PostMapping
	public void crearSesion(@RequestBody SesionDto sesionDto) {
		sesionService.addSesion(sesionDto);
	}
	
	@PostMapping("/{id}/asistencias")
	public void registrarAsistencia(@PathVariable int id, @RequestBody int asistenteId) {
		asistenteService.addAsistente(id, asistenteId);
	}
}
