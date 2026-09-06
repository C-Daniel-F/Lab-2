package modelo;
import modelo.PuntoAcceso;

public class Parque {
    
    private String nombre;
    private String codigoIdentificacion;
    private String nombreEncargado;
    private PuntoAcceso[] puntosAcceso;
    private int limiteAcceso = 5;

    public Parque(String nombre, String codigoIdentificacion, String nombreEncargado){
        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreEncargado = nombreEncargado;
        puntosAcceso = new PuntoAcceso[limiteAcceso];
    }

    public boolean habilitarPuntoAcceso(int posicion, PuntoAcceso punto){
        try{
            if (posicion < 0 || posicion > limiteAcceso) {
                throw new IllegalArgumentException();
            }
            if (puntosAcceso[posicion] == null) {
                puntosAcceso[posicion] = punto;
                return true;
            }
            return false;
        } catch (IllegalArgumentException error) {
            System.out.println("Entre 0-4");
            return false;
        }

    }

    public PuntoAcceso obtenerPuntoAcceso(int posicion){
        try{
            if (posicion < 0 || posicion > limiteAcceso) {
                throw new IllegalArgumentException();
            }
            return puntosAcceso[posicion];
        } catch (IllegalArgumentException error) {
            System.out.println("Entre 0-4");
            return null;
        }
    }

    public void mostrarPuntosAcceso(){
        for (int i = 0; i < limiteAcceso; i++) {
            if (puntosAcceso[i] != null) {
                System.out.println("Punto de Acceso ");
                System.out.println(i);
                System.out.println(", Posee:  ");
                System.out.println(puntosAcceso[i]);
            }
        }
    }

    public boolean modificarPuntoAcceso( int posicion, int nuevaCapacidad, EstadoPuntoAcceso nuevoEstado ){
        if (puntosAcceso[posicion] != null) {

            puntosAcceso[posicion].setCapacidadMaximaPorHora(nuevaCapacidad);
            puntosAcceso[posicion].setEstado(nuevoEstado);
            return true;
        }
        return false;
    }

    public boolean cerrarPuntoAcceso(int posicion){
        if (puntosAcceso[posicion] != null) {
            puntosAcceso[posicion] = null;
            return true;
        }
        return false;
    }

    public int contarPuntosHabilitados(){
        int j = 0;
        for (int i = 0; i < limiteAcceso; i++) {
            if (puntosAcceso[i] != null) {
                j++;
            }
        }
        return j;
    }

    public int contarEspaciosDisponibles(){
        int j = 0;
        for (int i = 0; i < limiteAcceso; i++) {
            if (puntosAcceso[i] == null) {
                j++;
            }
        }
        return j;
    }

    public PuntoAcceso obtenerPuntoMayorCapacidad(){
        int j = 0;
        for (int i = 0; i < limiteAcceso; i++){
            if (puntosAcceso[i] != null) {
                if (puntosAcceso[i].getCapacidadMaximaPorHora() > puntosAcceso[j].getCapacidadMaximaPorHora()){
                    j = i;
                }
            }
        }
        return puntosAcceso[j];
    }

}
