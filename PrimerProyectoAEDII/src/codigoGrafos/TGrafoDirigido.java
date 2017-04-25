package codigoGrafos;


import alasUCU.Aeropuerto;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Juanma
 */
public class TGrafoDirigido implements IGrafoDirigido {

    /**
     *Map de Comparables y Vertices pertenecientes al Grafo Dirigido
     */
    protected final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-

    /**
     * Constructor del objeto Tipo Grafo Dirigido
     * @param vertices Conjunto de vertices
     * @param aristas Conjunto de aristas
     */
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta(),vertice.getDatos());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return True si se elimino la Adyacencia, False en caso contrario
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return True si se realizo la eliminacion, False en caso contrario
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    
    public TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino, arista.getDatos());
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @param aero Datos del Aeropuerto
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    
    public boolean insertarVertice(Comparable unaEtiqueta, Aeropuerto aero) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta,aero);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    /**
     * Metodo encargado de insertar el vertice
     * @param vertice
     * @return True si se inserto el vertice, False en caso contrario 
     */
    
    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    /**
     * Algoritmo de Floyd, para hallar los caminos minimos entre todos los pares de vertices
     * @return Matriz de Floyd
     */
    
    @Override
    public Double[][] floyd() {
        Double[][] c = UtilGrafos.obtenerMatrizCostos(this.vertices);
            for(int i = 0; i < this.vertices.size() ; i++){
                c[i][i] = 0.0;
            }
            for(int k = 0; k < this.vertices.size(); k++){
                for(int i = 0 ; i < this.vertices.size(); i++){
                    for(int j = 0; j < this.vertices.size(); j++){
                        if ((c[i][k] + c[k][j]) < c[i][j]) {
                            c[i][j] = c[i][k] + c[k][j];
                        }
                    }
                }
            }
            return c;              
    }

    /**
     * Algoritmo de Warshall, para verificar la existencia de un camino entre cada par de vertices
     * @return Matriz de Warshall, True si hay camino, False si no lo hay
     */
    
    @Override
    public boolean[][] warshall() {
        Double[][] costos = UtilGrafos.obtenerMatrizCostos(this.vertices); 
        boolean[][] w = new boolean[this.vertices.size()][this.vertices.size()];
        for(int i = 0; i < this.vertices.size(); i++){
            for(int j = 0; j < this.vertices.size(); j++){
                if (costos[i][j] == Double.MAX_VALUE || costos[i][j] <= 0){
                    w[i][j] = false;                       
                }
                else {
                    w[i][j] = true;
                }                    
            }
        }                
        for(int k = 0; k < this.vertices.size(); k++){
            for(int i = 0; i < this.vertices.size(); i++){
                for(int j=0; j < this.vertices.size() ; j++){
                    if ( i == j ) {
                        w[i][j] = false;
                    } 
                    else if (w[i][j] == false) {
                        w[i][j] = w[i][k] && w[k][j];
                    }                      
                }
            }
        }
        return w;          
    }
    
    /**
     * Algoritmo de Warshall, con la diferencia de que los valores de la matriz son de tipo Double
     * @return Matriz de Warshall, 1.0 si hay camino, 0.0 si no lo hay
     */
    
    public Double[][] warshallDouble() { //UNICA MANERA DE VER LA MATRIZ WARSHALL DEBIDO A UN PROBLEMA DE COMPARABLE CON UTIL GRAFOS 
        boolean[][] warshall = warshall();
        Double[][] warshallD = new Double[warshall.length][warshall.length];            
        for(int i=0; i<vertices.size(); i++) {
            for(int j=0; j<vertices.size(); j++){
                if (warshall[i][j] == true){
                    warshallD[i][j]= 1d;                       
                }else{
                    warshallD[i][j]= 0d; 
                }                    
            }
        }          
        return warshallD;          
    }        

    /**
     * Metodo encargado de obtener la excentricidad del vertice cuya etiqueta es la pasada por parametro
     * @param etiquetaVertice
     * @return excentricidad Valor de excentricidad del vertice en cuestion
     */
    
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] c = this.floyd();       
        int columnaVertice = 0;
        int contador = 0;
        for(Comparable key : this.vertices.keySet()) {
            if(key.equals(etiquetaVertice)) {
                columnaVertice = contador;
                break;
            }            
            contador += 1;            
        }        
        double excentricidad = 0;
        for(int i = 0; i < this.vertices.size(); i++) {
            if(c[i][columnaVertice] > excentricidad){
                excentricidad = c[i][columnaVertice];
            }
        }
        return excentricidad;
    }


    /**
     * Metodo encargado de buscar el centro del grafo
     * @return Etiqueta del centro del grafo
     */
    @Override
    public Comparable centroDelGrafo() {        
        Comparable[] etiquetas = this.vertices.keySet().toArray(new Comparable[vertices.keySet().size()]);
        Double[][] c = this.floyd();
        double centro = Double.MAX_VALUE;
        int contadorColumna = 0;
        int columnaResultado = 0;
        for(int i = 0; i < this.vertices.size() ; i++) {
            double excentricidad = 0;
            for(int j = 0; j < this.vertices.size() ; j++) {
                if(c[j][i] > excentricidad){
                    excentricidad = c[j][i];
                }
            }
            if (excentricidad < centro) {
                centro = excentricidad;
                columnaResultado = contadorColumna;
            }
            contadorColumna++;            
        }        
       return etiquetas[columnaResultado];
    }

    /**
     * Metodo que devuelve las etiquetas ordenadamente
     * @return Array con etiquetas
     */
    
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * Metodo encargado de desvisitar cada uno de los vertices del grafo
     */
    
    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * Metodo que devuelve la coleccion de vertices del grafo
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    /**
     * Metodo encargado de hacer la busqueda en profundidad desde el vertice pasado
     * por parametro
     * @param vertice
     * @return Coleccion con las etiquetas segun se las visite en la busqueda
     */
    
    @Override
    public Collection<Comparable> bpf(TVertice vertice) {
        Collection<Comparable> visitados = new LinkedList<>();
        if (!this.vertices.isEmpty()) {
            if (buscarVertice(vertice.getEtiqueta()) != null) {
                this.desvisitarVertices();
                TVertice vert = buscarVertice(vertice.getEtiqueta());
                vert.bpf(visitados);
                for (TVertice v : this.vertices.values()) {
                    if (!v.getVisitado()) {
                        v.bpf(visitados);
                    }
                }
            }
        }
        return visitados;
    }

    /**
     * Metodo encargado de hacer la busqueda en profundidad buscando el vertice cuya
     * etiqueta es la pasada por parametro
     * @param etiquetaOrigen
     * @return Coleccion con las etiquetas segun se las visite en la busqueda
     */
    
    
    @Override
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
        Collection<Comparable> visitados = new LinkedList<>();
        if (!this.vertices.isEmpty()) {
            if (buscarVertice(etiquetaOrigen) != null) {
                this.desvisitarVertices();
                TVertice vert = buscarVertice(etiquetaOrigen);
                vert.bpf(visitados);
                for (TVertice v : this.vertices.values()) {
                    if (!v.getVisitado()) {
                        v.bpf(visitados);
                    }
                }
            }
        }
        return visitados;
    }

   
    /**
     * BPF del grafo, a partir del primer vértice, para todos los vertices
     * @return Lista enlazada con las etiquetas correspondientes
     */
    @Override
    public Collection<Comparable> bpf (){
        Collection<Comparable> visitados = new LinkedList<>();
        if(this.vertices.isEmpty()) {
            System.out.println("El grafo dirigido se encuentra vacío");
            return visitados;
        }else {
            this.desvisitarVertices();
            for(TVertice vertice : vertices.values()) {
                if (!vertice.getVisitado()) {
                    vertice.bpf(visitados);
                }            
            }
            return visitados;            
        }        
    }

    /**
     * Metodo encargado de encontrar cada uno de los caminos que unen al origen y el destino, para el cual
     * el comienzo del recorrido arranque en la fecha especificada por parametro
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @param fecha 
     * @return El conjunto de caminos correspondientes que comienzan en el vertice en etiquetaOrigen, y finalizan en
     * la etiquetaDestino, arrancando desde la fecha en cuestion
     */
    
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino, Date fecha) {
        this.desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos, fecha);
            return todosLosCaminos;
        }
        return null;          
    }
   
    
    
    @Override
    public boolean tieneCiclo() {
        boolean resultado = false;
        if(this.vertices.isEmpty()){
            return resultado;
        }else{
            this.desvisitarVertices();
            for(TVertice vertice : vertices.values()){                
                int i = 0;
                resultado = vertice.contieneCiclos(i);
                if (resultado == true){
                    return resultado;
                }
            }            
        }
        return resultado;
    }

    /**
     * Metodo que verifica si existe un ciclo en el grafo, dado el vertice cuya etiqueta
     * es la pasada por parametro
     * @param etiquetaOrigen
     * @return True si hay ciclo, False si no lo hay
     */
    
    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        boolean resultado = false;
        if(this.vertices.isEmpty()){
            return resultado;
        } 
        else {
            TVertice v = buscarVertice(etiquetaOrigen);
            if (v != null) {
                this.desvisitarVertices();
                int i = 0;
                resultado = v.contieneCiclos(i);
                if (resultado) {
                    return resultado;
                }
            }
        }
        return resultado;
    }
    
    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que devuelve la matriz con los precedentes de cada vertice, segun su camino mas corto 
     * calculado con la matriz de Floyd
     * @return Matriz de Vertices
     */
    
    public TVertice[][] precedentesFloyd() {
        Double[][] c = UtilGrafos.obtenerMatrizCostos(vertices);        
        TVertice[] vectorVertices = vertices.values().toArray(new TVertice[vertices.values().size()]);
        TVertice[][] precedentes = new TVertice[c.length][c.length];
        for(int i=0; i<c.length; i++){
            c[i][i] = 0.0;
            for(int j=0; j<c.length; j++){
                precedentes[i][j]= null;
            }
        }        
        for(int k=0; k<c.length; k++){
            for(int i=0; i<c.length; i++){
                for(int j=0; j<c.length; j++){
                    if ((c[i][k] + c[k][j]) < c[i][j]) {
                        c[i][j] = c[i][k] + c[k][j];
                        precedentes [i][j] = vectorVertices[k];
                    }
                }
            }
        }
        return precedentes;                 
    }
    
    /**
     * Metodo que imprime en consola el camino mas corto entre el par de vertices que
     * contienen como etiqueta los parametros pasados a la funcion
     * @param origen
     * @param destino 
     */
    
    public void obtenerCaminoFloyd (Comparable origen, Comparable destino){
        TVertice[][] matrizPrecedentes = precedentesFloyd();
        TVertice[] vectorVertices = vertices.values().toArray(new TVertice[vertices.values().size()]);
        int indiceOrigen = -1;
        int indiceDestino = -1;
        for (int i = 0; i < vectorVertices.length; i++) {
            if(origen.compareTo(vectorVertices[i].getEtiqueta())== 0){
                indiceOrigen = i;
            }
            if(destino.compareTo(vectorVertices[i].getEtiqueta())== 0){
                indiceDestino = i;
            }
            if(indiceOrigen != -1 && indiceDestino != -1){
                break;                
            }           
        }        
        if(indiceOrigen != -1 && indiceDestino != -1){
            System.out.print(origen + " - ");
            obtenerCaminoFloyd(indiceOrigen, indiceDestino, vectorVertices, matrizPrecedentes);
            System.out.println(destino);
        }else{
            System.out.println("Uno o ambos vértices no pertenecen al grafo");
        }  
        
    }
    
    /**
     * Metodo auxiliar al obtenerCaminoFloyd con su respectiva funcionalidad
     * @param indiceOrigen
     * @param indiceDestino
     * @param vectorVertices
     * @param matrizPrecedentes 
     */
    
    private void obtenerCaminoFloyd(int indiceOrigen, int indiceDestino,TVertice[] vectorVertices, TVertice[][] matrizPrecedentes){
        TVertice k = matrizPrecedentes[indiceOrigen][indiceDestino];
        if(k == null){
            return;            
        }
        int indiceK = -1;
        for (int i = 0; i < vectorVertices.length; i++) {
            if(k.getEtiqueta().compareTo(vectorVertices[i].getEtiqueta())== 0){
                indiceK = i;
                break;
            }                   
        }
        obtenerCaminoFloyd(indiceOrigen, indiceK, vectorVertices, matrizPrecedentes);
        System.out.print(k.getEtiqueta() + " - ");
        obtenerCaminoFloyd(indiceK, indiceDestino, vectorVertices, matrizPrecedentes);  
    }
    
    /**
     * Metodo que devuelve un posible orden lineal del grafo, si es que el mismo es aciclico
     * @return Lista Enlazada de vertices con el orden lineal antes mencionado
     */
    
    public LinkedList<TVertice> ordenTopologico (){
        if(vertices == null || vertices.isEmpty()== true){
            System.out.println("El grafo dirigido se encuentra vacío");
            return null;
        }else if (this.tieneCiclo()){
            System.out.println("El grafo dirigido contiene ciclos y no se puede "
                                        + "realizar una ordenación topológica");
            return null;
        }else{
            Collection <TVertice> vertGrafo = new LinkedList<>();
            vertGrafo.addAll(vertices.values());
            LinkedList<TVertice> resultado = new LinkedList<>();            
            return ordenTopologico(vertGrafo, resultado);
            
        }
    }
    
    /**
     * Metodo auxiliar al ordenTopologico anterior, con su respectiva funcionalidad
     * @param vertGrafo
     * @param resultado
     * @return 
     */
    
    private LinkedList<TVertice> ordenTopologico(Collection <TVertice> vertGrafo, LinkedList<TVertice> resultado){        
        while(vertGrafo.isEmpty()!= true){
            //Se calculan la cantidad de aristas que llegan a cada vector
            for(TVertice v : vertGrafo){
                for(TAdyacencia adyacencia : v.getAdyacentes()){
                    adyacencia.getDestino().sumarNumeracionTopologica();                
                }
            }
            Iterator<TVertice>  it = vertGrafo.iterator();
            while(it.hasNext()){
                TVertice vertice = it.next();
                if(vertice.getNumeracionTopologica() == 0){
                    resultado.add(vertice);
                    it.remove();                    
                }else{
                    vertice.setNumeracionTopologica(0);
                }
            }            
        }
        return resultado;
    }
    
}
