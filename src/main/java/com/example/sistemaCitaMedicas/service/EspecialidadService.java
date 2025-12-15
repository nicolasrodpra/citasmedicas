package com.example.sistemaCitaMedicas.service;

import com.example.sistemaCitaMedicas.entity.Especialidad;

import java.util.List;

public interface EspecialidadService {

    Especialidad getById(String idEspecialidad);

    Especialidad registerEspecialidad(Especialidad especialidad);

    List<Especialidad> listEspecialidad();


    List<Especialidad> listEspecialidad(Integer limit);

    Especialidad updateEspecialidad(String especialidadId, Especialidad especialidad);

    void deleteEspecialidad(String especialidadId);
}