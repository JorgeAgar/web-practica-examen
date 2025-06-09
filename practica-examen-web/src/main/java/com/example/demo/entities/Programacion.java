package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "colegio_id")
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "taller_id")
    private Taller taller;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer cantidad;

    @Column(columnDefinition = "TEXT")
    private String observación;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private Integer grado;

    private String grupo;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;
}
