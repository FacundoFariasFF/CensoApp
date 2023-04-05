package com.example.censoapp;

public class Vivienda {
    String codigo;
    String tipo;
    String materialPisos;
    String materialTecho;
    Boolean revestimiento;
    String aguaPotable;
    String origenAgua;
    String banioUbicacion;
    int cantBanios;
    String banio;
    String desague;
    String cocinaCombustible;
    int cantAmbientes;
    int cantAmbientesDormir;
    String situacion;
    String documentacion;
    String conectividad;

    public Vivienda(String codigo, String tipo, String materialPisos, String materialTecho,
                    Boolean revestimiento, String aguaPotable, String origenAgua, String banioUbicacion,
                    int cantBanios, String banio, String desague, String cocinaCombustible,
                    int cantAmbientes, int cantAmbientesDormir, String situacion, String documentacion,
                    String conectividad) {
        
        this.codigo = codigo;
        this.tipo = tipo;
        this.materialPisos = materialPisos;
        this.materialTecho = materialTecho;
        this.revestimiento = revestimiento;
        this.aguaPotable = aguaPotable;
        this.origenAgua = origenAgua;
        this.banioUbicacion = banioUbicacion;
        this.cantBanios = cantBanios;
        this.banio = banio;
        this.desague = desague;
        this.cocinaCombustible = cocinaCombustible;
        this.cantAmbientes = cantAmbientes;
        this.cantAmbientesDormir = cantAmbientesDormir;
        this.situacion = situacion;
        this.documentacion = documentacion;
        this.conectividad = conectividad;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterialPisos() {
        return materialPisos;
    }

    public void setMaterialPisos(String materialPisos) {
        this.materialPisos = materialPisos;
    }

    public String getMaterialTecho() {
        return materialTecho;
    }

    public void setMaterialTecho(String materialTecho) {
        this.materialTecho = materialTecho;
    }

    public Boolean getRevestimiento() {
        return revestimiento;
    }

    public void setRevestimiento(Boolean revestimiento) {
        this.revestimiento = revestimiento;
    }

    public String getAguaPotable() {
        return aguaPotable;
    }

    public void setAguaPotable(String aguaPotable) {
        this.aguaPotable = aguaPotable;
    }

    public String getOrigenAgua() {
        return origenAgua;
    }

    public void setOrigenAgua(String origenAgua) {
        this.origenAgua = origenAgua;
    }

    public String getBanioUbicacion() {
        return banioUbicacion;
    }

    public void setBanioUbicacion(String banioUbicacion) {
        this.banioUbicacion = banioUbicacion;
    }

    public int getCantBanios() {
        return cantBanios;
    }

    public void setCantBanios(int cantBanios) {
        this.cantBanios = cantBanios;
    }

    public String getBanio() {
        return banio;
    }

    public void setBanio(String banio) {
        this.banio = banio;
    }

    public String getDesague() {
        return desague;
    }

    public void setDesague(String desague) {
        this.desague = desague;
    }

    public String getCocinaCombustible() {
        return cocinaCombustible;
    }

    public void setCocinaCombustible(String cocinaCombustible) {
        this.cocinaCombustible = cocinaCombustible;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public int getCantAmbientesDormir() {
        return cantAmbientesDormir;
    }

    public void setCantAmbientesDormir(int cantAmbientesDormir) {
        this.cantAmbientesDormir = cantAmbientesDormir;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
    }
}

