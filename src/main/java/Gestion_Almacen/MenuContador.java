package Gestion_Almacen;

import java.util.Scanner;

public class MenuContador {
    public static void main (String[] args){
        Login ContLogin = new Login();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            if (ContLogin.verificarLoginCont(usuario, contrasena)) {
                System.out.println("Login exitoso. ¡Bienvenido Contador!");
                int opci;
                do{
                    System.out.println("MENU CONTADOR");
                    System.out.println();
                    System.out.println("1- Ver inventario de productos");
                    System.out.println("2- Generar informe de inventario");
                    System.out.println("3- Salir del sistema");
                    System.out.println();
                    System.out.println("Ingresa la opcion: ");
                    opci = scanner. nextInt();

                }while(opci != 3);
                loggedIn = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }

    }
}
