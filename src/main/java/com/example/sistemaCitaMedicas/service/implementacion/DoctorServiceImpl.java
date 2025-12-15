package com.example.sistemaCitaMedicas.service.implementacion;

import com.example.sistemaCitaMedicas.dto.DoctorCreateDTO;
import com.example.sistemaCitaMedicas.entity.Doctor;
import com.example.sistemaCitaMedicas.entity.Especialidad;
import com.example.sistemaCitaMedicas.repository.DoctorRepository;
import com.example.sistemaCitaMedicas.repository.EspecialidadRepository;
import com.example.sistemaCitaMedicas.service.DoctorService;
import com.example.sistemaCitaMedicas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private EspecialidadService especialidadService;

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> listDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Long doctorId, Doctor doctor) {

        Doctor doctorDB = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        doctorDB.setNombre(doctor.getNombre());
        doctorDB.setTarjetaProfesional(doctor.getTarjetaProfesional());
        doctorDB.setTelefono(doctor.getTelefono());
        doctorDB.setCorreo(doctor.getCorreo());
        doctorDB.setEspecialidad(doctor.getEspecialidad());

        return doctorRepository.save(doctorDB);
    }

    @Override
    public Doctor updateDoctor(Long doctorId, DoctorCreateDTO dto) {

        Doctor doctorDB = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        // Buscar la especialidad usando el ID del DTO
        Especialidad especialidad = especialidadRepository.findById(dto.getIdEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        // Actualizar campos
        doctorDB.setNombre(dto.getNombre());
        doctorDB.setTarjetaProfesional(dto.getTarjetaProfesional());
        doctorDB.setTelefono(dto.getTelefono());
        doctorDB.setCorreo(dto.getCorreo());
        doctorDB.setEspecialidad(especialidad); // 🔥 importante

        return doctorRepository.save(doctorDB);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        doctorRepository.delete(doctor);
    }

    @Override
    public Doctor registerDoctor(DoctorCreateDTO dto) {

        Especialidad especialidad = especialidadService.getById(dto.getIdEspecialidad());

        Doctor doctor = new Doctor();
        doctor.setNombre(dto.getNombre());
        doctor.setTarjetaProfesional(dto.getTarjetaProfesional());
        doctor.setTelefono(dto.getTelefono());
        doctor.setCorreo(dto.getCorreo());
        doctor.setEspecialidad(especialidad);

        return doctorRepository.save(doctor);
    }
}
