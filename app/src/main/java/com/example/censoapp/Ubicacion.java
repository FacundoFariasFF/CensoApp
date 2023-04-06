package com.example.censoapp;

public class Ubicacion {
    String codigo;
    String Pais;
    String provincia;
    String depParCom;
    String Localidad;
    String NomCalleRuta;
    int NroCalleKmRuta;
    int NroPiso;
    String Deparamtenro;
    String EdifMonobTira;
    String CasaLote;

    public Ubicacion(String codigo, String pais, String provincia, String depParCom, String localidad,
                     String nomCalleRuta, int nroCalleKmRuta, int nroPiso, String deparamtenro,
                     String edifMonobTira, String casaLote) {

        this.codigo = codigo;
        Pais = pais;
        this.provincia = provincia;
        this.depParCom = depParCom;
        Localidad = localidad;
        NomCalleRuta = nomCalleRuta;
        NroCalleKmRuta = nroCalleKmRuta;
        NroPiso = nroPiso;
        Deparamtenro = deparamtenro;
        EdifMonobTira = edifMonobTira;
        CasaLote = casaLote;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepParCom() {
        return depParCom;
    }

    public void setDepParCom(String depParCom) {
        this.depParCom = depParCom;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getNomCalleRuta() {
        return NomCalleRuta;
    }

    public void setNomCalleRuta(String nomCalleRuta) {
        NomCalleRuta = nomCalleRuta;
    }

    public int getNroCalleKmRuta() {
        return NroCalleKmRuta;
    }

    public void setNroCalleKmRuta(int nroCalleKmRuta) {
        NroCalleKmRuta = nroCalleKmRuta;
    }

    public int getNroPiso() {
        return NroPiso;
    }

    public void setNroPiso(int nroPiso) {
        NroPiso = nroPiso;
    }

    public String getDeparamtenro() {
        return Deparamtenro;
    }

    public void setDeparamtenro(String deparamtenro) {
        Deparamtenro = deparamtenro;
    }

    public String getEdifMonobTira() {
        return EdifMonobTira;
    }

    public void setEdifMonobTira(String edifMonobTira) {
        EdifMonobTira = edifMonobTira;
    }

    public String getCasaLote() {
        return CasaLote;
    }

    public void setCasaLote(String casaLote) {
        CasaLote = casaLote;
    }
}

