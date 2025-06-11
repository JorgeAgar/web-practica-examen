package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.InscripcionDto;
import com.example.demo.entities.Inscripcion;
import com.example.demo.services.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

	@Autowired
	InscripcionService inscripcionService;
	
	@GetMapping
	public List<Inscripcion> listarInscripciones() {
		return inscripcionService.getAllInscripciones();
	}
	
	@PostMapping
	public void registrarInscripcion(@RequestBody InscripcionDto inscripcionDto) {
		inscripcionService.addInscripcion(inscripcionDto);
	}
}
