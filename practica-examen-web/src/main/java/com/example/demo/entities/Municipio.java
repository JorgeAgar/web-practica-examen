package com.example.demo.entities;

import java.util.List;

import com.example.demo.dtos.MunicipioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipio {
	
	public Municipio(MunicipioDto dto) {
        this.id = dto.getId();
        this.nombre = dto.getNombre();
        this.dane = dto.getDane();
    }
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String dane;
    
    @JsonIgnore
    @OneToMany(mappedBy = "municipio")
    private List<Colegio> colegios;
}
