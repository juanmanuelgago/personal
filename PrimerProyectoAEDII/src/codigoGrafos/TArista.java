package codigoGrafos;

import alasUCU.Vuelo;

/**
 * 
 * @author Juanma
 */

public class TArista implements IArista {

    protected Comparable etiquetaOrigen;
    protected Comparable etiquetaDestino;
    protected double costo;
    protected Vuelo datos_Vuelo;

    /**
     * Constructor del objeto TArista
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param costo
     * @param datos_Vuelo 
     */
    
    public TArista(Comparable etiquetaOrigen, Comparable etiquetaDestino, double costo, Vuelo datos_Vuelo) {
        this.etiquetaOrigen = etiquetaOrigen;
        this.etiquetaDestino = etiquetaDestino;
        this.costo = costo;
        this.datos_Vuelo = datos_Vuelo;
    }
    
    /**
     * Devuelve la etiqueta del origen de la arista
     * @return Etiqueta del vertice origen de la arista
     */
    
    @Override
    public Comparable getEtiquetaOrigen() {
        return etiquetaOrigen;
    }

    /**
     * Setea la etiqueta del origen de la arista
     * @param etiquetaOrigen 
     */
    
    @Override
    public void setEtiquetaOrigen(Comparable etiquetaOrigen) {
        this.etiquetaOrigen = etiquetaOrigen;
    }

    /**
     * Retorna la etiqueta del destino de la arista
     * @return Etiqueta del vertice destino de la arista
     */
    
    @Override
    public Comparable getEtiquetaDestino() {
        return etiquetaDestino;
    }

    /**
     * Setea la etiqueta del destino de la arista
     * @param etiquetaDestino 
     */
    
    @Override
    public void setEtiquetaDestino(Comparable etiquetaDestino) {
        this.etiquetaDestino = etiquetaDestino;
    }

    /**
     * Devuelve el costo que tiene la arista
     * @return Costo de la arista
     */
    
    @Override
    public double getCosto() {
        return costo;
    }

    /**
     * Setea el costo de la arista
     * @param costo 
     */
    
    @Override
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    /**
     * Metodo que construye una nueva arista con sentido inverso
     * @return Arista con origen y destino intercambiados 
     */
    
    public TArista aristaInversa (){
        return new TArista(this.getEtiquetaDestino(), this.getEtiquetaOrigen(),this.getCosto(),this.getDatos());
    }

    /**
     * Devuelve los datos correspondientes al vuelo
     * @return Datos del vuelo
     */
    
    @Override
    public Vuelo getDatos() {
        return datos_Vuelo;
    }

    /**
     * Setea los datos del vuelo
     * @param datos_Vuelo 
     */
    
    @Override
    public void setDatos(Vuelo datos_Vuelo) {
        this.datos_Vuelo = datos_Vuelo;
    }

    
}
