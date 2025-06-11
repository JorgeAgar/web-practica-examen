package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Municipio;
import com.example.demo.repositories.MunicipioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;
	
	public List<Municipio> getAllMunicipios() {
		return municipioRepository.findAll();
	}
	
	public void addMunicipio(Municipio newMunicipio) {
		municipioRepository.save(newMunicipio);
	}
	
	public void updateMunicipio(Integer id, Municipio municipio) {
		if(!municipioRepository.existsById(id))
			throw new EntityNotFoundException("Municipio no encontrado con id: " + id);
		municipio.setId(id);
		municipioRepository.save(municipio);
	}
	
	public void deleteMunicipio(Integer id) {
		municipioRepository.deleteById(id);
	}
}
