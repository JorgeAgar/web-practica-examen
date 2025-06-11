package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.MunicipioDto;
import com.example.demo.entities.Municipio;
import com.example.demo.services.MunicipioService;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

	@Autowired
	MunicipioService municipioService;

	@GetMapping
	public List<Municipio> listarMunicipios() {
		return municipioService.getAllMunicipios();
	}

	@PostMapping
	public void crearMunicipio(@RequestBody MunicipioDto municipioDto) {
		municipioService.addMunicipio(new Municipio(municipioDto));
	}
}
