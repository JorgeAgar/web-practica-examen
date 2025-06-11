package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.TipoDocumentoDto;
import com.example.demo.entities.TipoDocumento;
import com.example.demo.services.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipo-documentos")
public class TipoDocumentoController {

	@Autowired
	TipoDocumentoService tipoDocumentoService;

	@GetMapping
	public List<TipoDocumento> listarTiposDocumento() {
		return tipoDocumentoService.getAllTiposDocumento();
	}

	@PostMapping
	public void crearTipoDocumento(@RequestBody TipoDocumentoDto tipoDocumentoDto) {
		tipoDocumentoService.addTipoDocumento(new TipoDocumento(tipoDocumentoDto));
	}

	@PutMapping("/{id}")
	public void actualizarTipoDocumento(@PathVariable int id, @RequestBody TipoDocumentoDto tipoDocumentoDto) {
		tipoDocumentoService.updateTipoDocumento(id, new TipoDocumento(tipoDocumentoDto));
	}

	@DeleteMapping("/{id}")
	public void eliminarTipoDocumento(@PathVariable int id) {
		tipoDocumentoService.deleteTipoDocumento(id);
	}
}
