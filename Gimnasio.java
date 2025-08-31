import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private List<Miembro> miembros;
    private List<Entrenador> entrenadores;
    private List<Rutina> rutinas;

    public Gimnasio() {
        miembros = new ArrayList<>();
        entrenadores = new ArrayList<>();
        rutinas = new ArrayList<>();
    }

    public void agregarMiembro(Miembro m) { miembros.add(m); }
    public void agregarEntrenador(Entrenador e) { entrenadores.add(e); }
    public void agregarRutina(Rutina r) { rutinas.add(r); }

    public Miembro buscarMiembroPorId(String id) {
        return miembros.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
    public Entrenador buscarEntrenadorPorId(String id) {
        return entrenadores.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
    public Rutina buscarRutinaPorId(String id) {
        return rutinas.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean asignarEntrenadorAMiembro(String idMiembro, String idEntrenador) {
        Miembro m = buscarMiembroPorId(idMiembro);
        Entrenador e = buscarEntrenadorPorId(idEntrenador);
        if (m == null || e == null) return false;
        if (m.getEntrenadorAsignado() != null) {
            m.getEntrenadorAsignado().removerMiembro(m);
        }
        m.asignarEntrenador(e);
        e.agregarMiembro(m);
        return true;
    }

    public boolean asignarRutinaAMiembro(String idMiembro, String idRutina) {
        Miembro m = buscarMiembroPorId(idMiembro);
        Rutina r = buscarRutinaPorId(idRutina);
        if (m == null || r == null) return false;
        if (m.getRutinaAsignada() != null) {
            m.getRutinaAsignada().removerParticipante(m);
        }
        m.asignarRutina(r);
        r.agregarParticipante(m);
        return true;
    }

    public Rutina obtenerRutinaMasPopular() {
        Rutina top = null;
        int max = -1;
        for (Rutina r : rutinas) {
            int c = r.obtenerCantidadParticipantes();
            if (c > max) {
                max = c;
                top = r;
            }
        }
        return top;
    }

    public int obtenerNumeroRutinasActivas() {
        int total = 0;
        for (Rutina r : rutinas) if (r.obtenerCantidadParticipantes() > 0) total++;
        return total;
    }

    public Entrenador obtenerEntrenadorConMasAlumnos() {
        Entrenador top = null;
        int max = -1;
        for (Entrenador e : entrenadores) {
            int c = e.obtenerCantidadMiembros();
            if (c > max) {
                max = c;
                top = e;
            }
        }
        return top;
    }

    public List<Miembro> obtenerMiembros() { return miembros; }
    public List<Entrenador> obtenerEntrenadores() { return entrenadores; }
    public List<Rutina> obtenerRutinas() { return rutinas; }
}