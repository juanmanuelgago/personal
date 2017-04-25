package codigoClasificacion;

import java.util.Arrays;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_SELECCION = 5;
    public static final int METODO_CLASIFICACION_HEAPSORT = 6;
    public static final int METODO_CLASIFICACION_SORT = 7;
    public static final int METODO_CLASIFICACION_PARALLELSORT = 8;

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param cascara
     * @param datosParaClasificar
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        if (!cascara) { 
            switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                ordernarPorQuicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
                return datosParaClasificar;
            case METODO_CLASIFICACION_SELECCION:
                ordenarPorSeleccion(datosParaClasificar);
                return datosParaClasificar;
            case METODO_CLASIFICACION_HEAPSORT:
                ordenarPorHeapSort(datosParaClasificar);
                return datosParaClasificar;
            case METODO_CLASIFICACION_SORT:
                ordenarPorSort(datosParaClasificar);
                return datosParaClasificar;
            case METODO_CLASIFICACION_PARALLELSORT:
                ordenarPorParallelSort(datosParaClasificar);
                return datosParaClasificar;
            default:
                System.err.println("Este código no debería haberse ejecutado");
                break;
        }
        return datosParaClasificar;     
        }
        else {
            return ordenarPorCascara(datosParaClasificar);
        }
    }

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */


    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
        for (int k = incrementos.length - 1; k >= 0; k--) {
            int h = incrementos[k];
            if (datosParaClasificar != null) {
                for (int i = 1; i < datosParaClasificar.length; i++) {
                    int aux = datosParaClasificar[i];
                    int j = i - h;
                    while ((j >= 0) && (aux < datosParaClasificar[j])) {
                        datosParaClasificar[j + h] = datosParaClasificar[j];
                        j = j - h;
                    }
                    datosParaClasificar[j + h] = aux;
                }
                return datosParaClasificar;
            }
            return null;
        }
        return datosParaClasificar;
    }

    public int[] ordenarPorCascara(int[] datosParaClasificar) {
        return datosParaClasificar;
    }
    
    /**
     * @param datosParaClasificar
     * @return
     */
//    private int[] ordenarPorShellCascara(int[] datosParaClasificar) {
//        return datosParaClasificar;
//    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int aux = datosParaClasificar[i];
                int j = i - 1;
                while ((j >= 0) && (aux < datosParaClasificar[j])) {
                    datosParaClasificar[j + 1] = datosParaClasificar[j];
                    j--;
                }
                datosParaClasificar[j + 1] = aux;
            }
            return datosParaClasificar;
        }
        return null;
    }

    /**
     * @param datosParaClasificar
     * @return
     */


    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int referencia = 0;
        boolean bandera = true;
        while (bandera == true) {
            referencia++;
            bandera = false;
            for (int i = 0; i < datosParaClasificar.length - referencia; i++) {
                if (datosParaClasificar[i] > datosParaClasificar[i + 1]) {
                    bandera = true;
                    intercambiar(datosParaClasificar, i, i + 1);
                }
            }
        }
        return datosParaClasificar;
    }

    public void ordernarPorQuicksort(int[] datosParaClasificar, int i, int j) {
        int indicePivote = encuentraPivote(datosParaClasificar, i, j);
        if (indicePivote != -1) {
            int k = particion(datosParaClasificar, i, j, indicePivote);
            ordernarPorQuicksort(datosParaClasificar, i, k - 1);
            ordernarPorQuicksort(datosParaClasificar, k, j);
        }
    }

    private int encuentraPivote(int[] datos, int l, int r) {
        if (l == r) {
            return -1;
        }
        if (datos[(l + r) / 2] > datos[((l + r) / 2) + 1]) {
            return (l + r) / 2;
        } else {
            return ((l + r) / 2) + 1;
        }
    }

    private int particion(int[] datosParaClasificar, int i, int j, int indicePivote) {
        int pivote = datosParaClasificar[indicePivote];
        int l = i;
        int r = j;
        while (r >= l) {
            int aux = datosParaClasificar[l];
            datosParaClasificar[l] = datosParaClasificar[r];
            datosParaClasificar[r] = aux;
            while (datosParaClasificar[l] < pivote) {
                l += 1;
            }
            while (datosParaClasificar[r] >= pivote) {
                r -= 1;
            }
        }
        return l;
    }

    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length; i++) {
            int indiceDelMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < claveMenor) {
                    indiceDelMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceDelMenor);
        }
        return datosParaClasificar;
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        //error
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) {
                    //r tiene un hijo solo
                    if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                        //error
                        r = 2 * r;
                    } else {
                        r = ultimo;
                    }
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] > datosParaClasificar[2 * r + 1]) {
                        //error
                        posicionIntercambio = 2 * r;
                    } else {
                        //error
                        posicionIntercambio = 2 * r + 1;
                    }
                    if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }

    public void ordenarPorSort(int[] datosParaClasificar) {
        Arrays.sort(datosParaClasificar);
    }

    public void ordenarPorParallelSort(int[] datosParaClasificar) {
        Arrays.parallelSort(datosParaClasificar);
    }

}
