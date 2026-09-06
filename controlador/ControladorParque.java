package controlador;

import modelo.EstadoPuntoAcceso;
import modelo.Parque;
import modelo.PuntoAcceso;
import modelo.Visitante;
import vista.VistaConsola;

public class ControladorParque {
    private final VistaConsola vista;
    private Parque parque;

    public ControladorParque(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        try {
            vista.mostrarBienvenida();
            crearParque();
            ejecutarMenu();
        } finally {
            vista.mostrarMensaje("Sistema finalizado.");
            vista.cerrar();
        }
    }

    private void crearParque() {
        while (parque == null) {
            try {
                String nombre = vista.leerTexto("Nombre del parque: ");
                String codigo = vista.leerTexto("Codigo de identificacion: ");
                String encargado = vista.leerTexto("Nombre del encargado: ");
                parque = new Parque(nombre, codigo, encargado);
            } catch (IllegalArgumentException error) {
                vista.mostrarError(error.getMessage());
            }
        }
    }

    private void ejecutarMenu() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Seleccione una opcion: ");
            try {
                procesarOpcion(opcion);
            } catch (IllegalArgumentException error) {
                vista.mostrarError(error.getMessage());
            }
        } while (opcion != 0);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                habilitarPuntoAcceso();
                break;
            case 2:
                mostrarPuntosAcceso();
                break;
            case 3:
                consultarPuntoAcceso();
                break;
            case 4:
                modificarPuntoAcceso();
                break;
            case 5:
                cerrarPuntoAcceso();
                break;
            case 6:
                registrarVisitante();
                break;
            case 7:
                mostrarVisitantes();
                break;
            case 8:
                buscarVisitante();
                break;
            case 9:
                modificarVisitante();
                break;
            case 10:
                eliminarVisitante();
                break;
            case 11:
                mostrarEstadisticas();
                break;
            case 0:
                vista.mostrarMensaje("Gracias por utilizar el sistema.");
                break;
            default:
                vista.mostrarError("La opcion seleccionada no existe.");
        }
    }

    private void habilitarPuntoAcceso() {
        int posicion = vista.leerEntero("Posicion del arreglo (0-4): ");
        String codigo = vista.leerTexto("Codigo del acceso: ");
        String nombre = vista.leerTexto("Nombre del acceso: ");
        String ubicacion = vista.leerTexto("Ubicacion: ");
        int capacidad = vista.leerEntero("Capacidad maxima por hora: ");
        EstadoPuntoAcceso estado = vista.leerEstado();

        PuntoAcceso punto = new PuntoAcceso(codigo, nombre, ubicacion,
                capacidad, estado);
        if (parque.habilitarPuntoAcceso(posicion, punto)) {
            vista.mostrarMensaje("Punto de acceso habilitado correctamente.");
        } else {
            vista.mostrarError("La posicion seleccionada ya esta ocupada.");
        }
    }

    private void mostrarPuntosAcceso() {
        if (parque.contarPuntosHabilitados() == 0) {
            vista.mostrarMensaje("No hay puntos de acceso habilitados.");
            return;
        }
        for (int i = 0; i < Parque.MAXIMO_PUNTOS_ACCESO; i++) {
            PuntoAcceso punto = parque.obtenerPuntoAcceso(i);
            if (punto != null) {
                vista.mostrarPuntoAcceso(i, punto);
            }
        }
    }

    private void consultarPuntoAcceso() {
        int posicion = vista.leerEntero("Posicion del arreglo (0-4): ");
        PuntoAcceso punto = parque.obtenerPuntoAcceso(posicion);
        if (punto == null) {
            vista.mostrarError("La posicion se encuentra vacia.");
        } else {
            vista.mostrarPuntoAcceso(posicion, punto);
        }
    }

    private void modificarPuntoAcceso() {
        int posicion = vista.leerEntero("Posicion del arreglo (0-4): ");
        int capacidad = vista.leerEntero("Nueva capacidad maxima por hora: ");
        EstadoPuntoAcceso estado = vista.leerEstado();
        if (parque.modificarPuntoAcceso(posicion, capacidad, estado)) {
            vista.mostrarMensaje("Punto de acceso modificado correctamente.");
        } else {
            vista.mostrarError("La posicion se encuentra vacia.");
        }
    }

    private void cerrarPuntoAcceso() {
        int posicion = vista.leerEntero("Posicion del arreglo (0-4): ");
        if (parque.cerrarPuntoAcceso(posicion)) {
            vista.mostrarMensaje("Punto de acceso cerrado correctamente.");
        } else {
            vista.mostrarError("La posicion se encuentra vacia.");
        }
    }

    private void registrarVisitante() {
        Visitante visitante = leerDatosVisitante(null);
        if (parque.registrarVisitante(visitante)) {
            vista.mostrarMensaje("Visitante registrado correctamente.");
        } else {
            vista.mostrarError("Ya existe un visitante con ese codigo.");
        }
    }

    private void mostrarVisitantes() {
        if (parque.contarVisitantes() == 0) {
            vista.mostrarMensaje("Todavia no existen visitantes registrados.");
            return;
        }
        vista.mostrarVisitantes(parque.obtenerVisitantes());
    }

    private void buscarVisitante() {
        String codigo = vista.leerTexto("Codigo de entrada: ");
        Visitante visitante = parque.buscarVisitante(codigo);
        if (visitante == null) {
            vista.mostrarError("No se encontro un visitante con ese codigo.");
        } else {
            vista.mostrarMensaje(visitante.toString());
        }
    }

    private void modificarVisitante() {
        String codigo = vista.leerTexto("Codigo del visitante que desea modificar: ");
        if (parque.buscarVisitante(codigo) == null) {
            vista.mostrarError("No se encontro un visitante con ese codigo.");
            return;
        }
        String nombre = vista.leerTexto("Nuevo nombre: ");
        int edad = vista.leerEntero("Nueva edad: ");
        int atracciones = vista.leerEntero("Nueva cantidad de atracciones: ");
        int puntos = vista.leerEntero("Nuevos puntos acumulados: ");
        parque.modificarVisitante(codigo, nombre, edad, atracciones, puntos);
        vista.mostrarMensaje("Visitante modificado correctamente.");
    }

    private void eliminarVisitante() {
        String codigo = vista.leerTexto("Codigo del visitante que desea eliminar: ");
        if (parque.eliminarVisitante(codigo)) {
            vista.mostrarMensaje("Visitante eliminado correctamente.");
        } else {
            vista.mostrarError("No se encontro un visitante con ese codigo.");
        }
    }

    private Visitante leerDatosVisitante(String codigoExistente) {
        String codigo = codigoExistente == null
                ? vista.leerTexto("Codigo de entrada: ") : codigoExistente;
        String nombre = vista.leerTexto("Nombre: ");
        int edad = vista.leerEntero("Edad: ");
        int atracciones = vista.leerEntero("Cantidad de atracciones visitadas: ");
        int puntos = vista.leerEntero("Puntos acumulados: ");
        return new Visitante(codigo, nombre, edad, atracciones, puntos);
    }

    private void mostrarEstadisticas() {
        vista.mostrarEstadisticas(
                parque.contarPuntosHabilitados(),
                parque.contarEspaciosDisponibles(),
                parque.obtenerPuntoMayorCapacidad(),
                parque.contarVisitantes(),
                parque.obtenerVisitanteMayorPuntaje(),
                parque.obtenerVisitanteMasAtracciones(),
                parque.calcularPromedioEdad());
    }
}
