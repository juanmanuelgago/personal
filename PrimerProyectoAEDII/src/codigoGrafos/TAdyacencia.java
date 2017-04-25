package codigoGrafos;

import alasUCU.Vuelo;

/**
 * 
 * @author Juanma
 */

public class TAdyacencia implements IAdyacencia {
    
    private Comparable etiqueta;
    private double costo;
    private TVertice destino;
    private Vuelo datos_Vuelo;
    
    /**
     * Devuelve la etiqueta del destino de la adyacencia
     * @return Etiqueta del destino
     */
    
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
 
    /**
     * Devuelve el costo que tiene la adyacencia
     * @return Costo de la adyacencia
     */
    
    @Override
    public double getCosto() {
        return costo;
    }

    /**
     * Retorna el vertice destino de la adyacencia
     * @return Vertice destino
     */
    
    @Override
    public TVertice getDestino() {
        return destino;
    }

    /**
     * Constructor del objeto TAdyacencia
     * @param costo
     * @param destino
     * @param vuelo 
     */
   
    public TAdyacencia(double costo, TVertice destino, Vuelo vuelo) {
        this.etiqueta = destino.getEtiqueta();
        this.costo = costo;
        this.destino = destino;
        datos_Vuelo = vuelo;
    }

    /**
     * Devuelve los datos correspondientes al vuelo
     * @return Datos del vuelo
     */
    
    public Vuelo getDatos_Vuelo() {
        return datos_Vuelo;
    }

    /**
     * Setea los datos correspondientes al vuelo
     * @param datos_Vuelo 
     */
    
    public void setDatos_Vuelo(Vuelo datos_Vuelo) {
        this.datos_Vuelo = datos_Vuelo;
    }
    
    /**
     * Metodo encargado de calcular el tiempo en horas que demora el vuelo contenido dentro
     * de la adyacencia
     * @return Tiempo de vuelo
     */
    
    public double tiempoDeVuelo() {
        long difference = this.getDatos_Vuelo().getFechaHora_Llegada().getTime() - this.getDatos_Vuelo().getFechaHora_Salida().getTime();
        long tempHoras = difference / 3600000;
        double tempMin = (double) (difference / 60000) % 60; 
        tempMin = tempMin / 60;
        double result = tempHoras + tempMin;
        return result;
    }
}
