package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenteDto {
    private Integer id;
    private Integer sesionId;
    private Integer participanteId;
}
