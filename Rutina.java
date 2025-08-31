import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rutina {
    private String id;
    private String nombre;
    private String descripcion;
    private List<Miembro> participantes;

    public Rutina(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.participantes = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Miembro> getParticipantes() { return participantes; }

    public void agregarParticipante(Miembro m) {
        if (!participantes.contains(m)) participantes.add(m);
    }

    public void removerParticipante(Miembro m) {
        participantes.remove(m);
    }

    public int obtenerCantidadParticipantes() {
        return participantes.size();
    }

    @Override
    public String toString() {
        return String.format("Rutina{id='%s', nombre='%s', participantes=%d}", id, nombre, obtenerCantidadParticipantes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rutina)) return false;
        Rutina rutina = (Rutina) o;
        return Objects.equals(id, rutina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}