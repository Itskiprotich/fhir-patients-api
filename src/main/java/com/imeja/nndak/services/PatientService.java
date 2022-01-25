package com.imeja.nndak.services;

import com.imeja.nndak.entities.Patient;
import com.imeja.nndak.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findPatientById(Long id){
        return patientRepository.findById(id);
    }

    public void addPatient(Patient patient) {

        Optional<Patient> userByUnique = patientRepository.findById(patient.uud);
        if (userByUnique.isPresent()) {
            throw new IllegalArgumentException("Unique Taken");
        }
        patientRepository.save(patient);
        System.out.println(patient);
    }
}
