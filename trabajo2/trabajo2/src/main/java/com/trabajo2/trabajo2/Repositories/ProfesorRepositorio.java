package com.trabajo2.trabajo2.Repositories;

import com.trabajo2.trabajo2.models.Carrera;
import com.trabajo2.trabajo2.models.Categoria;
import com.trabajo2.trabajo2.models.Estudiante;
import com.trabajo2.trabajo2.models.Profesor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class ProfesorRepositorio {

    public Profesor crearProfesorConEstudiantes() {


        Stack<Estudiante> estudiantes = new Stack<>();




        Estudiante s1 = new Estudiante("Juan Pérez", Categoria.TECNICA, Carrera.SISTEMAS);
        Estudiante s2 = new Estudiante("María Gómez", Categoria.TECNICA, Carrera.SISTEMAS);
        Estudiante s3 = new Estudiante("Carlos López", Categoria.TECNICA, Carrera.SISTEMAS);
        Estudiante s4 = new Estudiante("Ana Rodríguez", Categoria.TECNICA, Carrera.SISTEMAS);
        Estudiante s5 = new Estudiante("Pedro Martínez", Categoria.TECNICA, Carrera.SISTEMAS);
        Estudiante m1 = new Estudiante("Laura Gómez", Categoria.MAESTRIA, Carrera.MEDICINA);
        Estudiante m2 = new Estudiante("Andrés Martínez", Categoria.MAESTRIA, Carrera.MEDICINA);
        Estudiante m3 = new Estudiante("Carolina Ruiz", Categoria.MAESTRIA, Carrera.MEDICINA);
        Estudiante m4 = new Estudiante("Felipe Torres", Categoria.MAESTRIA, Carrera.MEDICINA);
        Estudiante m5 = new Estudiante("Valentina Díaz", Categoria.MAESTRIA, Carrera.MEDICINA);


        s1.agregarNotas(4);
        s1.agregarNotas(5);
        s2.agregarNotas(5);
        s2.agregarNotas(3);
        s3.agregarNotas(2);
        s3.agregarNotas(4);
        s4.agregarNotas(5);
        s4.agregarNotas(5);
        s5.agregarNotas(3);
        s5.agregarNotas(4);
        m1.agregarNotas(4);
        m1.agregarNotas(5);
        m1.agregarNotas(3);
        m2.agregarNotas(5);
        m2.agregarNotas(4);
        m3.agregarNotas(3);
        m3.agregarNotas(5);
        m3.agregarNotas(4);
        m4.agregarNotas(5);
        m4.agregarNotas(5);
        m4.agregarNotas(4);
        m5.agregarNotas(4);
        m5.agregarNotas(3);
        m5.agregarNotas(5);


        estudiantes.push(s1);
        estudiantes.push(s2);
        estudiantes.push(s3);
        estudiantes.push(s4);
        estudiantes.push(s5);
        estudiantes.push(m1);
        estudiantes.push(m2);
        estudiantes.push(m3);
        estudiantes.push(m4);
        estudiantes.push(m5);



        Iterator<Estudiante> iteradorStack = estudiantes.iterator();
        while (iteradorStack.hasNext()) {
            Estudiante est = iteradorStack.next();
            System.out.println("Nombre: " + est.getNombre() +
                    ", Categoría: " + est.getCategoria() +
                    ", Carrera: " + est.getCarrera());
        }


        Profesor profesor = new Profesor("Luis Hernández", Categoria.TECNICA, Carrera.SISTEMAS);


        Deque<Estudiante> dequeEstudiantes = new ArrayDeque<>(estudiantes);
        profesor.setEstudiantes(dequeEstudiantes);

        Iterator<Estudiante> iteradorDeque = profesor.getEstudiantes().iterator();
        while (iteradorDeque.hasNext()) {
            Estudiante est = iteradorDeque.next();
            System.out.println("Nombre: " + est.getNombre() +
                    ", Categoría: " + est.getCategoria() +
                    ", Carrera: " + est.getCarrera());
        }

        dequeEstudiantes.stream()
                .filter(e -> e.getCarrera() == Carrera.MEDICINA)
                .map(Estudiante::getNombre)
                .forEach(System.out::println);


        Function<Estudiante, Double> calcularPromedio = est ->
                est.getNotas().stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0);


        dequeEstudiantes.forEach(e -> {
            double promedio = calcularPromedio.apply(e);
            System.out.println(e.getNombre() + " → Promedio: " + promedio);

        });


        return profesor;
    }
}
