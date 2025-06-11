package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ParticipanteDto;
import com.example.demo.entities.Participante;
import com.example.demo.services.ParticipanteService;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;
	
	@GetMapping
	public List<Participante> listarParticipantes() {
		return participanteService.getAllParticipantes();
	}
	
	@PutMapping("/{id}")
	public void actualizarParticipante(@PathVariable int id, @RequestBody ParticipanteDto participanteDto) {
		participanteService.updateParticipante(id, participanteDto);
	}
}
