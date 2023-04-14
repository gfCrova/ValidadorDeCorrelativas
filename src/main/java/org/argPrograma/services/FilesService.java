package org.argPrograma.services;

import org.argPrograma.entities.Alumno;
import org.argPrograma.entities.Inscripcion;
import org.argPrograma.entities.InscripcionEnum;
import org.argPrograma.entities.Materia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesService {

    public FilesService() {
    }

    private final String pathInscripciones = "src\\main\\java\\org\\argPrograma\\inputFiles\\inscripciones.csv";
    private final String pathMaterias = "src\\main\\java\\org\\argPrograma\\inputFiles\\materias.csv";
    private final String pathAlumnos = "src\\main\\java\\org\\argPrograma\\inputFiles\\alumnos.csv";
    private final String pathResultados = "src\\main\\java\\org\\argPrograma\\outputFiles\\resultadoInscripciones.csv";

    public List<String> leerInscripciones() throws IOException {
        Path file = Paths.get(pathInscripciones);
        return Files.readAllLines(file);
    }

    public List<String> leerMaterias() throws IOException {
        Path file = Paths.get(pathMaterias);
        return Files.readAllLines(file);
    }

    public List<String> leerAlumnos() throws IOException {
        Path file = Paths.get(pathAlumnos);
        return Files.readAllLines(file);
    }

    public void guardarResultados(Inscripcion inscripcion) throws IOException {
        Files.writeString(Paths.get(pathResultados), inscripcion.grabarArchivo() + "\n", StandardOpenOption.APPEND);
    }
}
