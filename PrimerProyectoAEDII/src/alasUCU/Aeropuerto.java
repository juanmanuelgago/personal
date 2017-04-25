/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasUCU;

/**
 *
 * @author Juanma
 */
public class Aeropuerto {

    private Comparable id;
    private String nombre_Aero;
    private String nombre_Ciudad;
    private String nombre_Pais;
    private String codigo_ICOA;
    private String latitud;
    private String longitud;
    private double altitud;
    private double timezone; // Ej. -5, -8.
    private Character horarioVerano;
    private String zonaHoraria; // Ej. Canada/Toronto, UK/Greenwich

    /**
     * Constructor del objeto Aeropuerto
     * @param id
     * @param nombre_Aero
     * @param nombre_Ciudad
     * @param nombre_Pais
     * @param codigo_ICOA
     * @param latitud
     * @param longitud
     * @param altitud
     * @param timezone
     * @param horarioVerano
     * @param zonaHoraria 
     */
    
    public Aeropuerto(Comparable id, String nombre_Aero, String nombre_Ciudad, String nombre_Pais, String codigo_ICOA, String latitud, String longitud, double altitud, double timezone, Character horarioVerano, String zonaHoraria) {
        this.id = id;
        this.nombre_Aero = nombre_Aero;
        this.nombre_Ciudad = nombre_Ciudad;
        this.nombre_Pais = nombre_Pais;
        this.codigo_ICOA = codigo_ICOA;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
        this.timezone = timezone;
        this.horarioVerano = horarioVerano;
        this.zonaHoraria = zonaHoraria;
    }

    /**
     * Devuelve el identificador correspondiente al aeropuerto
     * @return Identificador del aeropuerto
     */
    
    public Comparable getId() {
        return id;
    }
    
    /**
     * Setea el identificador del aeropuerto
     * @param id 
     */
    
    public void setId(Comparable id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del aeropuerto
     * @return String con el nombre del aeropuerto
     */
    
    public String getNombre_Aero() {
        return nombre_Aero;
    }

    /**
     * Setea el nombre del aeropuerto
     * @param nombre_Aero 
     */
    
    public void setNombre_Aero(String nombre_Aero) {
        this.nombre_Aero = nombre_Aero;
    }

    /**
     * Devuelve el nombre de la ciudad donde se encuentra el aeropuerto
     * @return String con el nombre de la ciudad
     */
    
    public String getNombre_Ciudad() {
        return nombre_Ciudad;
    }

    /**
     * Setea el nombre de la ciudad donde se encuentra el aeropuerto
     * @param nombre_Ciudad 
     */
    
    public void setNombre_Ciudad(String nombre_Ciudad) {
        this.nombre_Ciudad = nombre_Ciudad;
    }
    
    /**
     * Devuelve el nombre del pais donde se encuentra el aeropuerto
     * @return String con el nombre del pais
     */
    
    public String getNombre_Pais() {
        return nombre_Pais;
    }

    /**
     * Setea el nombre del pais donde se encuentra el aeropuerto
     * @param nombre_Pais 
     */
    
    public void setNombre_Pais(String nombre_Pais) {
        this.nombre_Pais = nombre_Pais;
    }

    /**
     * Devuelve el codigo ICOA del aeropuerto
     * @return String con el codigo correspondiente
     */
    
    public String getCodigo_ICOA() {
        return codigo_ICOA;
    }

    /**
     * Setea el codigo ICOA del aeropuerto
     * @param codigo_ICOA 
     */
    
    public void setCodigo_ICOA(String codigo_ICOA) {
        this.codigo_ICOA = codigo_ICOA;
    }

    /**
     * Devuelve una cadena con la coordenada correspondiente a la latitud del aeropuerto
     * @return String con la latitud
     */
    
    public String getLatitud() {
        return latitud;
    }
    
    /**
     * Setea la latitud pasada por parametro al aeropuerto
     * @param latitud 
     */
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * Retorna un string con la coordenada correspondiente a la longitud del aeropuerto
     * @return String con la longitud
     */
    
    public String getLongitud() {
        return longitud;
    }

    /**
     * Setea la longitud del aeropuerto pasada por parametro
     * @param longitud 
     */
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la altura que tiene la ubicacion del aeropuerto
     * @return Valor de la altura
     */
    
    public double getAltitud() {
        return altitud;
    }

    /**
     * Setea la altitud del aeropuerto
     * @param altitud 
     */
    
    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    /**
     * Devuelve la diferencia existente entre las horas especificas de la zona horaria
     * del aeropuerto con la referencia del tiempo universal de Greenwich 
     * @return Valor con la diferencia
     */
    
    public double getTimezone() {
        return timezone;
    }

    /**
     * Setea la diferencia con Greenwich mediante la pasada por parametro
     * @param timezone 
     */
    
    public void setTimezone(double timezone) {
        this.timezone = timezone;
    }

    /**
     * Devuelve el caracter que nos informa de la existencia de un posible cambio 
     * de horario de verano o no en la ciudad del aeropuerto
     * @return A si hay cambio, N si no lo hay
     */
    
    public Character getHorarioVerano() {
        return horarioVerano;
    }

    /**
     * Setea el cambio de horario por si se cambia el mismo o no
     * @param horarioVerano 
     */
    
    public void setHorarioVerano(Character horarioVerano) {
        this.horarioVerano = horarioVerano;
    }

    /**
     * Devuelve la zona horaria a la que pertenece el aeropuerto
     * @return String con la zona horaria
     */
    
    public String getZonaHoraria() {
        return zonaHoraria;
    }

    /**
     * Setea la zona horaria del aeropuerto
     * @param zonaHoraria 
     */
    
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    
    
}
