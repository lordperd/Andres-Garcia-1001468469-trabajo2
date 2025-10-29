package com.trabajo2.trabajo2.Controllers;

import com.trabajo2.trabajo2.Repositories.ProfesorRepositorio;
import com.trabajo2.trabajo2.models.Estudiante;
import com.trabajo2.trabajo2.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Controller
@RequestMapping("/profesores")
public class profesorcontroller {

    private ProfesorRepositorio profesorRepositorio;

    @Autowired
    public profesorcontroller(ProfesorRepositorio profesorRepositorio) {
        this.profesorRepositorio = profesorRepositorio;
    }
    @GetMapping
    public String mostrarProfesor(Model model) {

        Profesor profesor = profesorRepositorio.crearProfesorConEstudiantes();

        Function<Estudiante, Double> calcularPromedio = e ->
                e.getNotas().stream().mapToInt(Integer::intValue).average().orElse(0.0);

        Map<String, Double> promedios = new HashMap<>();
        profesor.getEstudiantes().forEach(est ->
                promedios.put(est.getNombre(), calcularPromedio.apply(est))
        );

        List<Estudiante> grupoProfesor = profesor.getEstudiantes().stream()
                .filter(e -> e.getCategoria() == profesor.getCategoria() && e.getCarrera() == profesor.getCarrera())
                .toList();

        Map<String, List<Estudiante>> grupos = new HashMap<>();
        profesor.getEstudiantes().forEach(est -> {
            String clave = est.getCategoria() + " - " + est.getCarrera();
            grupos.computeIfAbsent(clave, k -> new ArrayList<>()).add(est);
        });

        String resultadoVerNotas = null;
        if (!grupoProfesor.isEmpty()) {
            Estudiante estudianteEjemplo = grupoProfesor.get(0);
            resultadoVerNotas = estudianteEjemplo.verNotas(calcularPromedio);
        }

        model.addAttribute("profesor", profesor);
        model.addAttribute("promedios", promedios);
        model.addAttribute("grupoProfesor", grupoProfesor);
        model.addAttribute("grupos", grupos);
        model.addAttribute("resultadoVerNotas", resultadoVerNotas);

        return "profesor";
    }
}
