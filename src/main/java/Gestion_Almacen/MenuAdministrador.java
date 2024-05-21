package Gestion_Almacen;

import java.util.Date;
import java.util.Scanner;

public class MenuAdministrador {
    public static void main(String[] args) {
        Usuario adminUsuario = new Usuario();
        Usuario usuarioMenu = new Usuario();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        Pedido pedido = new Pedido(1, new Date());

        while (!loggedIn) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            if (adminUsuario.verificarLoginAdmin(usuario, contrasena)) {
                System.out.println("Login exitoso. ¡Bienvenido Administrador!");
                int opcion;
                do {
                    System.out.println();
                    System.out.println("MENU ADMINISTRADOR");
                    System.out.println("_______________________");
                    System.out.println("1- Agregar Producto");
                    System.out.println("2- Modificar producto");
                    System.out.println("3- Eliminar Producto");
                    System.out.println("4- Mostrar Productos");
                    System.out.println("_______________________");
                    System.out.println("5- Agregar Pedido");
                    System.out.println("6- Modificar Pedido");
                    System.out.println("7- Eliminar Pedido");
                    System.out.println("8- Mostrar Pedido");
                    System.out.println("_______________________");
                    System.out.println("9- Generar informe de venta");
                    System.out.println("10- Generar informe de inventario");
                    System.out.println("_______________________");
                    System.out.println("11- Administrar roles y asignar roles");
                    System.out.println("12- Salir del sistema");
                    System.out.println(" ");
                    System.out.print("Ingresa la opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            Producto.agregarProducto(pedido, scanner);
                            break;
                        case 2:
                            Producto.mostrarProductos(pedido);
                            System.out.println("_______________________");
                            Producto.modificarProducto(pedido, scanner);
                            break;
                        case 3:
                            Producto.mostrarProductos(pedido);
                            System.out.println("_______________________");
                            Producto.eliminarProducto(pedido, scanner);
                            break;
                        case 4:
                            Producto.mostrarProductos(pedido);
                            break;
                        case 5:
                            Pedido.gestionarPedido(pedido, scanner);
                            break;
                        case 6:
                            Pedido.mostrarPedidos();
                            Pedido.modificarPedido(pedido, scanner);
                            break;
                        case 7:
                            System.out.println("Pedidos actuales:");
                            Pedido.mostrarPedidos();
                            Pedido.eliminarPedido(scanner);
                            break;
                        case 8:
                            Pedido.mostrarPedidos();
                            break;
                        case 9:
                            // Informe de venta
                            break;
                        case 10:
                            // Informe de inventario
                            break;
                        case 11:
                            usuarioMenu.MenuGestionUsuarios();
                            break;
                        case 12:
                            System.out.println("Salir del sistema...");
                            break;

                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    }
                } while (opcion != 12);
                loggedIn = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}
