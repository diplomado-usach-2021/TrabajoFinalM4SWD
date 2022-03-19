package com.devops.dxc.devops.dto;

import java.io.Serializable;

public class serie implements Serializable{
    

    private static final long serialVersionUID = 2405172041950251807L;

   private String fecha;
   private String valor;


   
public serie(String fecha, String valor) {
    this.fecha = fecha;
    this.valor = valor;
}
public serie() {
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
    this.fecha = fecha;
}
public String getValor() {
    return valor;
}
public void setValor(String valor) {
    this.valor = valor;
}
@Override
public String toString() {
    return "serie [fecha=" + fecha + ", valor=" + valor + "]";
}

   
}
