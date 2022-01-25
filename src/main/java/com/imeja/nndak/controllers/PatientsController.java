package com.imeja.nndak.controllers;


import com.imeja.nndak.entities.Patient;
import com.imeja.nndak.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/patient/")
public class PatientsController {
    private final PatientService patientService;

    @Autowired
    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "list")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping(path = "view/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") long id) {

        Optional<Patient> patient = patientService.findPatientById(id);

        return patient.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "add")
    public ResponseEntity<Patient> addPatient(@Validated @RequestBody(required = true) Patient patient) {

        patientService.addPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);

    }
}