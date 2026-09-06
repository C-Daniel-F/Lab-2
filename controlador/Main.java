package controlador;

import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorParque controlador = new ControladorParque(vista);
        controlador.iniciar();
    }
}
