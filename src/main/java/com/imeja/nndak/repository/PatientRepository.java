package com.imeja.nndak.repository;


import com.imeja.nndak.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
/*

    @Query("SELECT e FROM Patient e WHERE e.uud=:uud")
    Optional<Patient> findByUnique(String uud);
*/

}