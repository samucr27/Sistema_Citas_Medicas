package org.example.App.Modelo;

import org.example.App.Modelo.EstadoCita;

public class Cita {

    // Variable estática para generar ID automático
    // Se comparte entre todas las citas
    private static int contador = 1;

    private int id;
    private String paciente;
    private String fecha;
    private EstadoCita estado;

    public Cita(String paciente, String fecha) {
        // ID automático — regla del ejercicio
        this.id = contador++;

        this.paciente = paciente;
        this.fecha = fecha;

        // Toda cita inicia PROGRAMADA
        this.estado = EstadoCita.PROGRAMADA;
    }

    public int getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Paciente: " + paciente +
                " | Fecha: " + fecha +
                " | Estado: " + estado;
    }
}
