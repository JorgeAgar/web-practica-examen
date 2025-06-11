package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TipoDocumento;
import com.example.demo.repositories.TipoDocumentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public List<TipoDocumento> getAllTiposDocumento() {
		return tipoDocumentoRepository.findAll();
	}
	
	public TipoDocumento getTipoDocumentoById(Integer id) {
		return tipoDocumentoRepository.getReferenceById(id);
	}
	
	public void addTipoDocumento(TipoDocumento newTipoDocumento) {
		tipoDocumentoRepository.save(newTipoDocumento);
	}
	
	public void updateTipoDocumento(Integer id, TipoDocumento tipoDocumento) {
		if(!tipoDocumentoRepository.existsById(id))
			throw new EntityNotFoundException("Tipo de documento no encontrado con id: " + id);
		tipoDocumento.setId(id);
		tipoDocumentoRepository.save(tipoDocumento);
	}
	
	public void deleteTipoDocumento(Integer id) {
		tipoDocumentoRepository.deleteById(id);
	}
}
