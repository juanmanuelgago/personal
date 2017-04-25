package codigoGrafos;

import alasUCU.Aeropuerto;
import alasUCU.Vuelo;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author Juanma
 */

public class TVertice implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Aeropuerto datos;
    private int numeracionBpf;
    private int numeracionTopologica;

    /**
     * Devuelve la etiqueta del vertice
     * @return etiqueta del vertice
     */
    
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Devuelve la coleccion de adyacencias del vertice
     * @return Lista Enlazada con las adyacencias correspondientes
     */
    
    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    /**
     * Constructor del objeto TVertice
     * @param unaEtiqueta
     * @param aero 
     */
    
    public TVertice(Comparable unaEtiqueta, Aeropuerto aero) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        numeracionBpf = -1;
        numeracionTopologica = 0;
        datos = aero;
    }

    /**
     * Setea la condicion de visita del vertice
     * @param valor 
     */
    
    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    /**
     * Devuelve la condicion de visita del vertice
     * @return True si fue visitado, False si no lo fue
     */
    
    @Override
    public boolean getVisitado() {
        return this.visitado;
    }

    /**
     * Devuelve la numeracion correspondiente al vertice, auxiliar para el reconocimiento de ciclos
     * @return numeracionBpf
     */
    
    public int getNumeracionBpf() {
        return numeracionBpf;
    }

    /**
     * Setea la numeracion correspondiente al vertice, auxiliar para el reconocimiento de ciclos
     * @param numeracionBpf 
     */
    
    public void setNumeracionBpf(int numeracionBpf) {
        this.numeracionBpf = numeracionBpf;
    }

    /**
     * Devuelve la adyecencia cuyo vertice destino es el pasado por parametro
     * @param verticeDestino
     * @return Adyacente con el vertice correspondiente si lo encuentra, Nulo si falla la busqueda
     */    
    
    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    /**
     * Metodo que devuelve el costo de la adyacencia cuyo vertice destino es el pasado por parametro
     * @param verticeDestino
     * @return Valor de tipo double si lo encuentra, o maximo valor valido en double si no
     */
    
    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }
    
    /**
     * Metodo encargado de insertar la adyacencia, en la lista de adyacentes del vertice
     * @param costo
     * @param verticeDestino
     * @param datos
     * @return True si la insercion fue exitosa, False en caso contrario
     */

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino, Vuelo datos) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino, datos);
            return adyacentes.add(ady);
        } else if (buscarAdyacenciaCosto(costo, verticeDestino.getEtiqueta())) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino, datos);
            return adyacentes.add(ady);
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar la adyacencia, cuyo vertice tiene como etiqueta el comparable pasado
     * por parametro
     * @param nomVerticeDestino
     * @return True si la eliminacion es correcta, False si no lo es
     */
    
    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    /**
     * Metodo que devuelve el primer adyacente del vertice, de su lista de adyacentes
     * @return Primer vertice adyacente
     */
    
    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    /**
     * Metodo que busca y devuelve la adyacencia cuyo vertice tiene la misma etiqueta
     * que la pasada por parametro
     * @param etiquetaDestino
     * @return Adyacencia con el vertice cuya etiqueta coincide con el parametro
     */
    
    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     * Metodo que busca y devuelve la adyacencia cuyo vertice tiene la misma etiqueta y el
     * mismo costo pasados como parametros 
     * @param costo
     * @param etiquetaDestino
     * @return Adyacencia con dicha informacion
     */
    
    public boolean buscarAdyacenciaCosto(double costo, Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if ((adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) && (Double.compare(adyacencia.getCosto(), costo) == 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Seteador de los datos pertinentes del aeropuerto
     * @param datos 
     */
    
    @Override
    public void setDatos(Aeropuerto datos) {
        this.datos = datos;
    }

    /**
     * Devuelve los datos del aeropuerto
     * @return Datos del aeropuerto
     */
    
    @Override
    public Aeropuerto getDatos() {
        return datos;
    }

    /**
     * Algoritmo recursivo en busqueda por profundidad desde el vertice para el cual
     * es llamado el metodo
     * @param visitados 
     */
    
    
    @Override
    public void bpf(Collection<Comparable> visitados) {
        setVisitado(true);
        visitados.add(this.getEtiqueta());
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }
    
    /**
     * Metodo que genera los caminos desde el vertice para el cual se llamo al metodo y el vertice pasado por
     * parametro, cuya fecha de salida del vuelo es la pasada por parametro. 
     * @param etVertDest
     * @param caminoPrevio
     * @param todosLosCaminos
     * @param fecha
     * @return Lista de caminos almacenados en un objeto de Tipo TCaminos
     */

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos, Date fecha) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (caminoPrevio.getOtrosVertices().isEmpty()) {
                    if (entreFechas(adyacencia.getDatos_Vuelo().getFechaHora_Salida(), fecha)) {
                        if (destino.getEtiqueta().equals(etVertDest)) {
                            TCamino copia = caminoPrevio.copiarConCosto();
                            copia.agregarAdyacencia(adyacencia);
                            todosLosCaminos.getCaminos().add(copia);
                        } else {
                            caminoPrevio.agregarAdyacencia(adyacencia);
                            destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos, fecha);
                            caminoPrevio.eliminarAdyacencia(adyacencia);
                        }
                    }
                } else {
                    Date d1 = caminoPrevio.getUltimoVuelo().getFechaHora_Llegada();
                    Date d2 = adyacencia.getDatos_Vuelo().getFechaHora_Salida();
                    if (fechasNoDisjuntas(d1, d2)) {
                        if (destino.getEtiqueta().equals(etVertDest)) {
                            TCamino copia = caminoPrevio.copiarConCosto();
                            copia.agregarAdyacencia(adyacencia);
                            todosLosCaminos.getCaminos().add(copia);
                        } else {
                            caminoPrevio.agregarAdyacencia(adyacencia);
                            destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos, fecha);
                            caminoPrevio.eliminarAdyacencia(adyacencia);
                        }
                    }
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    /**
     * Verifica que la primera fecha pasada por parametro sea antes que la segunda
     * @param d1
     * @param d2
     * @return True si lo es, False si no
     */
    
    public boolean fechasNoDisjuntas(Date d1, Date d2) {
        return d1.before(d2);
    }

    /**
     * Metodo auxiliar para la filtrar los caminos cuyo comienzo no sea en la fecha
     * estipulada y pasada por parametro en el metodo todosLosCaminos
     * @param fechaSalida
     * @param fechaParametro
     * @return True si la fecha de salida esta entre el comienzo y el fin del dia que se paso 
     * por parametro
     */
    
    public boolean entreFechas(Date fechaSalida, Date fechaParametro) {
        Calendar myCal1 = Calendar.getInstance();
        Calendar myCal2 = Calendar.getInstance();
        myCal1.setTime(fechaParametro);
        myCal2.setTime(fechaParametro);
        myCal1.set(Calendar.HOUR_OF_DAY, 00);
        myCal1.set(Calendar.MINUTE, 00);
        myCal1.set(Calendar.SECOND, 00);
        myCal2.set(Calendar.HOUR_OF_DAY, 23);
        myCal2.set(Calendar.MINUTE, 59);
        myCal2.set(Calendar.SECOND, 59);
        Date fechaInicioDia = myCal1.getTime();
        Date fechaFinDia = myCal2.getTime();
        return (fechaInicioDia.before(fechaSalida) && fechaFinDia.after(fechaSalida));
    }

    /**
     * Metodo que verifica la existencia del ciclo desde el vertice para el cual fue llamado
     * @param camino
     * @return True si existe, False si no
     */
    
    @Override
    public boolean tieneCiclo(TCamino camino) {
        setVisitado(true);

        boolean ciclo = false;
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            if (ciclo) {
                break;
            }
            TVertice w = adyacencia.getDestino();
            if (!w.getVisitado()) {
                camino.agregarAdyacencia(adyacencia);
                ciclo = w.tieneCiclo(camino);
            } else {
                ciclo = true;
                System.out.println("hay ciclo : " + camino.imprimirDesdeClave(w.etiqueta));
            }
        }
        camino.getOtrosVertices().remove(this.getEtiqueta());
        return ciclo;

    }

    /**
     * Metodo alternativo con la misma funcion que el anterior, hecho por el grupo de clase
     * @param contador
     * @return True si tiene ciclos, False si no lo tiene
     */
    
    public boolean contieneCiclos(int contador) { 
        this.setVisitado(true);
        this.setNumeracionBpf(contador);
        contador++;
        for (TAdyacencia adyacente : this.adyacentes) {
            if (adyacente.getDestino().getVisitado() == false) {
                return adyacente.getDestino().contieneCiclos(contador);
            } else if (this.numeracionBpf > adyacente.getDestino().getNumeracionBpf()) {
                return true;
            }
        }
        this.setVisitado(false);
        this.setNumeracionBpf(-1);
        return false;
    }
    
    /**
     * Aumenta en una unidad el atributo del vertice de la numeracion topologica
     */

    public void sumarNumeracionTopologica() {
        numeracionTopologica++;
    }

    /**
     * Metodo que devuelve el atributo del vertice de numeracion topologica
     * @return numeracionTopologica entero correspondiente 
     */
    
    public int getNumeracionTopologica() {
        return numeracionTopologica;
    }

    /**
     * Setea el atributo relacionado a la numeracion topologica
     * @param i 
     */
    
    public void setNumeracionTopologica(int i) {
        numeracionTopologica = i;
    }
}
