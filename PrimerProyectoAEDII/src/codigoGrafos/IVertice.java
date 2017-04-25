package codigoGrafos;


import alasUCU.Aeropuerto;
import alasUCU.Vuelo;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernesto
 */
public interface IVertice {

    TAdyacencia buscarAdyacencia(TVertice verticeDestino);

    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    LinkedList<TAdyacencia> getAdyacentes();

    Aeropuerto getDatos();
    
    void setDatos(Aeropuerto datos);

    Comparable getEtiqueta();

    boolean getVisitado();

    boolean insertarAdyacencia(Double costo, TVertice verticeDestino, Vuelo datos);

    Double obtenerCostoAdyacencia(TVertice verticeDestino);

    TVertice primerAdyacente();

    void setVisitado(boolean valor);

   public void bpf(Collection<Comparable> visitados) ;

   public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos, Date fecha);
   
   public boolean tieneCiclo(TCamino camino);
   
   
}
