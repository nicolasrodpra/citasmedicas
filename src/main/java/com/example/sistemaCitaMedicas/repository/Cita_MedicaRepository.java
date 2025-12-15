package com.example.sistemaCitaMedicas.repository;

import com.example.sistemaCitaMedicas.entity.Cita_Medica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cita_MedicaRepository extends JpaRepository<Cita_Medica, String> {

    Cita_Medica findByIdCita(String idCita);


    List<Cita_Medica> findByPacienteIdPaciente(Long idPaciente);


    List<Cita_Medica> findByDoctorIdDoctor(Long idDoctor);
}