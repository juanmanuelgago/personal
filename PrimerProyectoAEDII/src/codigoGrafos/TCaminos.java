package codigoGrafos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Juanma
 */
public class TCaminos {
    
    private Collection<TCamino> caminos;

    /**
     * Constructuror del objeto TCaminos
     */
    
    public TCaminos() {
        this.caminos = new LinkedList<>();
    }
    
    /**
     * Devuelve cada uno de los caminos almacencados con sus etiquetas ordenadas
     * @return String con las etiquetas ordenadas
     */
    
    public String imprimirCaminos(){
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos){
            sb.append(camino.imprimirEtiquetas()+"\n");
        }
        return sb.toString();
    }

    /**
     * Imprime en consola cada uno de los caminos contenidos
     */
    
    public void imprimirCaminosConsola(){
        System.out.println(imprimirCaminos());
    }

    /**
     * Devuelve la coleccion de caminos almacenados
     * @return Coleccion de caminos
     */
    
    public Collection<TCamino> getCaminos() {
        return caminos;
    }
    
    /**
     * Devuelve el camino cuyo costo sea el menor de todos
     * @return Camino mas barato
     */
    
    public TCamino caminoMasBarato() {
        TCamino caminoBarato = null;
        double costoTemp = Double.POSITIVE_INFINITY;
        for (TCamino camino : this.getCaminos()) {
            if (camino.getCostoTotal() < costoTemp) {
                caminoBarato = camino;
                costoTemp = camino.getCostoTotal();
            }
        }
        return caminoBarato;
    }
    
    /**
     * Retorna el camino con el menor tiempo de vuelo (sin considerar tiempos de espera entre vuelos)
     * @return Camino con menor tiempo de vuelo
     */
    
    public TCamino menosTiempoDeVuelo() {
        TCamino caminoTemp = null;
        Double horasTemp = Double.POSITIVE_INFINITY;
        Double costoTemp = Double.POSITIVE_INFINITY;
        for (TCamino camino : this.getCaminos()){
            double time = camino.getTiempoTotalVuelo(); 
            double cost = camino.getCostoTotal();
            if(time < horasTemp){
                caminoTemp = camino;
                horasTemp = time;
                costoTemp = cost;
            }
            else{
                if (Double.compare(time,horasTemp) == 0 && cost < costoTemp){
                    caminoTemp = camino;
                    horasTemp = time;
                    costoTemp = cost;
                }
            }
        }
        return caminoTemp;
    }
}
