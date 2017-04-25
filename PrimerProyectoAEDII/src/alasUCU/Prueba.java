/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasUCU;

import codigoGrafos.TCamino;
import codigoGrafos.TCaminos;
import codigoGrafos.TGrafoDirigido;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Juanma
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        try {
            //AL PARECER ANDA TODO
//            TGrafoDirigido gd = ClaseAuxiliar.cargarGrafo(
//                    ClaseAuxiliar.cargarAeropuertos("src/alasUCU/PruebaAero.txt"),
//                    ClaseAuxiliar.cargarVuelos("src/alasUCU/PruebaVuelo.txt"), TGrafoDirigido.class);
//
            TGrafoDirigido gd1 = ClaseAuxiliar.cargarGrafo(
                    ClaseAuxiliar.cargarAeropuertos("src/alasUCU/PruebaAero1.txt"),
                    ClaseAuxiliar.cargarVuelos("src/alasUCU/PruebaVuelo1.txt"), TGrafoDirigido.class);
//
//            TGrafoDirigido gdPrueba = ClaseAuxiliar.cargarGrafo(
//                    ClaseAuxiliar.cargarAeropuertos("src/alasUCU/aeropuertos.csv"),
//                    ClaseAuxiliar.cargarVuelos("src/alasUCU/vuelos.csv"), TGrafoDirigido.class);

//            TCaminos caminos = gd1.metodo("MVD","SAL");
//            for (TCamino cam : caminos.getCaminos()) {
//                cam.imprimirEtiquetasConsola();
//                System.out.println(cam.getCostoTotal());
//            }
//            
//            System.out.println("////////");
//            TCamino camMin = caminos.caminoMasBarato();
//            TCamino camMin2 = caminos.menosTiempoDeVuelo();
//            System.out.println("CAMINO MAS BARATO");
//            camMin.imprimirEtiquetasConsola();
//            System.out.println("COSTO: " + camMin.getCostoTotal() + ", TIEMPO TOTAL DE VUELO: " + camMin.getTiempoTotalVuelo());
//            System.out.println("-");
//            System.out.println("CAMINO MAS RAPIDO");
//            camMin2.imprimirEtiquetasConsola();
//            System.out.println("COSTO: " + camMin2.getCostoTotal() + ", TIEMPO TOTAL DE VUELO: " + camMin2.getTiempoTotalVuelo());
//            
//            Calendar myCal = Calendar.getInstance();
//            myCal.set(2016, 00, 01, 12, 00, 00);
//            Date theDate = myCal.getTime();
//            TCamino caminos1 = gd1.todosLosCaminos("MVD","PDE", theDate).caminoMasBarato();
//            System.out.println(caminos1.imprimirEtiquetas());
  
            Calendar myCal = Calendar.getInstance();
            myCal.set(2016, 00, 01, 12, 00, 00);
            Date theDate = myCal.getTime();
            TCaminos caminos = gd1.todosLosCaminos("MVD","SAL",theDate);
            for (TCamino cam : caminos.getCaminos()) {
                System.out.println(cam.getCostoTotal());
                System.out.println(cam.getTiempoTotalVuelo());
            }
            TCamino cam1 = caminos.caminoMasBarato();
            TCamino cam2 = caminos.menosTiempoDeVuelo();
            System.out.println("-");
            System.out.println("camino barato " + cam1.getCostoTotal());
            System.out.println("menos tiempo vuelo " + cam2.getTiempoTotalVuelo());
                    

            
//
//            for (int i = 0; i <= 2; i++) {
//                System.out.println("-------------");
//
//            }
//            TCaminos caminos2 = gd.metodo("SAL","BSA");
//            TCaminos todosCam2 = gd.todosLosCaminos("SAL","BSA");
//            for (TCamino cam : caminos2.getCaminos()) {
//                cam.imprimirEtiquetasConsola();
//                System.out.println(cam.getCostoTotal());
//            }
//            System.out.println("/////");
//            for (TCamino cam : todosCam2.getCaminos()) {
//                cam.imprimirEtiquetasConsola();
//                System.out.println(cam.getCostoTotal());
//            }
//            Calendar myCal = Calendar.getInstance();
//            myCal.set(2016, 9, 01, 12, 00, 00);
//            Date theDate = myCal.getTime();
//            TCaminos caminos = gdPrueba.metodo("YBC", "YQB", theDate);
//            
//            for (TCamino cam : caminos.getCaminos()) {
//                cam.imprimirEtiquetasConsola();
//                System.out.println(cam.getCostoTotal() + "," + cam.getTiempoTotalVuelo());
//            }
//
//            System.out.println("//////////");
//            System.out.println("CAMINO MAS BARATO");
//            TCamino cam = caminos.caminoMasBarato();
//            cam.imprimirEtiquetasConsola();
//            System.out.println("COSTO: " + cam.getCostoTotal() + ", TIEMPO DE VUELO: " + cam.getTiempoTotalVuelo());
//            System.out.println("//////////");
//            System.out.println("CAMINO MAS RAPIDO");
//            TCamino cam1 = caminos.menosTiempoDeVuelo();
//            cam1.imprimirEtiquetasConsola();
//            System.out.println("COSTO: " + cam1.getCostoTotal() + ", TIEMPO DE VUELO: " + cam1.getTiempoTotalVuelo());
//
        } catch (ParseException exc) {
            exc.printStackTrace();
        }
    }
}
