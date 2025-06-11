package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Instructor;
import com.example.demo.repositories.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	
	public List<Instructor> getAllInstructores() {
		return instructorRepository.findAll();
	}
	
	public Instructor getInstructorById(Integer id) {
		return instructorRepository.getReferenceById(id);
	}
	
	public void addInstructor(Instructor newInstructor) {
		instructorRepository.save(newInstructor);
	}
	
	public void updateInstructor(Integer id, Instructor instructor) {
		if(!instructorRepository.existsById(id))
			throw new EntityNotFoundException("Instructor no encontrado con id: " + id);
		instructor.setId(id);
		instructorRepository.save(instructor);
	}
	
	public void deleteInstructor(Integer id) {
		instructorRepository.deleteById(id);
	}
}
