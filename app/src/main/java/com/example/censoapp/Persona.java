package com.example.censoapp;

import java.time.LocalDate;

public class Persona {
    int nroDni;//indice 0
    String nombre;//indice 1
    String apellido;//indice 2
    String sexo;//indice 3
    LocalDate fechaNacimiento;//indice 4
    String relacionReferencia;//indice 5 // IMPORTANTE: falta preguntar
    String genero;//indice 6
    String discapacidad;//indice 7
    String cursa;//indice 8
    String nivel;//indice 9
    String gradoAnioActual;//indice 10
    String nivelMayor;//indice 11
    String completoNievelMayor;//indice 12
    String cantAprobados;//indice 13
    String nacimientoPais;//indice 14
    String nacimientoProvincia;//indice 15
    String nacimientoLocalidad;//indice 16
    String viviaHaceCincoAnios;//indice 17
    String haceCincoAniosNacimientoPais;//indice 18
    String haceCincoAniosNacimientoProvincia;//indice 19
    String haceCincoAniosNacimientoLocalidad;//indice 20
    String coberturaSalud;//indice 21
    String cobraJubOPen;//indice 22
    String queCobra;//indice 23
    String indigena;//indice 24
    String puebloIndigina;//indice 25
    String hablaLenguaIndigena;//indice 26
    String afrodescendiente;//indice 27
    String semPasadTrabajo;//indice 28
    String semPasadChanga;//indice 29
    String semPasadFalto;//indice 30
    String cuatroSemBusco;//indice 31
    String tieneTrab;//indice 32 ///
    String estadoTrabajo; //indice 33 ///
    String trabajoDescJubi; //indice 34 ///
    String trabajoAportJubi; //indice 35 ///
    String actividadTrabajo; //indice 36 ///
    String detalleTrabajo; //indice 37 ///
    int hijosNacidos;//indice 38
    int hijosVivos;//indice 39
    LocalDate fechaNacUltimoHijo;//indice 40

    public Persona(int nroDni, String nombre, String apellido, String sexo, LocalDate fechaNacimiento,
                   String relacionReferencia, String genero, String discapacidad, String cursa, String nivel,
                   String gradoAnioActual, String nivelMayor, String completoNievelMayor, String cantAprobados,
                   String nacimientoPais, String nacimientoProvincia, String nacimientoLocalidad,
                   String viviaHaceCincoAnios, String haceCincoAniosNacimientoPais, String haceCincoAniosNacimientoProvincia, String haceCincoAniosNacimientoLocalidad, String coberturaSalud, String cobraJubOPen, String queCobra, String indigena, String puebloIndigina, String hablaLenguaIndigena, String afrodescendiente, String semPasadTrabajo, String semPasadChanga, String semPasadFalto, String cuatroSemBusco, String tieneTrab, String estadoTrabajo, String trabajoDescJubi, String trabajoAportJubi, String actividadTrabajo, String detalleTrabajo, int hijosNacidos, int hijosVivos, LocalDate fechaNacUltimoHijo) {
        this.nroDni = nroDni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.relacionReferencia = relacionReferencia;
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.cursa = cursa;
        this.nivel = nivel;
        this.gradoAnioActual = gradoAnioActual;
        this.nivelMayor = nivelMayor;
        this.completoNievelMayor = completoNievelMayor;
        this.cantAprobados = cantAprobados;
        this.nacimientoPais = nacimientoPais;
        this.nacimientoProvincia = nacimientoProvincia;
        this.nacimientoLocalidad = nacimientoLocalidad;
        this.viviaHaceCincoAnios = viviaHaceCincoAnios;
        this.haceCincoAniosNacimientoPais = haceCincoAniosNacimientoPais;
        this.haceCincoAniosNacimientoProvincia = haceCincoAniosNacimientoProvincia;
        this.haceCincoAniosNacimientoLocalidad = haceCincoAniosNacimientoLocalidad;
        this.coberturaSalud = coberturaSalud;
        this.cobraJubOPen = cobraJubOPen;
        this.queCobra = queCobra;
        this.indigena = indigena;
        this.puebloIndigina = puebloIndigina;
        this.hablaLenguaIndigena = hablaLenguaIndigena;
        this.afrodescendiente = afrodescendiente;
        this.semPasadTrabajo = semPasadTrabajo;
        this.semPasadChanga = semPasadChanga;
        this.semPasadFalto = semPasadFalto;
        this.cuatroSemBusco = cuatroSemBusco;
        this.tieneTrab = tieneTrab;
        this.estadoTrabajo = estadoTrabajo;
        this.trabajoDescJubi = trabajoDescJubi;
        this.trabajoAportJubi = trabajoAportJubi;
        this.actividadTrabajo = actividadTrabajo;
        this.detalleTrabajo = detalleTrabajo;
        this.hijosNacidos = hijosNacidos;
        this.hijosVivos = hijosVivos;
        this.fechaNacUltimoHijo = fechaNacUltimoHijo;
    }

    public int getNroDni() {
        return nroDni;
    }

    public void setNroDni(int nroDni) {
        this.nroDni = nroDni;
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

    public String getRelacionReferencia() {
        return relacionReferencia;
    }

    public void setRelacionReferencia(String relacionReferencia) {
        this.relacionReferencia = relacionReferencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getCursa() {
        return cursa;
    }

    public void setCursa(String cursa) {
        this.cursa = cursa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGradoAnioActual() {
        return gradoAnioActual;
    }

    public void setGradoAnioActual(String gradoAnioActual) {
        this.gradoAnioActual = gradoAnioActual;
    }

    public String getNivelMayor() {
        return nivelMayor;
    }

    public void setNivelMayor(String nivelMayor) {
        this.nivelMayor = nivelMayor;
    }

    public String getCompletoNievelMayor() {
        return completoNievelMayor;
    }

    public void setCompletoNievelMayor(String completoNievelMayor) {
        this.completoNievelMayor = completoNievelMayor;
    }

    public String getCantAprobados() {
        return cantAprobados;
    }

    public void setCantAprobados(String cantAprobados) {
        this.cantAprobados = cantAprobados;
    }

    public String getNacimientoPais() {
        return nacimientoPais;
    }

    public void setNacimientoPais(String nacimientoPais) {
        this.nacimientoPais = nacimientoPais;
    }

    public String getNacimientoProvincia() {
        return nacimientoProvincia;
    }

    public void setNacimientoProvincia(String nacimientoProvincia) {
        this.nacimientoProvincia = nacimientoProvincia;
    }

    public String getNacimientoLocalidad() {
        return nacimientoLocalidad;
    }

    public void setNacimientoLocalidad(String nacimientoLocalidad) {
        this.nacimientoLocalidad = nacimientoLocalidad;
    }

    public String getViviaHaceCincoAnios() {
        return viviaHaceCincoAnios;
    }

    public void setViviaHaceCincoAnios(String viviaHaceCincoAnios) {
        this.viviaHaceCincoAnios = viviaHaceCincoAnios;
    }

    public String getHaceCincoAniosNacimientoPais() {
        return haceCincoAniosNacimientoPais;
    }

    public void setHaceCincoAniosNacimientoPais(String haceCincoAniosNacimientoPais) {
        this.haceCincoAniosNacimientoPais = haceCincoAniosNacimientoPais;
    }

    public String getHaceCincoAniosNacimientoProvincia() {
        return haceCincoAniosNacimientoProvincia;
    }

    public void setHaceCincoAniosNacimientoProvincia(String haceCincoAniosNacimientoProvincia) {
        this.haceCincoAniosNacimientoProvincia = haceCincoAniosNacimientoProvincia;
    }

    public String getHaceCincoAniosNacimientoLocalidad() {
        return haceCincoAniosNacimientoLocalidad;
    }

    public void setHaceCincoAniosNacimientoLocalidad(String haceCincoAniosNacimientoLocalidad) {
        this.haceCincoAniosNacimientoLocalidad = haceCincoAniosNacimientoLocalidad;
    }

    public String getCoberturaSalud() {
        return coberturaSalud;
    }

    public void setCoberturaSalud(String coberturaSalud) {
        this.coberturaSalud = coberturaSalud;
    }

    public String getCobraJubOPen() {
        return cobraJubOPen;
    }

    public void setCobraJubOPen(String cobraJubOPen) {
        this.cobraJubOPen = cobraJubOPen;
    }

    public String getQueCobra() {
        return queCobra;
    }

    public void setQueCobra(String queCobra) {
        this.queCobra = queCobra;
    }

    public String getIndigena() {
        return indigena;
    }

    public void setIndigena(String indigena) {
        this.indigena = indigena;
    }

    public String getPuebloIndigina() {
        return puebloIndigina;
    }

    public void setPuebloIndigina(String puebloIndigina) {
        this.puebloIndigina = puebloIndigina;
    }

    public String getHablaLenguaIndigena() {
        return hablaLenguaIndigena;
    }

    public void setHablaLenguaIndigena(String hablaLenguaIndigena) {
        this.hablaLenguaIndigena = hablaLenguaIndigena;
    }

    public String getAfrodescendiente() {
        return afrodescendiente;
    }

    public void setAfrodescendiente(String afrodescendiente) {
        this.afrodescendiente = afrodescendiente;
    }

    public String getSemPasadTrabajo() {
        return semPasadTrabajo;
    }

    public void setSemPasadTrabajo(String semPasadTrabajo) {
        this.semPasadTrabajo = semPasadTrabajo;
    }

    public String getSemPasadChanga() {
        return semPasadChanga;
    }

    public void setSemPasadChanga(String semPasadChanga) {
        this.semPasadChanga = semPasadChanga;
    }

    public String getSemPasadFalto() {
        return semPasadFalto;
    }

    public void setSemPasadFalto(String semPasadFalto) {
        this.semPasadFalto = semPasadFalto;
    }

    public String getCuatroSemBusco() {
        return cuatroSemBusco;
    }

    public void setCuatroSemBusco(String cuatroSemBusco) {
        this.cuatroSemBusco = cuatroSemBusco;
    }

    public String getTieneTrab() {
        return tieneTrab;
    }

    public void setTieneTrab(String tieneTrab) {
        this.tieneTrab = tieneTrab;
    }

    public String getEstadoTrabajo() {
        return estadoTrabajo;
    }

    public void setEstadoTrabajo(String estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
    }

    public String getTrabajoDescJubi() {
        return trabajoDescJubi;
    }

    public void setTrabajoDescJubi(String trabajoDescJubi) {
        this.trabajoDescJubi = trabajoDescJubi;
    }

    public String getTrabajoAportJubi() {
        return trabajoAportJubi;
    }

    public void setTrabajoAportJubi(String trabajoAportJubi) {
        this.trabajoAportJubi = trabajoAportJubi;
    }

    public String getActividadTrabajo() {
        return actividadTrabajo;
    }

    public void setActividadTrabajo(String actividadTrabajo) {
        this.actividadTrabajo = actividadTrabajo;
    }

    public String getDetalleTrabajo() {
        return detalleTrabajo;
    }

    public void setDetalleTrabajo(String detalleTrabajo) {
        this.detalleTrabajo = detalleTrabajo;
    }

    public int getHijosNacidos() {
        return hijosNacidos;
    }

    public void setHijosNacidos(int hijosNacidos) {
        this.hijosNacidos = hijosNacidos;
    }

    public int getHijosVivos() {
        return hijosVivos;
    }

    public void setHijosVivos(int hijosVivos) {
        this.hijosVivos = hijosVivos;
    }

    public LocalDate getFechaNacUltimoHijo() {
        return fechaNacUltimoHijo;
    }

    public void setFechaNacUltimoHijo(LocalDate fechaNacUltimoHijo) {
        this.fechaNacUltimoHijo = fechaNacUltimoHijo;
    }
}

