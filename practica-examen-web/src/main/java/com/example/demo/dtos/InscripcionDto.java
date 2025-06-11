package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDto {
    private Integer participanteId;
    private Integer programaciónId;
    private LocalDate fecha;
}
