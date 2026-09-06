package modelo;
import java.util.ArrayList;

public class Visitante{

    private String codigoEntrada;
    private String nombre;
    private int edad;
    private int cantidadAtraccionesVisitadas;
    private int puntosAcumulados;

    // Pq visitantes tiene un Array de sí mismo???
    private ArrayList<Visitante> visitantes; 

    public Visitante(String codigoEntrada, String nombre, int edad, int cantidadAtraccionesVisitadas, int puntosAcumulados){
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;

        try{
            this.edad = edad;
            this.cantidadAtraccionesVisitadas = cantidadAtraccionesVisitadas;
            this.puntosAcumulados = puntosAcumulados;

            if (edad < 1){
                throw new IllegalArgumentException();
            }
            if (cantidadAtraccionesVisitadas < 0){
                throw new IllegalArgumentException();
            }
            if (puntosAcumulados < 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Existe un valor menor a 0");
        }
    }

    //getters
    public String getCodigoEntrada(){
        return codigoEntrada;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public int getCantidadAtraccionesVisitadas(){
        return cantidadAtraccionesVisitadas;
    }
    public int getPuntosAcumulados(){
        return puntosAcumulados;
    }

    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        if (edad < 1) {
            throw new IllegalArgumentException("La edad debe ser mayor a 0.");
        }
        this.edad = edad;
    }
    public void setCantidadAtraccionesVisitadas(int cantidad){
        try{
            this.cantidadAtraccionesVisitadas = cantidad;

            if (cantidadAtraccionesVisitadas < 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Existe un valor menor a 0");
        }
    }
    public void setPuntosAcumulados(int puntos){
        try{
            this.puntosAcumulados = puntos;
            
            if (puntosAcumulados < 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Existe un valor menor a 0");
        }
    }

}