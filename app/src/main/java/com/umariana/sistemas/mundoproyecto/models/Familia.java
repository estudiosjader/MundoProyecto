package com.umariana.sistemas.mundoproyecto.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sistemas on 22/05/17.
 */

public class Familia {
    @SerializedName("nombre_del_resguardo")
    @Expose
    private String nombreDelResguardo;
    @SerializedName("nombre_del_gobenador_del_cabildo")
    @Expose
    private String nombreDelGobenadorDelCabildo;
    @SerializedName("pueblo_ind_gena")
    @Expose
    private String puebloIndGena;
    @SerializedName("nro")
    @Expose
    private String nro;
    @SerializedName("inspeccion_corregimiento_municipio")
    @Expose
    private String inspeccionCorregimientoMunicipio;
    @SerializedName("nombre_de_la_comunidad")
    @Expose
    private String nombreDeLaComunidad;
    @SerializedName("nro_hab")
    @Expose
    private String nroHab;

    public String getNombreDelResguardo() {
        return nombreDelResguardo;
    }

    public void setNombreDelResguardo(String nombreDelResguardo) {
        this.nombreDelResguardo = nombreDelResguardo;
    }

    public String getNombreDelGobenadorDelCabildo() {
        return nombreDelGobenadorDelCabildo;
    }

    public void setNombreDelGobenadorDelCabildo(String nombreDelGobenadorDelCabildo) {
        this.nombreDelGobenadorDelCabildo = nombreDelGobenadorDelCabildo;
    }

    public String getPuebloIndGena() {
        return puebloIndGena;
    }

    public void setPuebloIndGena(String puebloIndGena) {
        this.puebloIndGena = puebloIndGena;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getInspeccionCorregimientoMunicipio() {
        return inspeccionCorregimientoMunicipio;
    }

    public void setInspeccionCorregimientoMunicipio(String inspeccionCorregimientoMunicipio) {
        this.inspeccionCorregimientoMunicipio = inspeccionCorregimientoMunicipio;
    }

    public String getNombreDeLaComunidad() {
        return nombreDeLaComunidad;
    }

    public void setNombreDeLaComunidad(String nombreDeLaComunidad) {
        this.nombreDeLaComunidad = nombreDeLaComunidad;
    }

    public String getNroHab() {
        return nroHab;
    }

    public void setNroHab(String nroHab) {
        this.nroHab = nroHab;
    }

}

