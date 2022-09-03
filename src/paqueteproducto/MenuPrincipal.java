package paqueteproducto;

import java.util.Scanner;

public class MenuPrincipal {

    static Scanner input = new Scanner(System.in);
    static int FINAL = -1, FRENTE = -1, TOPE = -1, FONDO = -1, itr;
    static Cola colaOperador,colaExponente;

    public static void main(String[] args) {
        int op;

        do {
            System.out.println("\n\t::::::: MENÚ :::::::");
            System.out.println("1. Ejecutar el programa con los valores \npreestablecidos del caso propuesto.");
            System.out.println("2. Ejecutar el programa introduciendo \nvalores por teclado.");
            System.out.println("3. Salir.");
            System.out.print("Opción: ");
            op = input.nextInt();

            switch (op) {
                case 1 -> {
                    menuValoresPreestablecidos();
                }
                case 2 -> {
                    itr = 0;
                    menuValoresPorTeclado();
                }
                case 3 -> {

                }
                default -> {
                    System.out.println("\nError, opción no encontrada.\n");
                }
            }
        } while (op != 3);

    }

    public static void menuValoresPreestablecidos() {

        // se define el tamaño de la cola y pila
        String[] cola = {"15", "11", "9", "6", "1"};
        String[] pila = {"b", "a", "z", "y", "x"};
        // se crea los obejtos de la clase Cola y Pila
        Cola c2 = new Cola(cola, 4, 0);
        Pila p2 = new Pila(pila, 4, 0);

        System.out.println(transformacion(c2, p2, 5, 1, 1));
    } 
    
    public static void menuValoresPorTeclado() {
        int longitud, tipOp, tipExp;

        System.out.println("\n\t-.-.-. INDICACIONES .-.-.-");
        System.out.println("- El tamaño de la pila y cola es la misma.");
        System.out.println("- Se debe completar la pila y cola.");

        System.out.print("\nDefina el tamaño de la pila y cola: ");
        longitud = input.nextInt();

        // se define el tamaño de la cola y pila
        String[] cola = new String[longitud];
        String[] pila = new String[longitud];

        // se crea los objetos de la clase Cola y Pila
        Cola c1 = new Cola(cola, FINAL, FRENTE);
        Pila p1 = new Pila(pila, TOPE, FONDO);
        
        colaOperador = new Cola(new String[longitud], FINAL, FRENTE); // cambio
        colaExponente = new Cola(new String[longitud], FINAL, FRENTE); // cambio

        // llenado de pila y cola
        llenarColaPila(c1, p1, longitud);

        // trasnformación
        do {
            System.out.println("\nMENÚ: OPERADORES");
            System.out.println("1. Operadores con patrón: + - + - + ...");
            System.out.println("2. Operadores aleatorios.");
            System.out.println("3. Introducir por teclado los operadores.");
            System.out.print("Opción: ");
            tipOp = input.nextInt();
            
            System.out.println((tipOp > 3 || tipOp < 1) ? "\nError, opción no encontrada.\n" : "");
        } while (tipOp > 3 || tipOp < 1);

        do {
            System.out.println("\nMENÚ: EXPONENTE");
            System.out.println("1. Exponentes descendentes con excepción al último.");
            System.out.println("2. Introducir por teclado los exponentes.");
            System.out.print("Opción: ");
            tipExp = input.nextInt();
            
            System.out.println((tipExp > 2 || tipExp < 1) ? "\nError, opción no encontrada.\n" : "");
        } while (tipExp > 2 || tipExp < 1);
        
        llenarOperadores(longitud, tipOp); // cambio
        llenarExponentes(longitud,tipExp); // cambio
        
        
        System.out.println(transformacion(c1, p1, longitud, tipOp, tipExp));
    }

    public static void llenarColaPila(Cola c, Pila p, int longitud) {
        String x;

        System.out.println("\nLLENAR COLA\n");
        for (int i = 0; i < longitud; i++) {
            System.out.print("Ingrese el dato n°" + (1 + i) + ": ");
            x = input.next();
            c.insertar(x);
        }
        System.out.println("\nLLENAR PILA\n");
        for (int i = 0; i < longitud; i++) {
            System.out.print("Ingrese el dato n°" + (1 + i) + ": ");
            x = input.next();
            p.push(x);
        }
    }
    
    public static void llenarExponentes(int longitud, int tipExp) {
        String x;
        if (tipExp == 2) {
            for (int i = 0; i < longitud; i++) {
                System.out.println("Ingrese el exponente n°" + (1 + i) + ": ");
                x = input.next();
                colaExponente.insertar(x);
            }  
        }
    }
    
    public static void llenarOperadores(int longitud, int tipOp) {
        String x;
        if (tipOp == 3) {
            for (int i = 0; i < longitud; i++) {
                System.out.println("Ingrese el operador n°" + (1 + i) + ": ");
                x = input.next();
                colaOperador.insertar(x);
            }
        }
    }

    public static String transformacion(Cola c, Pila p, int longitud, int tipOp, int tipExp) {
        String notInf = "";
        String x, exp, operador; // para almacenar el valor que retorna la cola al hacer la supresión

        switch (tipExp) {
            case 1 -> { // 15*x
                for (int i = 0; i < longitud; i++) {
                    operador = operador(tipOp); // cambio
                    notInf += ((i != 0 || !operador.equals("+")) ? operador : ""); // cambio
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop(); // se hace pop y se disminuye en 1 el tope
                    notInf += ((p.getTope() > 0) ? "^" + (p.getTope() + 1) : "" ); // por eso se suma 1 al tope
                    
                }
            }
            case 2 -> {
                for (int i = 0; i < longitud; i++) {
                    operador = operador(tipOp); // cambio
                    notInf += ((i != 0 || !operador.equals("+")) ? operador : ""); // cambio
                    x = c.suprimir();
                    notInf += (!x.equals("1") ? x + "*" : "");
                    notInf += p.pop();
                    exp = colaExponente.suprimir(); // cambio
                    notInf += (!exp.equals("1") ? "^" + exp : "" );   
                }
            }
            case 3 -> {

            }
            default -> {
                System.out.println("\nError, opción no encontrada.\n");
            }
        }

        return "\n" + notInf + "\n";
    }

    static String operador(int tipOp) {// 4a + 3b
        String operador = "";

        switch (tipOp) {
            case 1 -> {
                operador = (itr % 2 == 0) ? "+" : "-"; // cambio
                itr++;
            }
            case 2 -> {
                operador = (Math.round((Math.random() + 1)) == 1) ? "-" : "+";
            }
            case 3 -> {
                operador = colaOperador.suprimir(); // cambio
            }
        }
        return operador;
    }
    
}//5 3 2 5
