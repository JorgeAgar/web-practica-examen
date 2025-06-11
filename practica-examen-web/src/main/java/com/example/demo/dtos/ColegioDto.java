package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColegioDto {
    private Integer id;
    private String nombre;
    private Integer municipioId;
    private String dane;
}
