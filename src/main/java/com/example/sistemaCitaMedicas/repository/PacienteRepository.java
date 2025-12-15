package com.example.sistemaCitaMedicas.repository;

import com.example.sistemaCitaMedicas.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByIdPaciente(Long idPaciente);
}
