package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parque {
    public static final int MAXIMO_PUNTOS_ACCESO = 5;

    private final String nombre;
    private final String codigoIdentificacion;
    private final String nombreEncargado;
    private final PuntoAcceso[] puntosAcceso;
    private final ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigoIdentificacion, String nombreEncargado) {
        this.nombre = validarTexto(nombre, "El nombre del parque");
        this.codigoIdentificacion = validarTexto(codigoIdentificacion,
                "El codigo de identificacion");
        this.nombreEncargado = validarTexto(nombreEncargado,
                "El nombre del encargado");
        this.puntosAcceso = new PuntoAcceso[MAXIMO_PUNTOS_ACCESO];
        this.visitantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public boolean habilitarPuntoAcceso(int posicion, PuntoAcceso punto) {
        validarPosicion(posicion);
        if (punto == null) {
            throw new IllegalArgumentException("El punto de acceso es obligatorio.");
        }
        if (puntosAcceso[posicion] != null) {
            return false;
        }
        puntosAcceso[posicion] = punto;
        return true;
    }

    public PuntoAcceso obtenerPuntoAcceso(int posicion) {
        validarPosicion(posicion);
        return puntosAcceso[posicion];
    }

    public boolean modificarPuntoAcceso(int posicion, int nuevaCapacidad,
            EstadoPuntoAcceso nuevoEstado) {
        validarPosicion(posicion);
        PuntoAcceso punto = puntosAcceso[posicion];
        if (punto == null) {
            return false;
        }
        if (nuevaCapacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero.");
        }
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }
        punto.setCapacidadMaximaPorHora(nuevaCapacidad);
        punto.setEstado(nuevoEstado);
        return true;
    }

    public boolean cerrarPuntoAcceso(int posicion) {
        validarPosicion(posicion);
        if (puntosAcceso[posicion] == null) {
            return false;
        }
        puntosAcceso[posicion] = null;
        return true;
    }

    public int contarPuntosHabilitados() {
        int cantidad = 0;
        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarEspaciosDisponibles() {
        return MAXIMO_PUNTOS_ACCESO - contarPuntosHabilitados();
    }

    public PuntoAcceso obtenerPuntoMayorCapacidad() {
        PuntoAcceso mayor = null;
        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null && (mayor == null
                    || punto.getCapacidadMaximaPorHora()
                    > mayor.getCapacidadMaximaPorHora())) {
                mayor = punto;
            }
        }
        return mayor;
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (visitante == null) {
            throw new IllegalArgumentException("El visitante es obligatorio.");
        }
        if (buscarVisitante(visitante.getCodigoEntrada()) != null) {
            return false;
        }
        visitantes.add(visitante);
        return true;
    }

    public Visitante buscarVisitante(String codigoEntrada) {
        if (codigoEntrada == null) {
            return null;
        }
        for (Visitante visitante : visitantes) {
            if (visitante.getCodigoEntrada().equalsIgnoreCase(codigoEntrada.trim())) {
                return visitante;
            }
        }
        return null;
    }

    public boolean modificarVisitante(String codigoEntrada, String nuevoNombre,
            int nuevaEdad, int nuevasAtracciones, int nuevosPuntos) {
        Visitante visitante = buscarVisitante(codigoEntrada);
        if (visitante == null) {
            return false;
        }
        visitante.actualizarDatos(nuevoNombre, nuevaEdad,
                nuevasAtracciones, nuevosPuntos);
        return true;
    }

    public boolean eliminarVisitante(String codigoEntrada) {
        Visitante visitante = buscarVisitante(codigoEntrada);
        return visitante != null && visitantes.remove(visitante);
    }

    public List<Visitante> obtenerVisitantes() {
        return Collections.unmodifiableList(visitantes);
    }

    public int contarVisitantes() {
        return visitantes.size();
    }

    public Visitante obtenerVisitanteMayorPuntaje() {
        Visitante mayor = null;
        for (Visitante visitante : visitantes) {
            if (mayor == null
                    || visitante.getPuntosAcumulados() > mayor.getPuntosAcumulados()) {
                mayor = visitante;
            }
        }
        return mayor;
    }

    public Visitante obtenerVisitanteMasAtracciones() {
        Visitante mayor = null;
        for (Visitante visitante : visitantes) {
            if (mayor == null || visitante.getCantidadAtraccionesVisitadas()
                    > mayor.getCantidadAtraccionesVisitadas()) {
                mayor = visitante;
            }
        }
        return mayor;
    }

    public double calcularPromedioEdad() {
        if (visitantes.isEmpty()) {
            return 0.0;
        }
        int sumaEdades = 0;
        for (Visitante visitante : visitantes) {
            sumaEdades += visitante.getEdad();
        }
        return (double) sumaEdades / visitantes.size();
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= puntosAcceso.length) {
            throw new IllegalArgumentException("La posicion debe estar entre 0 y 4.");
        }
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacio.");
        }
        return valor.trim();
    }
}
