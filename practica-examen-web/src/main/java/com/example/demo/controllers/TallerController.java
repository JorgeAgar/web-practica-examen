package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TallerDto;
import com.example.demo.entities.Taller;
import com.example.demo.services.TallerService;

@RestController
@RequestMapping("/api/talleres")
public class TallerController {
	
	@Autowired
	TallerService tallerService;
	
	@GetMapping
	public List<Taller> listarTalleres() {
		return tallerService.getAllTalleres();
	}
	
	@PostMapping
	public void crearTaller(@RequestBody TallerDto tallerDto) {
		tallerService.addTaller(new Taller(tallerDto));
	}
	
	@PutMapping("/{id}")
	public void actualizarTaller(@PathVariable int id, @RequestBody TallerDto tallerDto) {
		tallerService.updateTaller(id, new Taller(tallerDto));
	}
	
	@DeleteMapping("/{id}")
	public void eliminarTaller(@PathVariable int id) {
		tallerService.deleteTaller(id);
	}
}
