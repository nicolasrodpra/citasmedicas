package com.example.sistemaCitaMedicas.service;

import com.example.sistemaCitaMedicas.dto.DoctorCreateDTO;
import com.example.sistemaCitaMedicas.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor registerDoctor(Doctor doctor);

    Doctor registerDoctor(DoctorCreateDTO dto); // <-- AQUI

    List<Doctor> listDoctor();

    Doctor updateDoctor(Long doctorId, Doctor doctor);

    Doctor updateDoctor(Long doctorId, DoctorCreateDTO dto);

    void deleteDoctor(Long doctorId);
}
