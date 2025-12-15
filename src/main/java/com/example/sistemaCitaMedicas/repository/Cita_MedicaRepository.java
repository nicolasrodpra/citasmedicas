package com.example.sistemaCitaMedicas.repository;

import com.example.sistemaCitaMedicas.entity.Cita_Medica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cita_MedicaRepository extends JpaRepository<Cita_Medica, String> {

    // Si quieres un findBy personalizado:
    Cita_Medica findByIdCita(String idCita);
}