package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.EstadoPuntoAcceso;
import modelo.PuntoAcceso;
import modelo.Visitante;

public class VistaConsola {
    private final Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarBienvenida() {
        System.out.println("Bienvenido al parque universitario!");
    }

    public void mostrarMenu() {
        System.out.println("Menu principal");
        System.out.println("1. Habilitar punto de acceso");
        System.out.println("2. Consultar puntos de acceso");
        System.out.println("3. Consultar un punto por posicion");
        System.out.println("4. Modificar punto de acceso");
        System.out.println("5. Cerrar punto de acceso");
        System.out.println("6. Registrar visitante");
        System.out.println("7. Consultar visitantes");
        System.out.println("8. Buscar visitante");
        System.out.println("9. Modificar visitante");
        System.out.println("10. Eliminar visitante");
        System.out.println("11. Mostrar estadisticas");
        System.out.println("0. Salir");
    }

    public String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            mostrarError("El valor no puede estar vacio.");
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException error) {
                mostrarError("Debe ingresar un numero entero.");
                scanner.nextLine();
            }
        }
    }

    public EstadoPuntoAcceso leerEstado() {
        while (true) {
            System.out.println("1. Abierto");
            System.out.println("2. Cerrado");
            System.out.println("3. Mantenimiento");
            int opcion = leerEntero("Seleccione el estado: ");
            switch (opcion) {
                case 1:
                    return EstadoPuntoAcceso.ABIERTO;
                case 2:
                    return EstadoPuntoAcceso.CERRADO;
                case 3:
                    return EstadoPuntoAcceso.MANTENIMIENTO;
                default:
                    mostrarError("Seleccione una opcion entre 1 y 3.");
            }
        }
    }

    public void mostrarPuntoAcceso(int posicion, PuntoAcceso punto) {
        System.out.println("Posicion " + posicion + ": " + punto);
    }

    public void mostrarVisitantes(List<Visitante> visitantes) {
        for (Visitante visitante : visitantes) {
            System.out.println(visitante);
        }
    }

    public void mostrarEstadisticas(int habilitados, int disponibles,
            PuntoAcceso mayorCapacidad, int cantidadVisitantes,
            Visitante mayorPuntaje, Visitante masAtracciones, double promedioEdad) {
        System.out.println("Estadísticas");
        System.out.println("Puntos habilitados: " + habilitados);
        System.out.println("Espacios disponibles: " + disponibles);
        System.out.println("Punto con mayor capacidad: "
                + (mayorCapacidad == null ? "No hay puntos habilitados" : mayorCapacidad));
        System.out.println("Visitantes registrados: " + cantidadVisitantes);
        if (cantidadVisitantes == 0) {
            System.out.println("No hay datos de visitantes para calcular estadisticas.");
            return;
        }
        System.out.println("Visitante con mas puntos: " + mayorPuntaje);
        System.out.println("Visitante con mas atracciones: " + masAtracciones);
        System.out.printf("Promedio de edad: %.2f%n", promedioEdad);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
