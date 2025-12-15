package com.example.sistemaCitaMedicas.controller;

import com.example.sistemaCitaMedicas.dto.DoctorCreateDTO;
import com.example.sistemaCitaMedicas.entity.Doctor;
import com.example.sistemaCitaMedicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody Doctor doctor){
        Doctor newDoctor = doctorService.registerDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> listDoctor() {
        List<Doctor> vehiculos = doctorService.listDoctor();
        return ResponseEntity.ok(vehiculos);
    }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long doctorId, @RequestBody Doctor doctor) {
        try {
            Doctor updateDoctor = new Doctor();
            updateDoctor.setNombre(doctor.getNombre());
            updateDoctor.setTarjetaProfesional(doctor.getTarjetaProfesional());
            updateDoctor.setTelefono(doctor.getTelefono());
            updateDoctor.setCorreo(doctor.getCorreo());

            Doctor doctorDB = doctorService.updateDoctor(doctorId, updateDoctor);
            return ResponseEntity.ok(doctorDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId){

        try {
            doctorService.deleteDoctor(doctorId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping("/registerDTO")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorCreateDTO dto){
        Doctor newDoctor = doctorService.registerDoctor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
    }

    @PutMapping("/updateDTO/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody DoctorCreateDTO dto){
        Doctor updated = doctorService.updateDoctor(id, dto);
        return ResponseEntity.ok(updated);
    }

}
