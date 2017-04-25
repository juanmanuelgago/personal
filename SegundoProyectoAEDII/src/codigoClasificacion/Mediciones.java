/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoClasificacion;

import java.util.Arrays;

/**
 *
 * @author DANIEL
 */
public class Mediciones {

    public long TIEMPO_RESOLUCION = 1000000000;
    public TClasificador clasificador = new TClasificador();

    public long medir(int[] vectorOriginal, int metodoClasificacion) {
        long t1 = System.nanoTime();
        long total = 0l;
        int cantLlamadas = 0;
        while (total < TIEMPO_RESOLUCION) {
            cantLlamadas += 1;
            int[] datosCopia = vectorOriginal.clone();
            clasificador.clasificar(datosCopia, metodoClasificacion, false);
            long t2 = System.nanoTime();
            total = t2 - t1;

        }
        long tiempMedAlgBase = total / cantLlamadas;

        long t3 = System.nanoTime();
        long total2 = 0l;
        int cantLlamadas2 = 0;
        while (total2 < TIEMPO_RESOLUCION) {
            cantLlamadas2 += 1;
            int[] datosCopia = vectorOriginal.clone();
            clasificador.clasificar(datosCopia, metodoClasificacion, true);
            long t4 = System.nanoTime();
            total2 = t4 - t3;

        }
        long tiempMedCascara = total2 / cantLlamadas2;

        return tiempMedAlgBase - tiempMedCascara;
    }
    
    
    
}
