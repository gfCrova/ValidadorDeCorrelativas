### <em>Ejercicio Integrador Intermedio</em>
# <b>Validador de Correlativas</b>

> ### Consigna

implementar un programa que tome como
argumento una lista de inscripciones, y escriba en un archivo otro con la misma cantidad de
renglones, indicando que la inscripción fue aceptada o rechazada.

Un ejemplo de salida:

- José Rodríguez - Programación I - Aprobado
- Vanesa Sosa - Bases de datos I - Aprobado
- Lucia Perez - Bases de datos I - No existe el/la alumno/a
- Vanesa Sosa - Programación II - Rechazado

<p><a href="src\main\java\org\argPrograma\outputFiles\resultadoInscripciones.csv"/>Resultados De Inscripciones</a></p>

<h2>Se proponen los siguientes pasos:</h2>

- Implementar el diseño en un proyecto Maven.

- Generar 2 tests para el método Inscripción#aprobada:
  - Una materia sin correlativas
  - Una materia con correlativas y que el alumno las tenga
  - Otra materia sin correlativas, y que el alumno no las tenga
  
- Finalmente implementar el programa, puede seguir el siguiente esquema:

``` java
public static void main(String[] args) {
// Inicializar materias: crear 3 o 4 materias, con y sin correlativas
entre ellas
Collection<Materia> materias = … ;
// Inicializar los alumnos, crear 2 o 3 alumnos, con y sin materias
aprobadas.
// Usar para las materias los MISMOS objetos de la colección de más
arriba
Collection<Alumno> alumnos = … ;
// Leer el archivo parado por parámetros de args y por cada línea
// instanciar un objeto Inscripción, pero para llenar las materias y
alumnos DEBE usar los objetos que creo más arriba
// Imprimir la línea, con el resultado si la inscripción está o no ok
}
```

