package org.argPrograma.entities;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public void agregarCorrelativa(Materia materia) {
        this.correlativas.add(materia);
    }

    public boolean puedeCursar(Alumno alumno) {

        boolean puedeCursar = true;

        for (int i = 0; i < correlativas.size(); i++) {
            System.out.println("correlativa: " + correlativas.get(i));
            if (!alumno.getMateriasAprobadas().contains(correlativas.get(i))) {
                puedeCursar = false;
            }
        }
        return puedeCursar;
    }

    @Override
    public String toString() {
        return nombre;}
}