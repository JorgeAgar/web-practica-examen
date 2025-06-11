package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {
    private Integer id;
    private String nombre;
    private String documento;
}
