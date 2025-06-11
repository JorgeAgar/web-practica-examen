package com.example.demo.entities;

import java.util.List;

import com.example.demo.dtos.InstructorDto;
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
public class Instructor {
    
	public Instructor(InstructorDto dto) {
        this.nombre = dto.getNombre();
        this.documento = dto.getDocumento();
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String documento;
    
    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<Programacion> programaciones;
    
    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private List<Sesion> sesiones;
}
