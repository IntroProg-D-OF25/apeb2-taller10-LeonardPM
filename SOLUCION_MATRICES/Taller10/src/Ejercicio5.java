import java.util.Scanner;

/**
 * Ejercicio 5
 * Crea un programa que gestione el inventario de una tienda, así como la emisión de facturas.
 * Utiliza una matriz bidimensional para almacenar los productos disponibles en la
 * tienda, con información como nombre, precio y cantidad. El programa debe permitir facturar un producto dado su código, y unidades deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la compra superar los $100, se debe aplicar un descuento.
 * <p>
 * Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 */
public class Ejercicio5 {
    public static void main(String[] args) {


        // Matriz bidimensional para el inventario (nombre, precio, cantidad)
        Object[][] Stock = {
                {"Mote", 01.0, 30},
                {"Monster", 03.0, 30},
                {"Quesillo", 02.0, 40},
                {"Colombina", 00.50, 100},
                {"Cafe", 1.20, 10},
                {"Rufles", 00.60, 100}
        };


        boolean seguir = true;
        Scanner teclado = new Scanner(System.in);
        while (seguir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ver inventario");
            System.out.println("2. Facturacion del producto");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInventario(Stock);
                    break;
                case 2:
                    facturarProducto(Stock, teclado);
                    break;
                case 3:
                    seguir = false;
                    System.out.println("Gracias .");
                    break;
                default:
                    System.out.println("Opción invalida vuelve a intentar.");
            }
        }

        teclado.close();
    }

    // Muestra el inventario
    public static void mostrarInventario(Object[][] inventario) {
        System.out.println("\n--- Inventario ---");
        System.out.printf("%-10s %-10s %-10s\n", "Código", "Nombre", "Precio", "Cantidad");
        for (int i = 0; i < inventario.length; i++) {
            System.out.printf("%-10d %-10s $%-9.2f %-10d\n", i + 1, inventario[i][0], (double) inventario[i][1], (int) inventario[i][2]);
        }
    }

    // FACTURACION DEL PRODUCTO
    public static void facturarProducto(Object[][] Stock, Scanner scanner) {
        System.out.println("\n--- Facturar Producto ---");
        mostrarInventario(Stock);
        System.out.print("Ingrese el código del producto: ");
        int codigo = scanner.nextInt() - 1;

        if (codigo < 0 || codigo >= Stock.length) {
            System.out.println("Código inválido.");
            return;
        }

        System.out.print("Ingrese la cantidad deseada: ");
        int cantidad = scanner.nextInt();

        if (cantidad > (int) Stock[codigo][2]) {
            System.out.println("No hay suficiente stock disponible.");
            return;
        }

        // Actualizar el inventario
        Stock[codigo][2] = (int) Stock[codigo][2] - cantidad;

        // Calcular subtotal, IVA, y total
        double PrecioU = (double) Stock[codigo][1];
        double subtotal = PrecioU * cantidad;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        // Aplicar descuento si supera $100
        double DESC = 0.0;
        if (total > 100) {
            DESC = total * 0.1; // 10% de descuento
            total -= DESC;
        }

        // Mostrar factura
        System.out.println("\n--- Factura ---");
        System.out.printf("Producto: %s\n", Stock[codigo][0]);
        System.out.printf("Stock: %d\n", cantidad);
        System.out.printf("Precio unitario: $%.2f\n", PrecioU);
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("IVA (15%%): $%.2f\n", iva);
        if (DESC > 0) {
            System.out.printf("Descuentos (10%%): $%.2f\n", DESC);
        }
        System.out.printf("Total a cancelar: $%.2f\n", total);
    }
}
/**
 * --- Inventario ---
 * Código     Nombre     Precio
 * 1          Mote       $1.00      30
 * 2          Monster    $3.00      30
 * 3          Quesillo   $2.00      40
 * 4          Colombina  $0.50      100
 * 5          Cafe       $1.20      10
 * 6          Rufles     $0.60      100
 * Ingrese el código del producto: 2
 * Ingrese la cantidad deseada: 27
 *
 * --- Factura ---
 * Producto: Monster
 * Stock: 27
 * Precio unitario: $3.00
 * Subtotal: $81.00
 * IVA (15%): $12.15
 * Total a cancelar: $93.15
 *
 * --- Menú ---
 * 1. Ver inventario
 * 2. Facturacion del producto
 * 3. Salir
 * Selecciona una opción: 1
 *
 * --- Inventario ---
 * Código     Nombre     Precio
 * 1          Mote       $1.00      30
 * 2          Monster    $3.00      3
 * 3          Quesillo   $2.00      40
 * 4          Colombina  $0.50      100
 * 5          Cafe       $1.20      10
 * 6          Rufles     $0.60      100
 *
 * --- Menú ---
 * 1. Ver inventario
 * 2. Facturacion del producto
 * 3. Salir
 * Selecciona una opción: 3
 * Gracias .
 */

