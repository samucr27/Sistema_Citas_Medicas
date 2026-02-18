package org.example.App.Controller;

import org.example.App.Modelo.Cita;
import org.example.App.Modelo.EstadoCita;
import org.example.App.Servicios.CitaService;

import java.util.List;

public class CitaController {

    // Depende del servicio (inyección por constructor)
    private CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    // Métodos que la vista puede llamar

    public void crearCita(String paciente, String fecha) {
        service.registrarCita(paciente, fecha);
    }

    public List<Cita> obtenerCitas() {
        return service.listarCitas();
    }

    public void actualizarEstado(int id, EstadoCita estado) {

        // Si falla la validación del servicio → mensaje
        if (!service.cambiarEstado(id, estado)) {
            System.out.println("No se pudo cambiar el estado");
        }
    }

    public void borrarCita(int id) {
        if (!service.eliminarCita(id)) {
            System.out.println("No existe la cita");
        }
    }
}
