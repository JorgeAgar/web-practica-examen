package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EvidenciaDto;
import com.example.demo.entities.Evidencia;
import com.example.demo.services.EvidenciaService;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {
	
	@Autowired
	private EvidenciaService evidenciaService;
	
	@GetMapping("/{sesionId}")
	public List<Evidencia> listarEvidenciasPorSesion(@PathVariable int sesionId) {
		return evidenciaService.getEvidenciaSesion(sesionId);
	}
	
	@PostMapping
	public void subirEvidencia(@RequestBody EvidenciaDto evidenciaDto) {
		evidenciaService.addEvidencia(evidenciaDto);
	}
}
