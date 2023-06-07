import java.io.FileInputStream;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class metodos {
    String filepath = "C:/Users/pertu/OneDrive - Universidad Simón Bolívar/VSCodeProyects/java/Gestor de tareas pendientes/tareas.txt";

    HashMap<String, String> mapa = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void agregarTarea() {
        try (PrintStream guardar = new PrintStream(new FileOutputStream("tareas.txt", true))) {

            String nombre, descripcion;
            @SuppressWarnings("unused")
            boolean continuar = true;

            System.out.println("Ingrese el nombre de la tarea (o 'salir' para finalizar):");
            nombre = sc.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                continuar = false;
            } else {
                System.out.println("Ingrese la descripción de la tarea:");
                descripcion = sc.nextLine();

                mapa.put(nombre, descripcion);
                guardar.append("Nombre: " + nombre + ", Descripcion: " + descripcion);
                guardar.println("                                                  "
                        + "                                                  ");
                System.out.println("La tarea se ha agregado correctamente.");

            }

        } catch (Exception e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    public void recorrerMapa() {
        for (HashMap.Entry<String, String> entry : mapa.entrySet()) {

            System.out.println("Nombre: " + entry.getKey().toUpperCase() + ", Descripcion: "
                    + entry.getValue().toUpperCase() + ".");
        }
    }

    /*
     * 
     */
    public void marcarTareaComoCompletada() {
        try {
            if (mapa.isEmpty()) {
                System.out.println("No hay tareas pendientes.");
                return;
            }

            System.out.println("Lista de tareas pendientes:");
            recorrerMapa();

            System.out.println("Seleccione el nombre de la tarea a marcar como completada:");
            Scanner scanner = new Scanner(System.in);
            try {
                String nombre = scanner.next();

                for (HashMap.Entry<String, String> entry : mapa.entrySet()) {

                    String tarea = entry.getKey();
                    if (tarea.equalsIgnoreCase(nombre)) {
                        String tareaCompletada = mapa.remove(tarea);
                        System.out.println(
                                "La tarea \"" + tareaCompletada.toUpperCase() + "\" se ha marcado como completada.");
                        break;
                    } else {
                        System.out.println("Tarea " + nombre + " no existe");

                    }
                }

            } catch (Exception e) {
                System.out.println("Opción inválida. Debe ingresar el nombre de la tarea.");
                scanner.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Mostar
     */
    public void mostarTareasPendientes() {

        try {
            FileInputStream fichero = new FileInputStream(filepath);

            if (fichero.read() != 0) {

                byte[] datos = fichero.readAllBytes();
                for (byte dato : datos) {
                    System.out.print((char) dato);

                }

            }
            fichero.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
