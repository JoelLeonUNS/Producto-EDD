package paqueteproducto;

public class Imprimir {

    public static void cola(Cola cola, String[] array, int disp) {
        line(array, disp);
        index(array, disp);
        line(array, disp);
        data(array, disp);
        line(array, disp);
        indFreFin(array, cola.frente, cola.fin, disp);
        System.out.println(""); // salto de línea
    }

    public static void indFreFin(String[] array, int frente, int fin, int disp) {
        displacement(disp);
        for (int i = 0; i < array.length && frente != -1; i++) { // frente != -1, no se imprime
            System.out.print(i == frente ? "  Frente --^" : "");
            System.out.print(i < fin ? "       " : ""); // espacio entre Frente y Final
            System.out.print(i == fin ? "^-- Final\n" : ""); // "\n" salto de línea
        }
    }

    public static void index(String[] array, int disp) {
        displacement(disp);
        System.out.print("¦ Índice "); // no dinámico
        for (int i = 0; i < array.length; i++) {
            System.out.print("¦" + spaceI(i) + ((i == array.length - 1) ? "¦\n" : ""));
        }
    }

    public static void data(String[] array, int disp) {
        displacement(disp);
        System.out.print("¦  COLA  "); // no dinámico
        for (int i = 0; i < array.length; i++) {
            System.out.print("¦" + space(array[i]) + ((i == array.length - 1) ? "¦\n" : ""));
        }
    }

    public static void line(String[] array, int disp) {
        displacement(disp);
        System.out.print("+--------"); // no dinámico
        for (int i = 0; i < array.length; i++) {
            System.out.print("+------" + ((i == array.length - 1) ? "+\n" : ""));
        }
    }

    // Extras
    public static String spaceI(int dato) {
        String imp = "  " + dato + "         ";
        return imp.substring(0, 6);
    }

    public static String space(String dato) {
        String imp = " " + dato + "         ";
        return imp.substring(0, 6);
    }

    public static void displacement(int disp) {
        for (int i = 0; i < disp; i++) {
            System.out.print(" "); // desplazamiento
        }
    }

}
