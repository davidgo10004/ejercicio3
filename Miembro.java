import java.util.Objects;

public class Miembro {
    private String id;
    private String nombre;
    private String tipoMembresia;
    private Entrenador entrenadorAsignado;
    private Rutina rutinaAsignada;

    public Miembro(String id, String nombre, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMembresia = tipoMembresia;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoMembresia() { return tipoMembresia; }

    public Entrenador getEntrenadorAsignado() { return entrenadorAsignado; }
    public Rutina getRutinaAsignada() { return rutinaAsignada; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipoMembresia(String tipo) { this.tipoMembresia = tipo; }

    public void asignarEntrenador(Entrenador e) {
        this.entrenadorAsignado = e;
    }

    public void asignarRutina(Rutina r) {
        this.rutinaAsignada = r;
    }

    @Override
    public String toString() {
        String ent = (entrenadorAsignado == null) ? "Ninguno" : entrenadorAsignado.getNombre();
        String rut = (rutinaAsignada == null) ? "Ninguna" : rutinaAsignada.getNombre();
        return String.format("Miembro{id='%s', nombre='%s', membresia='%s', entrenador='%s', rutina='%s'}",
                id, nombre, tipoMembresia, ent, rut);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Miembro)) return false;
        Miembro miembro = (Miembro) o;
        return Objects.equals(id, miembro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}