import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Gimnasio gimnasio = new Gimnasio();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione opción: ");
            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1": crearNuevoMiembro(gimnasio, sc); break;
                case "2": crearNuevoEntrenador(gimnasio, sc); break;
                case "3": crearNuevaRutina(gimnasio, sc); break;
                case "4": asignarEntrenadorAMiembro(gimnasio, sc); break;
                case "5": asignarRutinaAMiembro(gimnasio, sc); break;
                case "6": listarMiembros(gimnasio); break;
                case "7": listarEntrenadores(gimnasio); break;
                case "8": listarRutinas(gimnasio); break;
                case "9": mostrarRutinaMasPopular(gimnasio); break;
                case "10": mostrarNumeroRutinasActivas(gimnasio); break;
                case "11": mostrarEntrenadorConMasAlumnos(gimnasio); break;
                case "0": salir = true; break;
                default: System.out.println("Opción no válida.");
            }
            System.out.println();
        }
        sc.close();
        System.out.println("Adiós.");
    }

    private static void mostrarMenu() {
        System.out.println("=== Gimnasio - Menú ===");
        System.out.println("1. Nuevo miembro");
        System.out.println("2. Nuevo entrenador");
        System.out.println("3. Nueva rutina");
        System.out.println("4. Asignar entrenador a miembro");
        System.out.println("5. Asignar rutina a miembro");
        System.out.println("6. Listar miembros");
        System.out.println("7. Listar entrenadores");
        System.out.println("8. Listar rutinas");
        System.out.println("9. Mostrar rutina más popular");
        System.out.println("10. Mostrar número de rutinas activas");
        System.out.println("11. Mostrar entrenador con más alumnos");
        System.out.println("0. Salir");
    }

    private static void crearNuevoMiembro(Gimnasio g, Scanner sc) {
        System.out.print("ID miembro: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Tipo de membresía: ");
        String tipo = sc.nextLine().trim();
        Miembro m = new Miembro(id, nombre, tipo);
        g.agregarMiembro(m);
        System.out.println("Miembro agregado.");
    }

    private static void crearNuevoEntrenador(Gimnasio g, Scanner sc) {
        System.out.print("ID entrenador: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        Entrenador e = new Entrenador(id, nombre);
        g.agregarEntrenador(e);
        System.out.println("Entrenador agregado.");
    }

    private static void crearNuevaRutina(Gimnasio g, Scanner sc) {
        System.out.print("ID rutina: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre rutina: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Descripción: ");
        String desc = sc.nextLine().trim();
        Rutina r = new Rutina(id, nombre, desc);
        g.agregarRutina(r);
        System.out.println("Rutina agregada.");
    }

    private static void asignarEntrenadorAMiembro(Gimnasio g, Scanner sc) {
        System.out.print("ID miembro: ");
        String idM = sc.nextLine().trim();
        System.out.print("ID entrenador: ");
        String idE = sc.nextLine().trim();
        boolean ok = g.asignarEntrenadorAMiembro(idM, idE);
        System.out.println(ok ? "Entrenador asignado." : "Error: id no encontrado.");
    }

    private static void asignarRutinaAMiembro(Gimnasio g, Scanner sc) {
        System.out.print("ID miembro: ");
        String idM = sc.nextLine().trim();
        System.out.print("ID rutina: ");
        String idR = sc.nextLine().trim();
        boolean ok = g.asignarRutinaAMiembro(idM, idR);
        System.out.println(ok ? "Rutina asignada." : "Error: id no encontrado.");
    }

    private static void listarMiembros(Gimnasio g) {
        System.out.println("Miembros:");
        for (Miembro m : g.obtenerMiembros()) System.out.println("  " + m);
    }

    private static void listarEntrenadores(Gimnasio g) {
        System.out.println("Entrenadores:");
        for (Entrenador e : g.obtenerEntrenadores()) System.out.println("  " + e);
    }

    private static void listarRutinas(Gimnasio g) {
        System.out.println("Rutinas:");
        for (Rutina r : g.obtenerRutinas()) System.out.println("  " + r);
    }

    private static void mostrarRutinaMasPopular(Gimnasio g) {
        Rutina r = g.obtenerRutinaMasPopular();
        if (r == null) System.out.println("No hay rutinas o participantes.");
        else System.out.println("Rutina más popular: " + r);
    }

    private static void mostrarNumeroRutinasActivas(Gimnasio g) {
        int n = g.obtenerNumeroRutinasActivas();
        System.out.println("Número de rutinas activas: " + n);
    }

    private static void mostrarEntrenadorConMasAlumnos(Gimnasio g) {
        Entrenador e = g.obtenerEntrenadorConMasAlumnos();
        if (e == null) System.out.println("No hay entrenadores.");
        else System.out.println("Entrenador con más alumnos: " + e);
    }
}