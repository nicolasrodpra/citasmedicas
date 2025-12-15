package com.example.sistemaCitaMedicas.entity;

import com.example.sistemaCitaMedicas.dto.DoctorShowDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Doctor")
    private Long idDoctor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "tarjetaProfesional", nullable = false)
    private String tarjetaProfesional;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @OneToOne
    @JoinColumn(name = "id_Especialidad", referencedColumnName = "id_Especialidad", nullable = false)
    private Especialidad especialidad;
}
