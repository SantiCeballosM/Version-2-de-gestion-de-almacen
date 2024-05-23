package Gestion_Almacen;

import java.util.Scanner;

public class MenuContador {
    public static void main (String[] args){
        Usuario contUsuario = new Usuario();
        Informe informe = new Informe();
        Informe ventas = new Informe();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            if (contUsuario.verificarLoginCont(usuario, contrasena)) {
                System.out.println("Login exitoso. ¡Bienvenido Contador!");
                int opci;
                do{
                    System.out.println("MENU CONTADOR");
                    System.out.println();
                    System.out.println("1- Ver inventario de productos");
                    System.out.println("2- Ver inventario de ventas");
                    System.out.println("3- Salir del sistema");
                    System.out.println();
                    System.out.println("Ingresa la opcion: ");
                    opci = scanner. nextInt();
                    System.out.println();
                    switch (opci) {
                        case 1:
                            informe.generarInformeInventario();
                            break;
                        case 2:
                            ventas.generarInformeVentas();
                            break;
                        case 3:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Ups opcion invalida");
                            break;
                    }
                }while(opci != 3);
                loggedIn = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }

    }
}
