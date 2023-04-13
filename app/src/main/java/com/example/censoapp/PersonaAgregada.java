package com.example.censoapp;

import java.time.LocalDate;

public class PersonaAgregada {
    String nombre;
    String apellido;
    int nroDni;
    String sexo;
    LocalDate fechaNacimiento;

    public PersonaAgregada(String nombre, String apellido, int nroDni, String sexo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDni = nroDni;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNroDni() {
        return nroDni;
    }

    public void setNroDni(int nroDni) {
        this.nroDni = nroDni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

