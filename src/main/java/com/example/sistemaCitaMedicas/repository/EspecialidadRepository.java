package com.example.sistemaCitaMedicas.repository;

import com.example.sistemaCitaMedicas.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, String> {

    Optional<Especialidad> findByIdEspecialidad(String idEspecialidad);

}


