package com.example.sistemaCitaMedicas.service.implementacion;

import com.example.sistemaCitaMedicas.entity.Especialidad;
import com.example.sistemaCitaMedicas.repository.EspecialidadRepository;
import com.example.sistemaCitaMedicas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad getById(String idEspecialidad) {
        return especialidadRepository.findById(idEspecialidad)
                .orElse(null);
    }

    @Override
    public Especialidad registerEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public List<Especialidad> listEspecialidad() {
        return especialidadRepository.findAll();
    }

    @Override
    public List<Especialidad> listEspecialidad(Integer limit) {
        if (limit != null && limit > 0) {
            // Usar PageRequest para limitar los resultados
            return especialidadRepository.findAll(PageRequest.of(0, limit)).getContent();
        }
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad updateEspecialidad(String especialidadId, Especialidad especialidad) {
        Especialidad existente = getById(especialidadId);
        if (existente == null) {
            return null;
        }

        existente.setNombre(especialidad.getNombre());
        existente.setDescripcion(especialidad.getDescripcion());

        return especialidadRepository.save(existente);
    }

    @Override
    public void deleteEspecialidad(String especialidadId) {
        if (especialidadRepository.existsById(especialidadId)) {
            especialidadRepository.deleteById(especialidadId);
        }
    }
}