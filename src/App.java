import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        metodos metodo = new metodos();
        int op = 0;
        do {
            mostrarMenu();
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    metodo.agregarTarea();
                    break;
                case 2:
                    metodo.marcarTareaComoCompletada();
                    break;
                case 3:
                    metodo.mostarTareasPendientes();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;

            }

        } while (op != 4);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println((""
                + "|--------------------------------|\n"
                + "|          Menu Principal        |\n"
                + "|--------------------------------|\n"
                + "|  1.Agregar una nueva tarea     |\n"
                + "|  2.Marcar tarea completada     |\n"
                + "|  3.Mostrar tareas pendientes   |\n"
                + "|  4.Salir                       |\n"
                + "|--------------------------------|\n"));
    }
}
