import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 5, 15), Estudiante.Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "María", "Gómez", LocalDate.of(2001, 8, 21), Estudiante.Estado.MATRICULADO);

        // Crear cursos
        Curso curso1 = new Curso(101, "Programación", "Curso de programación en Java", 4, "1.0");
        Curso curso2 = new Curso(102, "Matemáticas", "Matemáticas avanzadas", 3, "1.1");

        // Matricular estudiantes
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);

        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        // Inscribir estudiantes en cursos
        try {
            gestor.inscribirEstudianteCurso(estudiante1, 101);
            gestor.inscribirEstudianteCurso(estudiante2, 101);
            gestor.inscribirEstudianteCurso(estudiante2, 102);

            // Intentar inscribir nuevamente al mismo estudiante en el mismo curso (debe lanzar excepción)
            gestor.inscribirEstudianteCurso(estudiante1, 101);
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        // Desinscribir estudiante de un curso
        try {
            gestor.desinscribirEstudianteCurso(2, 102);

            // Intentar desinscribir a un estudiante que no está inscrito (debe lanzar excepción)
            gestor.desinscribirEstudianteCurso(2, 102);
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }
    }
}