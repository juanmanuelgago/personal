package codigoGrafos;


import alasUCU.Vuelo;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author diego
 */
public class TCamino {

    private final TVertice origen;
    private Collection<Comparable> otrosVertices;
    private Vuelo ultimoVuelo;
    private Double tiempoTotalVuelo = 0.0;
// es una lista de etiquetas de los vertices
// ATENCIÓN: PONER LA CLASE CONCRETA QUE									     	     
// SEA MÁS APROPIADA
    private Double costoTotal = 0.0d;

    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
        System.out.println("TIEMPO: " + this.tiempoTotalVuelo);
    }

    public String imprimirEtiquetas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Origen: " + getOrigen().getEtiqueta());
        for (Comparable adyacente : getOtrosVertices()) {
            sb.append(" -> " + adyacente);
        }
        return sb.toString();
    }

    public TCamino(TVertice v) {
        this.origen = v;
        this.otrosVertices = new LinkedList();
    }

    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            setCostoTotal((Double) getCostoTotal() + ((Number) adyacenciaActual.getCosto()).doubleValue());
            setUltimoVuelo(adyacenciaActual.getDatos_Vuelo());
            setTiempoTotalVuelo(this.getTiempoTotalVuelo() + adyacenciaActual.tiempoDeVuelo());
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            setCostoTotal((Double) getCostoTotal() - ((Number) adyacenciaActual.getCosto()).doubleValue());
            setTiempoTotalVuelo(getTiempoTotalVuelo() - adyacenciaActual.tiempoDeVuelo());
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public TVertice getOrigen() {
        return origen;
    }

    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    public void setOtrosVertices(Collection<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Vuelo getUltimoVuelo() {
        return ultimoVuelo;
    }

    public void setUltimoVuelo(Vuelo ultimoVuelo) {
        this.ultimoVuelo = ultimoVuelo;
    }    

    public Double getTiempoTotalVuelo() {
        return tiempoTotalVuelo;
    }

    public void setTiempoTotalVuelo(Double tiempoTotalVuelo) {
        this.tiempoTotalVuelo = tiempoTotalVuelo;
    }
    
    public Comparable getUltimaEtiqueta() {
        final Iterator<Comparable> itr = this.getOtrosVertices().iterator();
        Comparable lastElement = itr.next();
        while(itr.hasNext()) {
            lastElement = itr.next();
        }
    return lastElement;
    }
    
    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta(),this.getOrigen().getDatos());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());

        return copia;
    }
    
    public TCamino copiarConCosto() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta(),this.getOrigen().getDatos());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.getCostoTotal());
        copia.setTiempoTotalVuelo(getTiempoTotalVuelo());
        return copia;
    }

    public String imprimirDesdeClave(Comparable clave) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        Collection<Comparable> listaDefinitiva = new LinkedList<Comparable>();
        listaDefinitiva.add(this.getOrigen().getEtiqueta());
        listaDefinitiva.addAll(this.getOtrosVertices());

        for (Iterator<Comparable> iterator = listaDefinitiva.iterator(); iterator.hasNext();) {
            Comparable next = iterator.next();
            if (next.compareTo(clave) == 0) {
                start = true;
            }
            if (start) {
                sb.append(" " + next + " ");
            }
        }
        return sb.toString();
    }   
    
    
}
