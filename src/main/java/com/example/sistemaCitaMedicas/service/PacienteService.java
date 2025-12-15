package com.example.sistemaCitaMedicas.service;

import com.example.sistemaCitaMedicas.entity.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente registerPaciente(Paciente paciente);

    List<Paciente>listPaciente();

    Paciente updatePaciente(Long pacienteId, Paciente paciente);

    void deletePaciente(Long pacienteId);
}
