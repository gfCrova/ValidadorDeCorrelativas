package org.argPrograma;

import org.argPrograma.services.AlumnosService;
import org.argPrograma.services.CorrelativasService;
import org.argPrograma.services.FilesService;
import org.argPrograma.services.InscripcionService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FilesService fileServicio = new FilesService();
        CorrelativasService correlativasService = new CorrelativasService(fileServicio);
        InscripcionService inscripcionService = new InscripcionService(fileServicio, correlativasService);
        inscripcionService.registrarInscripcion();
    }
}