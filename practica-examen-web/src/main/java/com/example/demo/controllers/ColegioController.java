package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.ColegioDto;
import com.example.demo.entities.Colegio;
import com.example.demo.services.ColegioService;

@RestController
@RequestMapping("/api/colegios")
public class ColegioController {

	@Autowired
	ColegioService colegioService;

	@GetMapping
	public List<Colegio> listarColegios() {
		return colegioService.getAllColegios();
	}

	@PostMapping
	public void crearColegio(@RequestBody ColegioDto colegioDto) {
		colegioService.addColegio(colegioDto);
	}

	@PutMapping("/{id}")
	public void actualizarColegio(@PathVariable int id, @RequestBody ColegioDto colegioDto) {
		colegioService.updateColegio(id, colegioDto);
	}

	@DeleteMapping("/{id}")
	public void eliminarColegio(@PathVariable int id) {
		colegioService.deleteColegio(id);
	}
}
