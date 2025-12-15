package com.example.sistemaCitaMedicas.controller;


import com.example.sistemaCitaMedicas.entity.Paciente;
import com.example.sistemaCitaMedicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {


    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<?> registerVehiculo(@RequestBody Paciente paciente){
        Paciente newPaciente = pacienteService.registerPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listPaciente() {
        List<Paciente> pacientes = pacienteService.listPaciente();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/update/{pacienteId}")
    public ResponseEntity<?> updatePaciente(@PathVariable Long pacienteId, @RequestBody Paciente paciente) {
        try {
            Paciente updatePaciente = new Paciente();
            updatePaciente.setNombre(paciente.getNombre());
            updatePaciente.setDocumento(paciente.getDocumento());
            updatePaciente.setTelefono(paciente.getTelefono());
            updatePaciente.setCorreo(paciente.getCorreo());
            updatePaciente.setDireccion(paciente.getDireccion());

            Paciente pacienteDB = pacienteService.updatePaciente(pacienteId, updatePaciente);
            return ResponseEntity.ok(pacienteDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{pacienteId}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long pacienteId){

        try {
            pacienteService.deletePaciente(pacienteId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
