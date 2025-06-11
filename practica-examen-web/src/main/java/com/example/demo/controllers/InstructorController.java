package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.InstructorDto;
import com.example.demo.entities.Instructor;
import com.example.demo.services.InstructorService;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@GetMapping
	public List<Instructor> listarInstructores() {
		return instructorService.getAllInstructores();
	}

	@PostMapping
	public void crearInstructor(@RequestBody InstructorDto instructorDto) {
		instructorService.addInstructor(new Instructor(instructorDto));
	}

	@PutMapping("/{id}")
	public void actualizarInstructor(@PathVariable int id, @RequestBody InstructorDto instructorDto) {
		instructorService.updateInstructor(id, new Instructor(instructorDto));
	}

	@DeleteMapping("/{id}")
	public void eliminarInstructor(@PathVariable int id) {
		instructorService.deleteInstructor(id);
	}
}
