package com.example.sistemaCitaMedicas.service;

import com.example.sistemaCitaMedicas.dto.CitaMedicaCreateDTO;
import com.example.sistemaCitaMedicas.dto.CitaMedicaUpdateDTO;
import com.example.sistemaCitaMedicas.dto.DoctorCreateDTO;
import com.example.sistemaCitaMedicas.entity.Cita_Medica;
import com.example.sistemaCitaMedicas.entity.Doctor;

import java.util.List;

public interface Cita_MedicaService {

    Cita_Medica registerCita_Medica(Cita_Medica cita_medica);

    List<Cita_Medica> listCita_Medica();

    Cita_Medica updateCita_Medica(String cita_medicaId, Cita_Medica cita_medica);

    void deleteCita_Medica(String cita_medicaId);

    Cita_Medica registerCitaMedicaDTO(CitaMedicaCreateDTO dto);

    Cita_Medica updateCita_Medica(String citaMedicaId, CitaMedicaUpdateDTO dto);
}
