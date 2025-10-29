package com.trabajo2.trabajo2.models;

import java.util.Stack;
import java.util.function.Function;

public class Estudiante {
    private String nombre;
    private Carrera carrera;
    private Categoria categoria;
    private Stack<Integer> notas;

    public Estudiante() {

    }

    public Estudiante(String nombre, Categoria categoria, Carrera carrera) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.carrera = carrera;
        this.notas = new Stack<>();
    }

    public String verNotas(Function<Estudiante, Double> funcionPromedio) {

        double promedio = funcionPromedio.apply(this);

        StringBuilder resultado = new StringBuilder();
        resultado.append("Estudiante: ").append(nombre).append("<br>");
        resultado.append("Notas: ").append(notas).append("<br>");
        resultado.append("Promedio: ").append(String.format("%.2f", promedio));

        return resultado.toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNotas(Stack<Integer> notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Stack<Integer> getNotas() {
        return notas;
    }

    public void agregarNotas(int nuevaNota) {
        notas.push(nuevaNota);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", carrera=" + carrera +
                ", categoria=" + categoria +
                ", notas=" + notas +
                '}';
    }
}
