import java.util.Scanner;

/**
 * Ejercicio 4
 * Crea un programa que gestione el inventario de una tienda. Utiliza una matriz bidimensional para almacenar los productos disponibles
 * en la tienda, con información como nombre, precio y cantidad.
 * El programa debe permitir agregar nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 */
public class Ejerccio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[][] inventario = new String[100][3]; // Matriz para almacenar hasta 100 productos
        int totalProductos = 0;

        while (true) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    if (totalProductos >= 100) {
                        System.out.println("El inventario está lleno.");
                        break;
                    }
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    String precio = scanner.nextLine();
                    System.out.print("Cantidad disponible: ");
                    String cantidad = scanner.nextLine();
                    inventario[totalProductos][0] = nombre;
                    inventario[totalProductos][1] = precio;
                    inventario[totalProductos][2] = cantidad;
                    totalProductos++;
                    System.out.println("Producto agregado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingresa el nombre del producto a actualizar: ");
                    String productoActualizar = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoActualizar)) {
                            System.out.print("Nueva cantidad disponible: ");
                            inventario[i][2] = scanner.nextLine();
                            System.out.println("Cantidad actualizada exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el nombre del producto a buscar: ");
                    String productoBuscar = scanner.nextLine();
                    encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresa el nombre del producto a eliminar: ");
                    String productoEliminar = scanner.nextLine();
                    encontrado = false;
                    for (int i = 0; i < totalProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoEliminar)) {
                            for (int j = i; j < totalProductos - 1; j++) {
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            totalProductos--;
                            System.out.println("Producto eliminado exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- INVENTARIO ---");
                    if (totalProductos == 0) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (int i = 0; i < totalProductos; i++) {
                            System.out.println("Producto " + (i + 1) + ":");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}


