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
    
    private static void marcarTareaCompletada() {
        if (cantidadTareas > 0) {
            listarTodasLasTareas();
            int indice = leerEntero("Número de tarea a completar: ") - 1;

            if (esIndiceValido(indice)) {
                if (tareasCompletadas[indice]) {
                    System.out.println("Esa tarea ya estaba completada.");
                } else {
                    tareasCompletadas[indice] = true;
                    System.out.println("¡Tarea completada!");
                }
            } else {
                System.out.println("Número de tarea inválido.");
            }
        } else {
            System.out.println("No hay tareas registradas.");
        }
    }
    
    private static void verTareasPendientes() {
        System.out.println("--- Tareas Pendientes ---");
        boolean hayPendientes = false;

        for (int i = 0; i < cantidadTareas; i++) {
            if (!tareasCompletadas[i]) {
                imprimirTarea(i);
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("(No tienes tareas pendientes)");
        }
    }
    
    private static void mostrarEstadisticas() {
        int completadas = 0;
        
        for (int i = 0; i < cantidadTareas; i++) {
            if (tareasCompletadas[i]) {
                completadas++;
            }
        }
        
        int pendientes = cantidadTareas - completadas;
        double porcentaje = 0.0;
        
        if (cantidadTareas > 0) {
            porcentaje = ((double) completadas / cantidadTareas) * 100;
        }

        System.out.println("--- Estadísticas de Progreso ---");
        System.out.println("Total tareas: " + cantidadTareas);
        System.out.println("Completadas:  " + completadas);
        System.out.println("Pendientes:   " + pendientes);
        System.out.println("Progreso:   " + porcentaje);
    }

    private static void listarTodasLasTareas() {
        for (int i = 0; i < cantidadTareas; i++) {
            String estado = "[ ]";
            if (tareasCompletadas[i]) {
                estado = "[X]";
            }
            System.out.println((i + 1) + ". " + estado + " " + descripciones[i] + " (" + prioridades[i] + ")");
        }
    }

    private static void imprimirTarea(int i) {
        System.out.println("- " + descripciones[i] + " [Prioridad: " + prioridades[i] + "]");
    }

    private static boolean esIndiceValido(int indice) {
        return (indice >= 0 && indice < cantidadTareas);
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        boolean entradaValida = false;
        int numero = 0;

        while (!entradaValida) {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
                System.out.print(mensaje);
            }
        }
        
        scanner.nextLine();
        return numero;
    }

}