package org.example.App;

import org.example.App.Controller.CitaController;
import org.example.App.Modelo.EstadoCita;
import org.example.App.Servicios.CitaService;
import org.example.App.Servicios.CitaServiceImpl;
import org.example.App.Vista.CitaView;

public class Main {

    public static void main(String[] args) {

        // Crear capas
        CitaService service = new CitaServiceImpl();
        CitaController controller = new CitaController(service);
        CitaView view = new CitaView();


        // Registrar citas
        controller.crearCita("Ana Torres", "2026-03-01");
        controller.crearCita("Luis Perez", "2026-03-02");
        controller.crearCita("Maria Gomez", "2026-03-03");

        // Listar
        view.mostrarCitas(controller.obtenerCitas());

        // Cambiar estado
        controller.actualizarEstado(1, EstadoCita.ATENDIDA);
        controller.actualizarEstado(2, EstadoCita.CANCELADA);

        // Intento inválido (regla del sistema)
        controller.actualizarEstado(2, EstadoCita.ATENDIDA);

        // Listar otra vez
        view.mostrarCitas(controller.obtenerCitas());

        // Eliminar cita
        controller.borrarCita(3);

        // Lista final
        view.mostrarCitas(controller.obtenerCitas());
    }
}
