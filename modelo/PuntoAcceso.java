package modelo;
import modelo.EstadoPuntoAcceso;

public class PuntoAcceso {

    private String codigo;
    private String nombre;	
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private EstadoPuntoAcceso estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion, int capacidadMaximaPorHora, EstadoPuntoAcceso estado) {
        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
        this.estado = estado;
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
    public void setCapacidadMaximaPorHora(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.capacidadMaximaPorHora = capacidad;
    }
    public void setEstado(EstadoPuntoAcceso estado){
        this.estado = estado;
    }

}