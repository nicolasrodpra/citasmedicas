package com.example.sistemaCitaMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Paciente")
    private Long idPaciente;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "documento", nullable = false)
    private String documento;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "direccion", nullable = false)
    private String direccion;
}
