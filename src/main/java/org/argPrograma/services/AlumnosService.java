package org.argPrograma.services;

import org.argPrograma.entities.Alumno;
import org.argPrograma.entities.Inscripcion;
import org.argPrograma.entities.InscripcionEnum;
import org.argPrograma.entities.Materia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosService {

    private final FilesService fileServicio = new FilesService();

    public String buscarAlumnos(int legajo) throws IOException {
        String lineStr = "";
        List<String> lineaAlumnos = fileServicio.leerAlumnos();

        for (int i = 0; i < lineaAlumnos.size(); i++) {
            if (i != 0) {
                String lineas = lineaAlumnos.get(i);
                int leg = Integer.parseInt(lineas.split(",")[1]);
                if (leg == legajo) {
                    lineStr = lineas;
                }
            }
        }
        return lineStr;
    }

    public void registrarAlumnos(String nombre, int legajo, Materia matDeInscripcion, List<Materia> matAprobadas, InscripcionEnum solicitud) throws IOException{

        Alumno alumno = new Alumno(nombre, legajo, matAprobadas);
        ArrayList<Alumno> alumnos = new ArrayList<>();
        if(alumno.getNombre().equals("")) {
            alumno.setNombre("No existe el/la alumno");
        }else {
            if(legajo <= 0 ) {
                alumno.setLegajo(0);
            } else {
                if (matDeInscripcion.getNombre().equals("")) {
                    int i = 0;
                    while(i < matAprobadas.size()) {
                        alumno.getMateriasAprobadas().get(i).setNombre("");
                        i++;
                    }
                    matDeInscripcion.setNombre("");
                    solicitud = null;
                }
            }
        }
        alumnos.add(new Alumno(nombre, legajo));

        Inscripcion inscripcion = new Inscripcion(alumno, matDeInscripcion, solicitud);

        for (int i = 0; i < alumnos.size(); i++) {
            fileServicio.guardarResultados(inscripcion);
        }
    }
}
