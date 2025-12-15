package com.example.sistemaCitaMedicas.controller;

import com.example.sistemaCitaMedicas.dto.CitaMedicaCreateDTO;
import com.example.sistemaCitaMedicas.dto.CitaMedicaUpdateDTO;
import com.example.sistemaCitaMedicas.entity.Cita_Medica;
import com.example.sistemaCitaMedicas.service.Cita_MedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citaMedica")
public class Cita_MedicaController {

    @Autowired
    private Cita_MedicaService cita_medicaService;

    @Autowired
    private Cita_MedicaService citaMedicaService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCita_Medica(@RequestBody Cita_Medica cita_medica){
        Cita_Medica newCita_Medica = cita_medicaService.registerCita_Medica(cita_medica);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCita_Medica);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cita_Medica>> listCita_Medica() {
        List<Cita_Medica> cita_medica = cita_medicaService.listCita_Medica();
        return ResponseEntity.ok(cita_medica);
    }

    @PutMapping("/update/{citaMedicaId}")
    public ResponseEntity<?> updateCita_Medica(@PathVariable String cita_medicaId, @RequestBody Cita_Medica cita_medica) {
        try {
            Cita_Medica updateCita_Medica = new Cita_Medica();
            updateCita_Medica.setFecha(cita_medica.getFecha());
            updateCita_Medica.setHora(cita_medica.getHora());
            updateCita_Medica.setMotivo(cita_medica.getMotivo());

            Cita_Medica cita_medicaDB = cita_medicaService.updateCita_Medica(cita_medicaId, updateCita_Medica);
            return ResponseEntity.ok(cita_medicaDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCitaMedica(@PathVariable("id") String citaMedicaId) {
        try {
            citaMedicaService.deleteCita_Medica(citaMedicaId);
            return new ResponseEntity<>("Cita médica eliminada correctamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registerDTO")
    public ResponseEntity<Cita_Medica> registerCitaMedicaDTO(@RequestBody CitaMedicaCreateDTO dto) {
        Cita_Medica newCita = cita_medicaService.registerCitaMedicaDTO(dto);
        return new ResponseEntity<>(newCita, HttpStatus.CREATED);
    }

    @PutMapping("/updateDTO/{id}")
    public ResponseEntity<Cita_Medica> updateCitaMedica(@PathVariable("id") String citaMedicaId, @RequestBody CitaMedicaUpdateDTO updateDTO) {
        Cita_Medica updatedCita = citaMedicaService.updateCita_Medica(citaMedicaId, updateDTO);
        return new ResponseEntity<>(updatedCita, HttpStatus.OK);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Cita_Medica>> getCitasByPaciente(@PathVariable Long idPaciente) {
        List<Cita_Medica> citas = cita_medicaService.getCitasByPaciente(idPaciente);
        return ResponseEntity.ok(citas);
    }


    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<List<Cita_Medica>> getCitasByDoctor(@PathVariable Long idDoctor) {
        List<Cita_Medica> citas = cita_medicaService.getCitasByDoctor(idDoctor);
        return ResponseEntity.ok(citas);
    }
}