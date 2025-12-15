package com.example.sistemaCitaMedicas.dto;

import lombok.Data;

@Data
public class CitaMedicaUpdateDTO {
    private String fecha;
    private String hora;
    private String motivo;
}
