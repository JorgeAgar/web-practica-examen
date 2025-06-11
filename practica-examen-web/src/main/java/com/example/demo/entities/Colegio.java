package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String dane;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
    
    @JsonIgnore
    @OneToMany(mappedBy = "colegio")
    private List<Participante> participantes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "colegio")
    private List<Programacion> programaciones;
}
