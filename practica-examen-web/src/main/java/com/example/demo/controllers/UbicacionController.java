package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.UbicacionDto;
import com.example.demo.entities.Ubicacion;
import com.example.demo.services.UbicacionService;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

	@Autowired
	UbicacionService ubicacionService;

	@GetMapping
	public List<Ubicacion> listarUbicaciones() {
		return ubicacionService.getAllUbicaciones();
	}

	@PostMapping
	public void crearUbicacion(@RequestBody UbicacionDto ubicacionDto) {
		ubicacionService.addUbicacion(new Ubicacion(ubicacionDto));
	}

	@PutMapping("/{id}")
	public void actualizarUbicacion(@PathVariable int id, @RequestBody UbicacionDto ubicacionDto) {
		ubicacionService.updateUbicacion(id, new Ubicacion(ubicacionDto));
	}

	@DeleteMapping("/{id}")
	public void eliminarUbicacion(@PathVariable int id) {
		ubicacionService.deleteUbicacion(id);
	}
}
