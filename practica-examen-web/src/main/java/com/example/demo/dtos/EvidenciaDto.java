package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvidenciaDto {
    private Integer id;
    private Integer sesionId;
    private String observación;
    private LocalDate fecha;
}
