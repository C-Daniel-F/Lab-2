package modelo;

public class Visitante {
    private final String codigoEntrada;
    private String nombre;
    private int edad;
    private int cantidadAtraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(String codigoEntrada, String nombre, int edad,
            int cantidadAtraccionesVisitadas, int puntosAcumulados) {
        this.codigoEntrada = validarTexto(codigoEntrada, "El codigo de entrada");
        actualizarDatos(nombre, edad, cantidadAtraccionesVisitadas, puntosAcumulados);
    }

    public String getCodigoEntrada() {
        return codigoEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadAtraccionesVisitadas() {
        return cantidadAtraccionesVisitadas;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre");
    }

    public void setEdad(int edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    public void setCantidadAtraccionesVisitadas(int cantidad) {
        validarCantidadNoNegativa(cantidad,
                "La cantidad de atracciones visitadas");
        this.cantidadAtraccionesVisitadas = cantidad;
    }

    public void setPuntosAcumulados(int puntos) {
        validarCantidadNoNegativa(puntos, "Los puntos acumulados");
        this.puntosAcumulados = puntos;
    }

    public void actualizarDatos(String nombre, int edad,
            int cantidadAtraccionesVisitadas, int puntosAcumulados) {
        String nombreValidado = validarTexto(nombre, "El nombre");
        validarEdad(edad);
        validarCantidadNoNegativa(cantidadAtraccionesVisitadas,
                "La cantidad de atracciones visitadas");
        validarCantidadNoNegativa(puntosAcumulados, "Los puntos acumulados");

        this.nombre = nombreValidado;
        this.edad = edad;
        this.cantidadAtraccionesVisitadas = cantidadAtraccionesVisitadas;
        this.puntosAcumulados = puntosAcumulados;
    }

    private static void validarEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que cero.");
        }
    }

    private static void validarCantidadNoNegativa(int cantidad, String campo) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativa.");
        }
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacio.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "Codigo: " + codigoEntrada
                + ", nombre: " + nombre
                + ", edad: " + edad
                + ", atracciones visitadas: " + cantidadAtraccionesVisitadas
                + ", puntos: " + puntosAcumulados;
    }
}
