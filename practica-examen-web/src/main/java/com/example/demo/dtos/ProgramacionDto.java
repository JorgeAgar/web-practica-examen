package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramacionDto {
    private Integer colegioId;
    private Integer tallerId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer cantidad;
    private String observación;
    private Integer instructorId;
    private Integer grado;
    private String grupo;
    private Integer ubicacionId;
}
