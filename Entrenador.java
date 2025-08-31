import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entrenador {
    private String id;
    private String nombre;
    private List<Miembro> miembros;

    public Entrenador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Miembro> getMiembros() { return miembros; }

    public void agregarMiembro(Miembro m) {
        if (!miembros.contains(m)) {
            miembros.add(m);
        }
    }

    public void removerMiembro(Miembro m) {
        miembros.remove(m);
    }

    public int obtenerCantidadMiembros() {
        return miembros.size();
    }

    @Override
    public String toString() {
        return String.format("Entrenador{id='%s', nombre='%s', #miembros=%d}", id, nombre, obtenerCantidadMiembros());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrenador)) return false;
        Entrenador that = (Entrenador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}