/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author David
 */
public class Asiento {
    int idVuelo,precioFinalBillete; 
    String idAsiento,fila,tipo,bloque,comprador;

    public Asiento(int idVuelo, int precioFinalBillete, String idAsiento, String fila, String tipo, String bloque, String comprador) {
        this.idVuelo = idVuelo;
        this.precioFinalBillete = precioFinalBillete;
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.tipo = tipo;
        this.bloque = bloque;
        this.comprador = comprador;
    }

    public Asiento() {
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getPrecioFinalBillete() {
        return precioFinalBillete;
    }

    public void setPrecioFinalBillete(int precioFinalBillete) {
        this.precioFinalBillete = precioFinalBillete;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    

 
}
