package com.example.sistemaCitaMedicas.service.implementacion;

import com.example.sistemaCitaMedicas.entity.Paciente;
import com.example.sistemaCitaMedicas.repository.PacienteRepository;
import com.example.sistemaCitaMedicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente registerPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listPaciente() {return pacienteRepository.findAll(); }

    @Override
    public Paciente updatePaciente(Long pacienteId, Paciente paciente) {
        Paciente pacienteBD = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        pacienteBD.setNombre(paciente.getNombre());
        pacienteBD.setDocumento(paciente.getDocumento());
        pacienteBD.setTelefono(paciente.getTelefono());
        pacienteBD.setCorreo(paciente.getCorreo());
        pacienteBD.setDireccion(paciente.getDireccion());

        return pacienteRepository.save(pacienteBD);
    }

    @Override
    public void deletePaciente(Long pacienteId) {
        if (!pacienteRepository.existsById(pacienteId)) {
            throw new RuntimeException("Paciente no encontrado");
        }
        pacienteRepository.deleteById(pacienteId);
    }
}
