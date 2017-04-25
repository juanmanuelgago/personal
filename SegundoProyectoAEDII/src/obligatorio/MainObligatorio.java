/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

import codigoClasificacion.GeneradorDatosGenericos;
import codigoClasificacion.Mediciones;
import codigoClasificacion.TClasificador;
import java.util.Arrays;

/**
 *
 * @author Juanma
 */
public class MainObligatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Inicializacion de los elementos necesarios para medir los metodos y
         * de los vectores con sus distintas ordenaciones.
         */

        GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
        Mediciones mediciones = new Mediciones();

        int[] datos_Aleatorios = generador.generarDatosAleatorios();
        int[] datos_Ascendentes = generador.generarDatosAscendentes();
        int[] datos_Descendentes = generador.generarDatosDescendentes();

        /**
         * Codigo de prueba para Insercion Directa 
         */
        
        System.out.println("********************INSERCION DIRECTA********************");
        long tiempo_InsercionDirectaAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_INSERCION);
        long tiempo_InsercionDirectaAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_INSERCION);
        long tiempo_InsercionDirectaDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_INSERCION);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("Insercion Directa Aleatoria -> " + tiempo_InsercionDirectaAleatorio);
        System.out.println("Insercion Directa Ascendente -> " + tiempo_InsercionDirectaAscendente);
        System.out.println("Insercion Directa Descendente -> " + tiempo_InsercionDirectaDescendente);
        
        System.out.println(" ");
        
        /**
         * Codigo de prueba para BubbleSort / Burbuja
         */
        
        System.out.println("********************BURBUJA********************");
        long tiempo_BurbujaAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_BURBUJA);
        long tiempo_BurbujaAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_BURBUJA);
        long tiempo_BurbujaDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_BURBUJA);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("Burbuja Aleatoria -> " + tiempo_BurbujaAleatorio);
        System.out.println("Burbuja Ascendente -> " + tiempo_BurbujaAscendente);
        System.out.println("Burbuja Descendente -> " + tiempo_BurbujaDescendente);
        
        System.out.println(" ");
        
        /**
         * Codigo de prueba para QuickSort
         */
        
        System.out.println("********************QUICKSORT********************");
        long tiempo_QuickSortAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_QUICKSORT);
        long tiempo_QuickSortAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);
        long tiempo_QuickSortDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_QUICKSORT);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("QuickSort Aleatoria -> " + tiempo_QuickSortAleatorio);
        System.out.println("QuickSort Ascendente -> " + tiempo_QuickSortAscendente);
        System.out.println("QuickSort Descendente -> " + tiempo_QuickSortDescendente);
        
        System.out.println(" ");
        
        /**
         * Codigo de prueba para Seleccion Directa
         */
        
        System.out.println("********************SELECCION DIRECTA********************");
        long tiempo_SeleccionDirectaAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_SELECCION);
        long tiempo_SeleccionDirectaAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_SELECCION);
        long tiempo_SeleccionDirectaDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_SELECCION);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("Seleccion Directa Aleatoria -> " + tiempo_SeleccionDirectaAleatorio);
        System.out.println("Seleccion Directa Ascendente -> " + tiempo_SeleccionDirectaAscendente);
        System.out.println("Seleccion Directa Descendente -> " + tiempo_SeleccionDirectaDescendente);
        
        System.out.println(" ");
        
        /**
         * Codigo de prueba para HeapSort
         */
        
        System.out.println("********************HEAPSORT********************");
        long tiempo_HeapSortAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_HEAPSORT);
        long tiempo_HeapSortAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_HEAPSORT);
        long tiempo_HeapSortDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_HEAPSORT);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("HeapSort Aleatoria -> " + tiempo_HeapSortAleatorio);
        System.out.println("HeapSort Ascendente -> " + tiempo_HeapSortAscendente);
        System.out.println("HeapSort Descendente -> " + tiempo_HeapSortDescendente);
        
        System.out.println(" ");
               
        /**
         * Codigos de prueba de los metodos de ordenacion de JAVA
         * (Para estos casos, resulta imposible codificar un caso "cáscara"
         */

        System.out.println("********************SORT********************");
        long tiempo_sortAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_SORT);
        long tiempo_SortAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_SORT);
        long tiempo_SortDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_SORT);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("Sort Aleatoria -> " + tiempo_sortAleatorio);
        System.out.println("Sort Ascendente -> " + tiempo_SortAscendente);
        System.out.println("Sort Descendente -> " + tiempo_SortDescendente);
        
        System.out.println(" ");
        
        System.out.println("********************PARALLELSORT********************");
        long tiempo_parallelSortAleatorio = mediciones.medir(datos_Aleatorios, TClasificador.METODO_CLASIFICACION_PARALLELSORT);
        long tiempo_parallelSortAscendente = mediciones.medir(datos_Ascendentes, TClasificador.METODO_CLASIFICACION_PARALLELSORT);
        long tiempo_parallelSortDescendente = mediciones.medir(datos_Descendentes, TClasificador.METODO_CLASIFICACION_PARALLELSORT);

        System.out.println("-----------> Tiempos medidos");
        System.out.println("Sort Aleatoria -> " + tiempo_parallelSortAleatorio);
        System.out.println("Sort Ascendente -> " + tiempo_parallelSortAscendente);
        System.out.println("Sort Descendente -> " + tiempo_parallelSortDescendente);
        
        System.out.println(" ");
        
        
    }

}
