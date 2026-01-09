import java.util.Scanner;

public class GestorTareasRefactorizado {

    private static final int CAPACIDAD_MAXIMA = 10;
    
    private static String[] descripciones = new String[CAPACIDAD_MAXIMA];
    private static String[] prioridades = new String[CAPACIDAD_MAXIMA];
    private static boolean[] tareasCompletadas = new boolean[CAPACIDAD_MAXIMA];
    
    private static int cantidadTareas = 0;
}