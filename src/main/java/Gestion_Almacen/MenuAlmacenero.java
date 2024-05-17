package Gestion_Almacen;

import java.util.Scanner;

public class MenuAlmacenero {

    public static void main (String[] args){
        Login almaceLogin = new Login();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            if (almaceLogin.verificarLoginAlmace(usuario, contrasena)) {
                System.out.println("Login exitoso. ¡Bienvenido Almacenero!");
                int opci;
                do {
                    System.out.println("MENU ALMACENERO");
                    System.out.println();
                    System.out.println("1- Ver inventario de productos");
                    System.out.println("2- Gestionar pedidos");
                    System.out.println("3- Confirmar envios");
                    System.out.println("4- Salir del sistema");
                    System.out.println();
                    System.out.println("Ingresa la opcion: ");
                    opci = scanner.nextInt();

                } while (opci != 4);

                loggedIn = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }
    }
}
