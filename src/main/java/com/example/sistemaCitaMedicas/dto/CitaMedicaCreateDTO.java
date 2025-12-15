package com.example.sistemaCitaMedicas.dto;

import lombok.Data;

@Data
public class CitaMedicaCreateDTO {
    private String idCita;
    private Long idPaciente;   // <-- ESTE CAMPO DEBE EXISTIR
    private Long idDoctor;     // <-- ESTE TAMBIÉN
    private String fecha;
    private String hora;
    private String motivo;
}
