package org.example.App;

import org.example.App.Controller.CitaController;
import org.example.App.Servicios.CitaService;
import org.example.App.Servicios.CitaServiceImpl;
import org.example.App.Vista.CitaView;

public class Main {

    public static void main(String[] args) {

        // ====== CONSTRUCCIÓN DE CAPAS ======

        // Servicio → lógica
        CitaService service = new CitaServiceImpl();

        // Controlador → puente vista-servicio
        CitaController controller = new CitaController(service);

        // Vista → consola
        CitaView view = new CitaView();

        int op;

        // Ciclo del menú
        do {

            op = view.menu();

            switch (op) {

                case 1:
                    // Crear cita usando datos de vista
                    controller.crearCita(
                            view.pedirPaciente(),
                            view.pedirFecha());
                    break;

                case 2:
                    // Mostrar citas
                    view.mostrarCitas(
                            controller.obtenerCitas());
                    break;

                case 3:
                    // Cambiar estado
                    controller.actualizarEstado(
                            view.pedirId(),
                            view.pedirEstado());
                    break;

                case 4:
                    // Eliminar
                    controller.borrarCita(
                            view.pedirId());
                    break;
            }

        } while (op != 0); // termina cuando usuario pone 0
    }
}
