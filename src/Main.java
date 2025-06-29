// Importa la clase Scanner para lectura desde consola
import java.util.Scanner;

// Importa la clase List para manejar listas de objetos Servicio
import java.util.List;

// Clase principal del programa
public class Main {

    // Método main: punto de entrada de la aplicación
    public static void main(String[] args) {

        // Crea un objeto Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Crea una instancia del DAO para interactuar con la base de datos
        ServicioDAO dao = new ServicioDAO();

        // Variable para almacenar la opción del menú seleccionada por el usuario
        int opcion;

        // Bucle principal del programa, se repite hasta que el usuario elija salir (opción 5)
        do {
            // Muestra el menú principal
            System.out.println("\n===== GESTIÓN DE SERVICIOS =====");
            System.out.println("1. Registrar nuevo servicio");
            System.out.println("2. Listar servicios");
            System.out.println("3. Actualizar servicio");
            System.out.println("4. Eliminar servicio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Lee la opción seleccionada
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer después de leer un número

            // Evalúa la opción del menú usando un switch
            switch (opcion) {

                // Opción 1: Registrar un nuevo servicio
                case 1 -> {
                    System.out.print("Nombre del servicio: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();

                    // Crea un nuevo objeto Servicio y lo guarda en la base de datos
                    dao.insertarServicio(new Servicio(nombre, precio));
                }

                // Opción 2: Listar todos los servicios existentes
                case 2 -> {
                    List<Servicio> servicios = dao.listarServicios();
                    System.out.println("== SERVICIOS ==");
                    for (Servicio s : servicios) {
                        System.out.println(s); // Usa el método toString() de Servicio
                    }
                }

                // Opción 3: Actualizar un servicio por ID
                case 3 -> {
                    System.out.print("ID del servicio a actualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpia el buffer

                    System.out.print("Nuevo nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Nuevo precio: ");
                    double precio = scanner.nextDouble();

                    // Actualiza el servicio en la base de datos
                    dao.actualizarServicio(new Servicio(id, nombre, precio));
                }

                // Opción 4: Eliminar un servicio por ID
                case 4 -> {
                    System.out.print("ID del servicio a eliminar: ");
                    int id = scanner.nextInt();

                    // Elimina el servicio de la base de datos
                    dao.eliminarServicio(id);
                }

                // Opción 5: Salir del programa
                case 5 -> System.out.println("Saliendo...");

                // Opción inválida
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5); // El ciclo continúa hasta que se seleccione la opción 5

        // Cierra el scanner para liberar recursos
        scanner.close();
    }
}
