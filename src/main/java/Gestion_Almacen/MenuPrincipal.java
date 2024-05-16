package Gestion_Almacen;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int opci;
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println();
            System.out.println("Quien eres: ");
            System.out.println("1- Administrador");
            System.out.println("2- Almacenero");
            System.out.println("3- Contador");
            System.out.println("4- Salir del sistema");
            System.out.println();
            System.out.println("Ingresa La opcion: ");
            opci = scanner. nextInt();
            switch (opci) {
                case 1:
                    MenuAdministrador.main(new String[0]);
                    break;
                case 2:
                    MenuAlmacenero.main(new String[0]);
                    break;
                case 3:
                    MenuContador.main(new String[0]);
                    break;
                default:

                    System.out.println("Ups... opcion inavlida");
            }
        }while(opci != 4);
    }
}
