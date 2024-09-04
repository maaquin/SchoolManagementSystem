import java.time.LocalDate;

public class Estudiante extends Persona {
    private Estado estado;

    public enum Estado {
        MATRICULADO,
        INACTIVO,
        GRADUADO
    }

    public Estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, Estado estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    // Getters y setters
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", fechaDeNacimiento=" + getFechaDeNacimiento() +
                ", estado=" + estado +
                '}';
    }
}