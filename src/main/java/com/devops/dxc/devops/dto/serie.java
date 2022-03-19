package com.devops.dxc.devops.dto;

public class serie {
    
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

   
}
