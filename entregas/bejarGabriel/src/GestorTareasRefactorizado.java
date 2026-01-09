import java.util.Scanner;

public class GestorTareasRefactorizado {

    private static final int CAPACIDAD_MAXIMA = 10;
    
    private static String[] descripciones = new String[CAPACIDAD_MAXIMA];
    private static String[] prioridades = new String[CAPACIDAD_MAXIMA];
    private static boolean[] tareasCompletadas = new boolean[CAPACIDAD_MAXIMA];
    
    private static int cantidadTareas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        System.out.println("=== Gestor de Tareas v2.0==");

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            if (opcion == 1) {
                añadirTarea(){
            } else if (opcion == 2) {
                marcarTareaCompletada();
            } else if (opcion == 3) {
                verTareasPendientes();
            } else if (opcion == 4) {
                mostrarEstadisticas();
            } else if (opcion == 5) {
                System.out.println("Cerrando aplicación...");
                continuar = false;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
            
            System.out.println(); 
        }
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("---------------------------");
        System.out.println("[1] Añadir nueva tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadísticas");
        System.out.println("[5] Salir");
        System.out.println("---------------------------");
    }

    private static void añadirTarea(){
        if (cantidadTareas < CAPACIDAD_MAXIMA) {
            System.out.print("Descripción de la tarea: ");
            String descripcion = scanner.nextLine();
            
            String prioridad = seleccionarPrioridad();

            descripciones[cantidadTareas] = descripcion;
            prioridades[cantidadTareas] = prioridad;
            tareasCompletadas[cantidadTareas] = false; 
            
            cantidadTareas++;
            System.out.println("Tarea guardada con éxito.");
        } else {
            System.out.println("ERROR: La lista de tareas está llena.");
        }
    }
    
    private static String seleccionarPrioridad() {
        System.out.println("Seleccione prioridad: [1] Alta, [2] Media, [3] Baja");
        int seleccion = leerEntero("Opción: ");
        String prioridadSeleccionada = "Media";
        
        if (seleccion == 1) {
            prioridadSeleccionada = "Alta";
        } else if (seleccion == 3) {
            prioridadSeleccionada = "Baja";
        }
        
        return prioridadSeleccionada;
    }

}