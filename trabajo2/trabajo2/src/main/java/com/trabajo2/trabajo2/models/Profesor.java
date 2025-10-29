package com.trabajo2.trabajo2.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class Profesor {
    private String nombre;
    private Categoria categoria;
    private Carrera carrera;
    private Deque<Estudiante> estudiantes;

    public Profesor() {
        this.estudiantes = new ArrayDeque<>();
    }

    public Profesor(String nombre, Categoria categoria, Carrera carrera) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.carrera = carrera;
        this.estudiantes = new ArrayDeque<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setEstudiantes(Deque<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // 🔹 Getters
    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Deque<Estudiante> getEstudiantes() {
        return estudiantes;
    }


    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", carrera=" + carrera +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
