package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteDto {
    private String nombre;
    private Integer colegioId;
    private Integer tipoDocumentoId;
}
