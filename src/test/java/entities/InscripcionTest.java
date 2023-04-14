package entities;

import org.argPrograma.entities.Alumno;
import org.argPrograma.entities.Inscripcion;
import org.argPrograma.entities.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
class InscripcionTest {

    Inscripcion objInscripcionTest;
    static Materia materia1;
    static Materia materia2;
    static Materia materia3;


    @BeforeAll
    public static void beforeAll() throws IOException {

        materia1 = new Materia("MatematicaI");
        materia2 = new Materia("MatematicaII");
        materia3 = new Materia("MatematicaIII");
        materia2.agregarCorrelativa(materia1);
        materia3.agregarCorrelativa(materia1);
        materia3.agregarCorrelativa(materia2);
    }

    @BeforeEach
    public void setUp() {
        objInscripcionTest = new Inscripcion();
    }

    @Test
    void aprobadaTrue() {

        Alumno alu = new Alumno("José", 6288);
        alu.agregarMateriaAprobada(materia1);
        alu.agregarMateriaAprobada(materia2);
        Inscripcion inscripcion1 = new Inscripcion(alu, materia3);

        boolean estaAprobado = inscripcion1.aprobada();
        boolean valorEsperado = true;
        boolean resultado = ( estaAprobado == valorEsperado);

        assertTrue(resultado);
    }
}