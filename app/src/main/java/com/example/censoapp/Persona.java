package com.example.censoapp;

import java.time.LocalDate;

public class Persona {
    String nombe;
    String apellido;
    String nroDni;
    String RelacionReferencia;
    boolean Discapacidad;
    String Sexo;
    String Genero;
    LocalDate FechaNacimiento;
    boolean Cursa;
    String Nivel;
    String GradoAnioActual;
    boolean Asistio;
    String NivelMayor;
    boolean CompletoNievelMayot;
    String CantAprobados;
    String NacimientoProvincia;
    String NacimientoPais;
    int AnioLlegadaArg;
    String ViviaHaceCincoAnios;
    String HaceCincoProvincia;
    String CoberturaSalud;
    boolean CobraJubOPen;
    String QueCobra;
    boolean Indigena;
    String PuebloIndigina;
    boolean HablaLenguaIndigena;
    boolean Afrodescendiente;
    boolean SemPasadTrabajo;
    boolean SemPasadChanga;
    boolean SemPasadFalto;
    boolean CuatroSemBusco;
    int HijosNacidos;
    int HijosVivos;
    LocalDate FechaNacUltimoHijo;

    public Persona(String nombe, String apellido, String nroDni, String relacionReferencia,
                   boolean discapacidad, String sexo, String genero, LocalDate fechaNacimiento,
                   boolean cursa, String nivel, String gradoAnioActual, boolean asistio,
                   String nivelMayor, boolean completoNievelMayot, String cantAprobados,
                   String nacimientoProvincia, String nacimientoPais, int anioLlegadaArg,
                   String viviaHaceCincoAnios, String haceCincoProvincia, String coberturaSalud,
                   boolean cobraJubOPen, String queCobra, boolean indigena, String puebloIndigina,
                   boolean hablaLenguaIndigena, boolean afrodescendiente, boolean semPasadTrabajo,
                   boolean semPasadChanga, boolean semPasadFalto, boolean cuatroSemBusco,
                   int hijosNacidos, int hijosVivos, LocalDate fechaNacUltimoHijo) {

        this.nombe = nombe;
        this.apellido = apellido;
        this.nroDni = nroDni;
        RelacionReferencia = relacionReferencia;
        Discapacidad = discapacidad;
        Sexo = sexo;
        Genero = genero;
        FechaNacimiento = fechaNacimiento;
        Cursa = cursa;
        Nivel = nivel;
        GradoAnioActual = gradoAnioActual;
        Asistio = asistio;
        NivelMayor = nivelMayor;
        CompletoNievelMayot = completoNievelMayot;
        CantAprobados = cantAprobados;
        NacimientoProvincia = nacimientoProvincia;
        NacimientoPais = nacimientoPais;
        AnioLlegadaArg = anioLlegadaArg;
        ViviaHaceCincoAnios = viviaHaceCincoAnios;
        HaceCincoProvincia = haceCincoProvincia;
        CoberturaSalud = coberturaSalud;
        CobraJubOPen = cobraJubOPen;
        QueCobra = queCobra;
        Indigena = indigena;
        PuebloIndigina = puebloIndigina;
        HablaLenguaIndigena = hablaLenguaIndigena;
        Afrodescendiente = afrodescendiente;
        SemPasadTrabajo = semPasadTrabajo;
        SemPasadChanga = semPasadChanga;
        SemPasadFalto = semPasadFalto;
        CuatroSemBusco = cuatroSemBusco;
        HijosNacidos = hijosNacidos;
        HijosVivos = hijosVivos;
        FechaNacUltimoHijo = fechaNacUltimoHijo;
    }

    public String getNombe() {
        return nombe;
    }

    public void setNombe(String nombe) {
        this.nombe = nombe;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNroDni() {
        return nroDni;
    }

    public void setNroDni(String nroDni) {
        this.nroDni = nroDni;
    }

    public String getRelacionReferencia() {
        return RelacionReferencia;
    }

    public void setRelacionReferencia(String relacionReferencia) {
        RelacionReferencia = relacionReferencia;
    }

    public boolean isDiscapacidad() {
        return Discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        Discapacidad = discapacidad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public boolean getCursa() {
        return Cursa;
    }

    public void setCursa(boolean cursa) {
        Cursa = cursa;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getGradoAnioActual() {
        return GradoAnioActual;
    }

    public void setGradoAnioActual(String gradoAnioActual) {
        GradoAnioActual = gradoAnioActual;
    }

    public boolean isAsistio() {
        return Asistio;
    }

    public void setAsistio(boolean asistio) {
        Asistio = asistio;
    }

    public String getNivelMayor() {
        return NivelMayor;
    }

    public void setNivelMayor(String nivelMayor) {
        NivelMayor = nivelMayor;
    }

    public boolean isCompletoNievelMayot() {
        return CompletoNievelMayot;
    }

    public void setCompletoNievelMayot(boolean completoNievelMayot) {
        CompletoNievelMayot = completoNievelMayot;
    }

    public String getCantAprobados() {
        return CantAprobados;
    }

    public void setCantAprobados(String cantAprobados) {
        CantAprobados = cantAprobados;
    }

    public String getNacimientoProvincia() {
        return NacimientoProvincia;
    }

    public void setNacimientoProvincia(String nacimientoProvincia) {
        NacimientoProvincia = nacimientoProvincia;
    }

    public String getNacimientoPais() {
        return NacimientoPais;
    }

    public void setNacimientoPais(String nacimientoPais) {
        NacimientoPais = nacimientoPais;
    }

    public int getAnioLlegadaArg() {
        return AnioLlegadaArg;
    }

    public void setAnioLlegadaArg(int anioLlegadaArg) {
        AnioLlegadaArg = anioLlegadaArg;
    }

    public String getViviaHaceCincoAnios() {
        return ViviaHaceCincoAnios;
    }

    public void setViviaHaceCincoAnios(String viviaHaceCincoAnios) {
        ViviaHaceCincoAnios = viviaHaceCincoAnios;
    }

    public String getHaceCincoProvincia() {
        return HaceCincoProvincia;
    }

    public void setHaceCincoProvincia(String haceCincoProvincia) {
        HaceCincoProvincia = haceCincoProvincia;
    }

    public String getCoberturaSalud() {
        return CoberturaSalud;
    }

    public void setCoberturaSalud(String coberturaSalud) {
        CoberturaSalud = coberturaSalud;
    }

    public boolean isCobraJubOPen() {
        return CobraJubOPen;
    }

    public void setCobraJubOPen(boolean cobraJubOPen) {
        CobraJubOPen = cobraJubOPen;
    }

    public String getQueCobra() {
        return QueCobra;
    }

    public void setQueCobra(String queCobra) {
        QueCobra = queCobra;
    }

    public boolean isIndigena() {
        return Indigena;
    }

    public void setIndigena(boolean indigena) {
        Indigena = indigena;
    }

    public String getPuebloIndigina() {
        return PuebloIndigina;
    }

    public void setPuebloIndigina(String puebloIndigina) {
        PuebloIndigina = puebloIndigina;
    }

    public boolean isHablaLenguaIndigena() {
        return HablaLenguaIndigena;
    }

    public void setHablaLenguaIndigena(boolean hablaLenguaIndigena) {
        HablaLenguaIndigena = hablaLenguaIndigena;
    }

    public boolean isAfrodescendiente() {
        return Afrodescendiente;
    }

    public void setAfrodescendiente(boolean afrodescendiente) {
        Afrodescendiente = afrodescendiente;
    }

    public boolean isSemPasadTrabajo() {
        return SemPasadTrabajo;
    }

    public void setSemPasadTrabajo(boolean semPasadTrabajo) {
        SemPasadTrabajo = semPasadTrabajo;
    }

    public boolean isSemPasadChanga() {
        return SemPasadChanga;
    }

    public void setSemPasadChanga(boolean semPasadChanga) {
        SemPasadChanga = semPasadChanga;
    }

    public boolean isSemPasadFalto() {
        return SemPasadFalto;
    }

    public void setSemPasadFalto(boolean semPasadFalto) {
        SemPasadFalto = semPasadFalto;
    }

    public boolean isCuatroSemBusco() {
        return CuatroSemBusco;
    }

    public void setCuatroSemBusco(boolean cuatroSemBusco) {
        CuatroSemBusco = cuatroSemBusco;
    }

    public int getHijosNacidos() {
        return HijosNacidos;
    }

    public void setHijosNacidos(int hijosNacidos) {
        HijosNacidos = hijosNacidos;
    }

    public int getHijosVivos() {
        return HijosVivos;
    }

    public void setHijosVivos(int hijosVivos) {
        HijosVivos = hijosVivos;
    }

    public LocalDate getFechaNacUltimoHijo() {
        return FechaNacUltimoHijo;
    }

    public void setFechaNacUltimoHijo(LocalDate fechaNacUltimoHijo) {
        FechaNacUltimoHijo = fechaNacUltimoHijo;
    }
}

