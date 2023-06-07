import java.io.*;

import java.util.*;

public class practica {
    public static void main(String[] args) throws Exception {
        // 0. cadena al reves
        reverse("Hola mundo");
        System.out.println();

        // 1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente
        // sus
        String[] fruits = { "manzana", "banana", "naranja" };
        printArray(fruits);

        // 2.Crea un array bidimensional de enteros y recórrelo, mostrando la posición y
        // el valor de cada elemento en ambas dimensiones.
        System.out.println();
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        printmatriz(matriz);

        // 3. Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.
        eliminarDevector();

        // 4. Indica cuál es el problema de utilizar un Vector con la capacidad por
        // defecto si tuviésemos 1000 elementos para ser añadidos al mismo.
        System.out.println("El problema de utilizar un vector con la capacidad por defecto y añadir" +
                " 1000 elementos al mismo es la necesidad de realizar múltiples reasignaciones" +
                " y copias de memoria durante la operación de inserción para resumir seria un" +
                "desperdicio de memoria.");

        // 5.Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una
        // LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.
        recorrerAmbos();

        // 6. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con
        // elementos 1..10.
        // A continuación, con otro bucle, recórrelo y elimina los numeros pares. Por
        // último, vuelve a recorrerlo
        // y muestra el ArrayList final. Si te atreves, puedes hacerlo en menos pasos,
        // siempre y cuando cumplas
        // el primer "for" de relleno.

        arrayint();

        // 7.Crea una función DividePorCero. Esta, debe generar una excepción ("throws")
        // a su llamante del tipo ArithmeticException que será capturada por su llamante
        // (desde "main", por ejemplo). Si se dispara la excepción,
        // mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en
        // cualquier caso: "Demo de código".

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa dividendo");
        int dividendo = scanner.nextInt();
        System.out.println("Ingresa divisor");
        int divisor = scanner.nextInt();
        scanner.close();
        try {
            System.out.println("Resultado: " + DividePorCero(dividendo, divisor));

        } catch (ArithmeticException e) {
            System.out.println("no se puede dividir por cero");
        }
        // 8.Utilizando InputStream y PrintStream, crea una función que reciba dos
        // parámetros: "fileIn" y "fileOut". La tarea de la función será realizar la
        // copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
        String filepath = "C:/Windows/System32/drivers/etc/services";
        copiaDeFicheros(filepath, "copia.txt");
    }

    public static String reverse(String text) {

        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
        return text;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printmatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Valor en posición [" + i + "][" + j + "]: " + matriz[i][j]);
            }
        }

    }

    public static void eliminarDevector() {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println("Vector antes de eliminar elementos: " + vector);
        vector.remove(2);
        vector.remove(3);
        System.out.println("Vector despues de eliminar" + vector);

    }

    public static void recorrerAmbos() {
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Manzana");
        fruits.add("Pera");
        fruits.add("uva");
        fruits.add("Frambuesa");
        LinkedList<String> fruits2 = new LinkedList<>(fruits);
        System.out.println(fruits + " ArrayList");
        System.out.println(fruits2 + " LinkedList");
    }

    public static void arrayint() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(i + 1);
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                lista.remove(i);
            }
        }
        System.out.println(lista);
    }

    public static int DividePorCero(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void copiaDeFicheros(String filein, String fileout) {

        try {
            FileInputStream fichero = new FileInputStream(filein);
            PrintStream out = new PrintStream("copia.txt");

            byte[] datos = fichero.readAllBytes();
            for (byte dato : datos) {
                System.out.print((char) dato);

            }
            out.write(datos);
            fichero.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
