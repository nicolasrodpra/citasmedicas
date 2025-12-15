package com.example.sistemaCitaMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita_Medica {

    @Id
    @Column(name = "id_Cita")
    private String idCita;

    @OneToOne
    @JoinColumn(name = "id_Paciente", referencedColumnName = "id_Paciente", nullable = false)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_Doctor", referencedColumnName = "id_Doctor", nullable = false)
    private Doctor doctor;

    @Column(name = "fecha", nullable = false, length = 100)
    private String fecha;

    @Column(name = "hora", nullable = false)
    private String hora;

    @Column(name = "motivo", nullable = false)
    private String motivo;
}
