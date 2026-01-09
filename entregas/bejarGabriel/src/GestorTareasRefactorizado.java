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
                anadirTarea();
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

}