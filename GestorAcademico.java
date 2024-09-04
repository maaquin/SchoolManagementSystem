import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorAcademico implements ServiciosAcademicosI {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private Map<Curso, List<Estudiante>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = buscarCursoPorId(idCurso);
        if (curso != null) {
            List<Estudiante> inscritos = inscripciones.computeIfAbsent(curso, k -> new ArrayList<>());
            if (inscritos.contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
            }
            inscritos.add(estudiante);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = buscarCursoPorId(idCurso);
        if (curso != null) {
            List<Estudiante> inscritos = inscripciones.get(curso);
            if (inscritos != null) {
                Estudiante estudiante = buscarEstudiantePorId(idEstudiante);
                if (!inscritos.remove(estudiante)) {
                    throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
                }
            } else {
                throw new EstudianteNoInscritoEnCursoException("El curso no tiene estudiantes inscritos.");
            }
        } else {
            throw new EstudianteNoInscritoEnCursoException("El curso no es válido.");
        }
    }

    private Curso buscarCursoPorId(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getId() == idCurso) {
                return curso;
            }
        }
        return null;
    }

    private Estudiante buscarEstudiantePorId(int idEstudiante) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == idEstudiante) {
                return estudiante;
            }
        }
        return null;
    }
}