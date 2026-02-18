package org.example.App.Servicios;

import org.example.App.Modelo.Cita;
import org.example.App.Modelo.EstadoCita;

import java.util.List;

// Interfaz = contrato de métodos que deben implementarse
public interface CitaService {

    // Crear cita
    void registrarCita(String paciente, String fecha);

    // Obtener todas las citas
    List<Cita> listarCitas();

    // Cambiar estado con validaciones
    boolean cambiarEstado(int id, EstadoCita nuevoEstado);

    // Eliminar por ID
    boolean eliminarCita(int id);
}
