package com.example.demo.entities;

import java.util.List;

import com.example.demo.dtos.TallerDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
public class Taller {
	
	public Taller(TallerDto dto) {
        this.nombre = dto.getNombre();
        this.descripción = dto.getDescripción();
    }
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripción;
    
    @JsonIgnore
    @OneToMany(mappedBy = "taller")
    private List<Programacion> programaciones;
}

