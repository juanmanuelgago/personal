/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasUCU;
import java.util.*;
import codigoGrafos.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanma
 */
public class ClaseAuxiliar {
    
    /**
     * Metodo propio de la clase, encargado de cargar la informacion de los aeropuertos 
     * contenida en el archivo que se recibe como parametro
     * @param archivo
     * @return Lista enlazada con vertices
     */
    
    public static LinkedList<TVertice> cargarAeropuertos(String archivo) {
        LinkedList<TVertice> lista = new LinkedList<>();
        String[] lineasArchivo_Aeropuertos = ManejadorArchivosGenerico.leerArchivo(archivo, true);
        for (int i = 0; i < lineasArchivo_Aeropuertos.length; i++) {
            String[] datos_Aero = lineasArchivo_Aeropuertos[i].split(";");
            Aeropuerto air = new Aeropuerto((Comparable) datos_Aero[0],
                                                datos_Aero[1], 
                                                datos_Aero[2], 
                                                datos_Aero[3], 
                                                datos_Aero[5],
                                                datos_Aero[6], 
                                                datos_Aero[7], 
                                                Double.parseDouble(datos_Aero[8]), 
                                                Double.parseDouble(datos_Aero[9]),
                                                datos_Aero[10].charAt(0), 
                                                datos_Aero[11]);
            TVertice v = new TVertice(datos_Aero[4], air);
            lista.add(v);
        }
        return lista;
    }
    
    /**
     * Metodo propio de la clase, encargado de cargar la informacion de los vuelos 
     * contenida en el archivo que se recibe como parametro
     * @param archivo
     * @return Lista enlazada de aristas
     * @throws ParseException 
     */
    
    public static LinkedList<TArista> cargarVuelos(String archivo) throws ParseException {
        try {
            LinkedList<TArista> lista = new LinkedList<>();
            String[] lineasArchivo_Vuelos = ManejadorArchivosGenerico.leerArchivo(archivo, true);
            for (int i = 0; i < lineasArchivo_Vuelos.length; i++) {
                String[] datos_Vuelo = lineasArchivo_Vuelos[i].split(",");
                String fechaSalida = datos_Vuelo[3];
                String fechaLlegada = datos_Vuelo[4];
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");           
                Date date1 = formatter.parse(fechaSalida);
                Date date2 = formatter.parse(fechaLlegada);
                Vuelo fly = new Vuelo(date1,date2);
                TArista arist = new TArista(datos_Vuelo[0],datos_Vuelo[1],Double.parseDouble(datos_Vuelo[2]),fly);
                lista.add(arist); 
            }
            return lista;
        }
        catch (ParseException exc) {
            exc.printStackTrace();
        }
        return null;
    }
    
    /**
     * Metodo encargado de generar el grafo correspondiente segun las listas enlazadas
     * recibidas como parametro
     * @param <T>
     * @param aeropuertos
     * @param vuelos
     * @param t
     * @return Grafo dirigido correspondiente
     */
    
    public static <T extends IGrafoDirigido> T cargarGrafo(LinkedList<TVertice >aeropuertos, LinkedList<TArista> vuelos, Class t) {
        try {
            return (T) (t.getConstructor(Collection.class, Collection.class).newInstance(aeropuertos, vuelos));            
        } catch (Exception ex) {
            Logger.getLogger(UtilGrafos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null; 
    }
    
    
}


