package modelo;

public class PuntoAcceso {
    private final String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private EstadoPuntoAcceso estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion,
            int capacidadMaximaPorHora, EstadoPuntoAcceso estado) {
        this.codigo = validarTexto(codigo, "El codigo");
        this.nombre = validarTexto(nombre, "El nombre");
        this.ubicacion = validarTexto(ubicacion, "La ubicacion");
        setCapacidadMaximaPorHora(capacidadMaximaPorHora);
        setEstado(estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaximaPorHora() {
        return capacidadMaximaPorHora;
    }

    public EstadoPuntoAcceso getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre");
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = validarTexto(ubicacion, "La ubicacion");
    }

    public void setCapacidadMaximaPorHora(int capacidadMaximaPorHora) {
        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero.");
        }
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
    }

    public void setEstado(EstadoPuntoAcceso estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }
        this.estado = estado;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacio.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + ", nombre: " + nombre
                + ", ubicacion: " + ubicacion
                + ", capacidad por hora: " + capacidadMaximaPorHora
                + ", estado: " + estado;
    }
}
