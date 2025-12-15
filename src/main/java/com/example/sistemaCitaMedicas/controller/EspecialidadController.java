package com.example.sistemaCitaMedicas.controller;

import com.example.sistemaCitaMedicas.entity.Especialidad;
import com.example.sistemaCitaMedicas.service.EspecialidadService;
import com.example.sistemaCitaMedicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping("/register")
    public ResponseEntity<?> registerEspecialidad(@RequestBody Especialidad especialidad){
        Especialidad newEspecialidad = especialidadService.registerEspecialidad(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEspecialidad);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Especialidad>> listEspecialidad() {
        List<Especialidad> especialidad = especialidadService.listEspecialidad();
        return ResponseEntity.ok(especialidad);
    }

    @PutMapping("/update/{especialidadId}")
    public ResponseEntity<?> updateEspecialidad(
            @PathVariable String especialidadId,
            @RequestBody Especialidad especialidad) {

        try {
            Especialidad updateEspecialidad = new Especialidad();
            updateEspecialidad.setNombre(especialidad.getNombre());
            updateEspecialidad.setDescripcion(especialidad.getDescripcion());

            Especialidad especialidadDB = especialidadService.updateEspecialidad(especialidadId, updateEspecialidad);
            return ResponseEntity.ok(especialidadDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{especialidadId}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable String especialidadId) {

        try {
            especialidadService.deleteEspecialidad(especialidadId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
