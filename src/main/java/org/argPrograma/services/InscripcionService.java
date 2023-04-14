package org.argPrograma.services;

import org.argPrograma.entities.InscripcionEnum;
import org.argPrograma.entities.Materia;

import java.io.IOException;
import java.util.List;

public class InscripcionService {

    private final FilesService fileServicio;

    private final CorrelativasService correlativasService;
    private final AlumnosService alumnosService = new AlumnosService();

    public InscripcionService(FilesService fileServicio, CorrelativasService correlativasService) {
        this.fileServicio = fileServicio;
        this.correlativasService = correlativasService;
    }

    public void registrarInscripcion() throws IOException {
        List<String> lineas = fileServicio.leerInscripciones();

        for (int i = 0; i < lineas.size(); i++) {

            if (i != 0) {
                String linea = lineas.get(i);
                String alumno = linea.split(",")[0];
                int legajo = Integer.parseInt(linea.split(",")[1]);
                String materiaInscripcion = linea.split(",")[2];
                System.out.println("ALUMNO: " + alumno + ". LEGAJO: " + legajo + ".");
                System.out.println("Solicita inscribirse a: '" + materiaInscripcion + "'");

                Materia matInscripcion = new Materia(materiaInscripcion);
                correlativasService.buscarCorrelativas(materiaInscripcion);

                alumnosService.registrarAlumnos(alumno, legajo, matInscripcion, correlativasService.buscarMateriasAprobadas(legajo), correlativasService.validarInscripcion());
                System.out.println("\n");
            }
        }
    }
}
