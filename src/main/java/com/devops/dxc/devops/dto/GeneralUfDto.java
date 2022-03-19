package com.devops.dxc.devops.dto;

import java.io.Serializable;
import java.util.List;


public class GeneralUfDto implements Serializable{

    private static final long serialVersionUID = 2405172041950251807L;
    private String version;
    private String autor;
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private List<serie> serie;

    
    public GeneralUfDto() {
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUnidad_medida() {
        return unidad_medida;
    }
    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }



    public List<serie> getSerie() {
        return serie;
    }

    public void setSerie(List<serie> serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "GeneralUfDto [autor=" + autor + ", codigo=" + codigo + ", nombre=" + nombre + ", serie=" + serie
                + ", unidad_medida=" + unidad_medida + ", version=" + version + "]";
    }

    
}
