package org.example.App.Vista;

import org.example.App.Modelo.Cita;
import org.example.App.Modelo.EstadoCita;

import java.util.List;
import java.util.Scanner;

public class CitaView {

    // Scanner para leer teclado
    private Scanner sc = new Scanner(System.in);

    // Menú principal
    public int menu() {
        System.out.println("\n=== SISTEMA CITAS ===");
        System.out.println("1 Registrar");
        System.out.println("2 Listar");
        System.out.println("3 Cambiar estado");
        System.out.println("4 Eliminar");
        System.out.println("0 Salir");

        // Lee número digitado
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirPaciente() {
        System.out.print("Paciente: ");
        return sc.nextLine();
    }

    public String pedirFecha() {
        System.out.print("Fecha: ");
        return sc.nextLine();
    }

    public int pedirId() {
        System.out.print("ID: ");
        return Integer.parseInt(sc.nextLine());
    }

    // Traduce opción numérica a ENUM
    public EstadoCita pedirEstado() {
        System.out.println("1 PROGRAMADA");
        System.out.println("2 CANCELADA");
        System.out.println("3 ATENDIDA");

        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 2: return EstadoCita.CANCELADA;
            case 3: return EstadoCita.ATENDIDA;
            default: return EstadoCita.PROGRAMADA;
        }
    }

    // Mostrar lista
    public void mostrarCitas(List<Cita> citas) {

        if (citas.isEmpty()) {
            System.out.println("Sin citas registradas");
            return;
        }

        // for-each recorre lista
        for (Cita c : citas) {
            System.out.println(c);
        }
    }
}
