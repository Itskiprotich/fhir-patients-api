package com.imeja.nndak.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull(message = "Patient Identifier required")
    public Long uud;

    @NotNull(message = "Patient Name is required")
    public String name;

    @NotNull(message = "Patient Family Name is required")
    public String family;

    @NotNull(message = "The date of birth is required.")
    @Past(message = "The date of birth must be in the past.")

    @Column(name = "dob", nullable = false)
    public Date dob;

    @NotNull(message = "Patient Gender is required")
    public String gender;

    @NotNull(message = "Patient Phone is required")
    public String phone;


    @NotNull
    @ManyToOne
    @JoinColumn(name="address")
    private Address address;

    @ColumnDefault("true")
    public boolean active;



    public Patient(Long id, Long uud, String name, String family, Date dob, String gender, String phone, boolean active) {
        this.id = id;
        this.uud = uud;
        this.name = name;
        this.family = family;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.active = active;
    }

    public Patient(Long uud, String name, String family, Date dob, String gender, String phone, boolean active) {
        this.uud = uud;
        this.name = name;
        this.family = family;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUud() {
        return uud;
    }

    public void setUud(Long uud) {
        this.uud = uud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
