/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import alasUCU.ClaseAuxiliar;
import codigoGrafos.TCamino;
import codigoGrafos.TGrafoDirigido;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juanma
 */
public class TestsPrueba {
    TGrafoDirigido gd;
    
    public TestsPrueba() {
        try { 
            gd = ClaseAuxiliar.cargarGrafo(ClaseAuxiliar.cargarAeropuertos("src/alasUCU/PruebaAero1.txt"),
                                       ClaseAuxiliar.cargarVuelos("src/alasUCU/PruebaVuelo1.txt"), TGrafoDirigido.class);
        } catch (ParseException exc) {
            exc.printStackTrace();
        }                                   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCaminoMasRapido() {
        Calendar myCal = Calendar.getInstance();
        myCal.set(2016, 00, 01, 12, 00, 00);
        Date theDate = myCal.getTime();
        TCamino cam = gd.todosLosCaminos("MVD","SAL",theDate).menosTiempoDeVuelo();
        Double obtenido = cam.getTiempoTotalVuelo();
        Double esperado = 5.0;
        assertEquals(obtenido,esperado);
    }
    
    @Test 
    public void testCaminoMenosCosto() {
        Calendar myCal = Calendar.getInstance();
        myCal.set(2016, 00, 01, 12, 00, 00);
        Date theDate = myCal.getTime();
        TCamino cam = gd.todosLosCaminos("MVD","SAL",theDate).caminoMasBarato();
        Double obtenido = cam.getCostoTotal();
        Double esperado = 1.0;
        assertEquals(obtenido,esperado);   
    }
        
}
   

