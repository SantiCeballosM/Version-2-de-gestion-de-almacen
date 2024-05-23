package Gestion_Almacen;

import java.util.Date;
import java.util.Scanner;

public class MenuAlmacenero {

    public static void main(String[] args) {
        Usuario almaceUsuario = new Usuario();
        Informe informe = new Informe();
        Pedido pedido = new Pedido(1, new Date());
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            if (almaceUsuario.verificarLoginAlmace(usuario, contrasena)) {
                System.out.println("Login exitoso. ¡Bienvenido Almacenero!");
                int opci;
                do {
                    System.out.println("MENU ALMACENERO");
                    System.out.println();
                    System.out.println("1- Ver inventario de productos");
                    System.out.println("2- Agregar Pedido");
                    System.out.println("3- Modificar Pedido");
                    System.out.println("4- Eliminar Pedido");
                    System.out.println("5- Mostrar Pedido");
                    System.out.println("6- Salir del sistema");
                    System.out.println();
                    System.out.println("Ingresa la opcion: ");
                    opci = scanner.nextInt();
                    System.out.println();
                    switch (opci) {
                        case 1:
                            informe.generarInformeInventario();
                            System.out.println();
                            break;
                        case 2:
                            Pedido.gestionarPedido(pedido, scanner);
                            break;
                        case 3:
                            Pedido.mostrarPedidos();
                            Pedido.modificarPedido(pedido, scanner);
                            break;
                        case 4:
                            Pedido.mostrarPedidos();
                            Pedido.eliminarPedido(scanner);
                            break;
                        case 5:
                            Pedido.mostrarPedidos();
                            break;
                        case 6:
                            System.out.println("Saliste del sistema");
                            break;
                        default:
                            System.out.println("Ups opcion invalida");
                            break;
                    }
                } while (opci != 6);

                loggedIn = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }
    }
}
