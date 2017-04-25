/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasUCU;

import java.util.Date;

/**
 *
 * @author Juanma
 */
public class Vuelo {
    
    private Date fechaHora_Salida;
    private Date fechaHora_Llegada;

    /**
     * Constructor del objeto Vuelo
     * @param fechaSalida
     * @param fechaLlegada 
     */
    
    public Vuelo(Date fechaSalida, Date fechaLlegada) {
        fechaHora_Salida = fechaSalida;
        fechaHora_Llegada = fechaLlegada;
    }

    /**
     * Devuelve la fecha de salida del vuelo desde el origen
     * @return Fecha con la hora de despegue
     */
    
    public Date getFechaHora_Salida() {
        return fechaHora_Salida;
    }

    /**
     * Setea la fecha de salida del vuelo
     * @param fechaHora_Salida 
     */
    
    public void setFechaHora_Salida(Date fechaHora_Salida) {
        this.fechaHora_Salida = fechaHora_Salida;
    }

    /**
     * Devuelve la fecha de llegada del vuelo a destino
     * @return Fecha con la llegada del vuelo estimada
     */
    
    public Date getFechaHora_Llegada() {
        return fechaHora_Llegada;
    }

    /**
     * Setea la fecha de llegada del vuelo a destino
     * @param fechaHora_Llegada 
     */
    
    public void setFechaHora_Llegada(Date fechaHora_Llegada) {
        this.fechaHora_Llegada = fechaHora_Llegada;
    }
}
