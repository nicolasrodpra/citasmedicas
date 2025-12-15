package com.example.sistemaCitaMedicas.service.implementacion;

import com.example.sistemaCitaMedicas.dto.CitaMedicaCreateDTO;
import com.example.sistemaCitaMedicas.dto.CitaMedicaUpdateDTO;
import com.example.sistemaCitaMedicas.entity.Cita_Medica;
import com.example.sistemaCitaMedicas.entity.Doctor;
import com.example.sistemaCitaMedicas.entity.Paciente;
import com.example.sistemaCitaMedicas.repository.Cita_MedicaRepository;
import com.example.sistemaCitaMedicas.repository.DoctorRepository;
import com.example.sistemaCitaMedicas.repository.PacienteRepository;
import com.example.sistemaCitaMedicas.service.Cita_MedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cita_MedicaServiceImpl implements Cita_MedicaService {

    @Autowired
    private Cita_MedicaRepository cita_medicaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Cita_Medica registerCita_Medica(Cita_Medica cita_medica) {
        return cita_medicaRepository.save(cita_medica);
    }

    @Override
    public List<Cita_Medica> listCita_Medica() {
        return cita_medicaRepository.findAll();
    }

    @Override
    public Cita_Medica updateCita_Medica(String cita_medicaId, Cita_Medica cita_medica) {
        Cita_Medica citaBD = cita_medicaRepository.findById(cita_medicaId)
                .orElseThrow(() -> new RuntimeException("Cita médica no encontrada"));

        citaBD.setFecha(cita_medica.getFecha());
        citaBD.setHora(cita_medica.getHora());
        citaBD.setMotivo(cita_medica.getMotivo());

        return cita_medicaRepository.save(citaBD);
    }

    @Override
    public void deleteCita_Medica(String cita_medicaId) {
        Cita_Medica citaExisting = cita_medicaRepository.findById(cita_medicaId)
                .orElseThrow(() -> new RuntimeException(
                        "Cita médica no encontrada con el ID: " + cita_medicaId
                ));

        cita_medicaRepository.deleteById(cita_medicaId);
    }

    @Override
    public Cita_Medica registerCitaMedicaDTO(CitaMedicaCreateDTO dto) {
        // Buscar Paciente
        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Doctor doctor = doctorRepository.findById(dto.getIdDoctor())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        Cita_Medica cita = new Cita_Medica();
        cita.setIdCita(dto.getIdCita());
        cita.setPaciente(paciente);
        cita.setDoctor(doctor);
        cita.setFecha(dto.getFecha());
        cita.setHora(dto.getHora());
        cita.setMotivo(dto.getMotivo());

        return cita_medicaRepository.save(cita);
    }

    @Override
    public Cita_Medica updateCita_Medica(String citaMedicaId, CitaMedicaUpdateDTO dto) {
        Cita_Medica citaBD = cita_medicaRepository.findById(citaMedicaId)
                .orElseThrow(() -> new RuntimeException("Cita médica no encontrada"));

        citaBD.setFecha(dto.getFecha());
        citaBD.setHora(dto.getHora());
        citaBD.setMotivo(dto.getMotivo());

        return cita_medicaRepository.save(citaBD);
    }

    @Override
    public List<Cita_Medica> getCitasByPaciente(Long idPaciente) {
        // Validar que el paciente existe
        pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + idPaciente));

        return cita_medicaRepository.findByPacienteIdPaciente(idPaciente);
    }

    @Override
    public List<Cita_Medica> getCitasByDoctor(Long idDoctor) {
        // Validar que el doctor existe
        doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado con ID: " + idDoctor));

        return cita_medicaRepository.findByDoctorIdDoctor(idDoctor);
    }
}