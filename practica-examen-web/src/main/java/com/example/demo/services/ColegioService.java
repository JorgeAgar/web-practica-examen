package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ColegioDto;
import com.example.demo.entities.Colegio;
import com.example.demo.entities.Municipio;
import com.example.demo.repositories.ColegioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColegioService {

	@Autowired
	private ColegioRepository colegioRepository;
	
	@Autowired
	private MunicipioService municipioService;
	
	public List<Colegio> getAllColegios() {
		return colegioRepository.findAll();
	}
	
	public Colegio getColegioById(Integer id) {
		return colegioRepository.getReferenceById(id);
	}
	
	public void addColegio(ColegioDto colegioDto) {
		Colegio newColegio = new Colegio();
		newColegio.setDane(colegioDto.getDane());
		newColegio.setNombre(colegioDto.getNombre());
		
		Municipio muni = municipioService.getMunicipioById(colegioDto.getMunicipioId());
		
		newColegio.setMunicipio(muni);
		
		colegioRepository.save(newColegio);
	}
	
	public void updateColegio(Integer id, ColegioDto colegioDto) {
		if(!colegioRepository.existsById(id))
			throw new EntityNotFoundException("Colegio no encontrado con id: " + id);
		
		Colegio colegio = new Colegio();
		colegio.setDane(colegioDto.getDane());
		colegio.setNombre(colegioDto.getNombre());
		
		Municipio muni = municipioService.getMunicipioById(colegioDto.getMunicipioId());
		
		colegio.setMunicipio(muni);
		
		colegio.setId(id);
		colegioRepository.save(colegio);
	}
	
	public void deleteColegio(Integer id) {
		colegioRepository.deleteById(id);
	}
}
