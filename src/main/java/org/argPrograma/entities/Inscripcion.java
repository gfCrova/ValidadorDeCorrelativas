package org.argPrograma.entities;

import java.util.Date;

public class Inscripcion {
    private Alumno alumno;
    private Materia materiaInscripcion;

    private InscripcionEnum solicitud;
    private Date fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materiaInscripcion) {
        this.alumno = alumno;
        this.materiaInscripcion = materiaInscripcion;
        this.fechaInscripcion = new Date();
    }

    public Inscripcion(Alumno alumno, Materia materiaInscripcion, InscripcionEnum solicitud) {
        this.alumno = alumno;
        this.materiaInscripcion = materiaInscripcion;
        this.solicitud = solicitud;
        this.fechaInscripcion = new Date();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materiaInscripcion;
    }

    public void setMateria(Materia materia) {
        this.materiaInscripcion = materia;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean aprobada() {
        return materiaInscripcion.puedeCursar(alumno);
    }

    public String grabarArchivo() {
        return alumno + "," + materiaInscripcion + "," + solicitud + "," + fechaInscripcion;
    }

    @Override
    public String toString() {
        return  materiaInscripcion.getNombre() + "," + fechaInscripcion;
    }
}