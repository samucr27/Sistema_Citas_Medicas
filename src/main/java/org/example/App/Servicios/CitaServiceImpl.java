package org.example.App.Servicios;

import org.example.App.Modelo.Cita;
import org.example.App.Modelo.EstadoCita;
import org.example.App.Servicios.CitaService;

import java.util.ArrayList;
import java.util.List;

// Implementa la interfaz → aquí va la lógica real
public class CitaServiceImpl implements CitaService {

    // Lista en memoria (simula base de datos)
    private List<Cita> citas = new ArrayList<>();

    @Override
    public void registrarCita(String paciente, String fecha) {
        // Se crea objeto Cita y se guarda
        citas.add(new Cita(paciente, fecha));
    }

    @Override
    public List<Cita> listarCitas() {
        return citas;
    }

    @Override
    public boolean cambiarEstado(int id, EstadoCita nuevoEstado) {

        // Buscar cita por ID
        for (Cita c : citas) {

            if (c.getId() == id) {

                // Una cita cancelada NO puede pasar a atendida
                if (c.getEstado() == EstadoCita.CANCELADA
                        && nuevoEstado == EstadoCita.ATENDIDA) {

                    System.out.println("Regla: cita cancelada no puede atenderse");
                    return false;
                }

                // Si pasa validación → se cambia estado
                c.setEstado(nuevoEstado);
                return true;
            }
        }

        // No se encontró ID
        return false;
    }

    @Override
    public boolean eliminarCita(int id) {

        // removeIf usa función lambda
        // Elimina si la condición se cumple
        return citas.removeIf(c -> c.getId() == id);
    }
}
