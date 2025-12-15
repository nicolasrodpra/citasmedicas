package com.example.sistemaCitaMedicas.dto;

import lombok.Data;

@Data
public class DoctorShowDTO {

    private Long idDoctor;
    private String nombre;
    private String tarjetaProfesional;
    private String telefono;
    private String correo;

    private String nombreEspecialidad;
}
