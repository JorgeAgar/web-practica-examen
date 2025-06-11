package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Taller;
import com.example.demo.repositories.TallerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TallerService {

	@Autowired
	private TallerRepository tallerRepository;
	
	public List<Taller> getAllTalleres() {
		return tallerRepository.findAll();
	}
	
	public void addTaller(Taller newTaller) {
		tallerRepository.save(newTaller);
	}
	
	public void updateTaller(Integer id, Taller taller) {
		if(!tallerRepository.existsById(id))
			throw new EntityNotFoundException("Taller no encontrado con id: " + id);
		taller.setId(id);
		tallerRepository.save(taller);
	}
	
	public void deleteTaller(Integer id) {
		tallerRepository.deleteById(id);
	}
}
