package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SesionDto {
    private LocalDate fecha;
    private LocalTime hora;
    private Integer programacionId;
    private Integer instructorId;
    private Integer ubicacionId;
}
