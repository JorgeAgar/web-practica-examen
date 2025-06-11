package com.example.demo.entities;

import java.util.List;

import com.example.demo.dtos.UbicacionDto;
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
public class Ubicacion {
	
	public Ubicacion(UbicacionDto dto) {
        this.nombre = dto.getNombre();
    }
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ubicacion")
    private List<Programacion> programaciones;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ubicacion")
    private List<Sesion> sesiones;
}
