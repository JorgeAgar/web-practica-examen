package com.example.demo.entities;

import java.util.List;

import com.example.demo.dtos.TipoDocumentoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_documento")
public class TipoDocumento {
	
	public TipoDocumento(TipoDocumentoDto dto) {
        this.id = dto.getId();
        this.descripción = dto.getDescripción();
    }
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripción;
    
    @JsonIgnore
    @OneToMany(mappedBy = "tipoDocumento")
    private List<Participante> participantes;
}
