package org.argPrograma.services;

import org.argPrograma.entities.Alumno;
import org.argPrograma.entities.InscripcionEnum;
import org.argPrograma.entities.Materia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CorrelativasService {

    private final FilesService fileServicio;
    private final AlumnosService alumnosService = new AlumnosService();
    private List<Materia> materiasAprobadas;
    private List<String> materiasCorrelativas;

    public CorrelativasService(FilesService fileServicio) {
        this.fileServicio = fileServicio;
    }

    public void buscarCorrelativas(String materia) throws IOException{
        String lineaMateria = buscarMateria(materia);
        String[] arrCorrelativas = lineaMateria.split(",");

        materiasCorrelativas = new ArrayList<String>();

        if (arrCorrelativas.length > 1) {
            for (int i = 1; i < arrCorrelativas.length; i++) {
                materiasCorrelativas.add(arrCorrelativas[i]);
            }
            System.out.println("Correlativas para la materia '" + materia + "' son: " + Arrays.toString(materiasCorrelativas.get(0).split(" ")));
        }
    }

    public List<Materia> buscarMateriasAprobadas(int legajo) throws IOException {
        String lineaAlumno = alumnosService.buscarAlumnos(legajo);
        List<String> arrAlumno = List.of(lineaAlumno.split(","));

        materiasAprobadas = new ArrayList<Materia>();

        if (arrAlumno.size() > 2) {
            for (int i = 2; i < arrAlumno.size(); i++) {
                Materia mt = new Materia(arrAlumno.get(i));
                materiasAprobadas.add(mt);
            }
            System.out.println("Materias Aprobadas: " + Arrays.toString(materiasAprobadas.get(0).getNombre().split(" ")));
        }
        return materiasAprobadas;
    }

    public InscripcionEnum validarInscripcion() {

        for (int i = 0; i < materiasCorrelativas.size(); i++) {
            if (materiasCorrelativas.contains(materiasAprobadas.get(i).getNombre())) {
                System.out.println("SOLICITUD: " + InscripcionEnum.APROBADA);
                return InscripcionEnum.APROBADA;
            }
        }
        System.out.println("SOLICITUD: " + InscripcionEnum.RECHAZADA);
        return InscripcionEnum.RECHAZADA;
    }

    public String buscarMateria(String materia) throws IOException {

        List<String> readMaterias = fileServicio.leerMaterias();
        String lineaMateria = "";

        for (String linea : readMaterias) {
            String mat = linea.split(",")[0];
            if (materia.equals(mat)) {
                lineaMateria = linea;
            }
        }
        return lineaMateria;
    }
}
