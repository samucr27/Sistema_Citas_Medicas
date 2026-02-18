package org.example.App.Vista;

import org.example.App.Modelo.Cita;

import java.util.List;

public class CitaView {

    public void mostrarCitas(List<Cita> citas) {

        System.out.println("\n=== LISTA DE CITAS ===");

        if (citas.isEmpty()) {
            System.out.println("Sin citas");
            return;
        }

        for (Cita c : citas) {
            System.out.println(c);
        }
    }
}
