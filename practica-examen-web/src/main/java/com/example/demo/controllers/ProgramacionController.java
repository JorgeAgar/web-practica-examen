package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProgramacionDto;
import com.example.demo.entities.Programacion;
import com.example.demo.services.ProgramacionService;

@RestController
@RequestMapping("/api/programaciones")
public class ProgramacionController {

	@Autowired
	ProgramacionService programacionService;
	
	@GetMapping
	public List<Programacion> listarProgramaciones() {
		return programacionService.getAllProgramaciones();
	}
	
	@PostMapping
	public void crearProgramacion(@RequestBody ProgramacionDto programacionDto) {
		programacionService.addProgramacion(programacionDto);
	}
	
	@PutMapping("/{id}")
	public void actualizarProgramacion(@PathVariable int id, @RequestBody ProgramacionDto programacionDto) {
		programacionService.updateProgramacion(id, programacionDto);
	}
}
