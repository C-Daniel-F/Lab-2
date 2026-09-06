package modelo;
import modelo.EstadoPuntoAcceso;

public class PuntoAcceso {

    private String codigo;
    private String nombre;	
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private EstadoPuntoAcceso estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, EstadoPuntoAcceso estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;

        try{
            this.capacidadMaximaPorHora = capacidadMaximaPorHora;

            if (capacidadMaximaPorHora <= 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Valor igual o a 0");
        }
    }

    // getters
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public EstadoPuntoAcceso getEstado(){
        return estado;    
    }
    public int getCapacidadMaximaPorHora(){
        return capacidadMaximaPorHora;
    }

    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setCapacidadMaximaPorHora(int capacidad){
        this.capacidadMaximaPorHora = capacidad;
    }
    public void setEstado(EstadoPuntoAcceso estado){
        this.estado = estado;
    }

}