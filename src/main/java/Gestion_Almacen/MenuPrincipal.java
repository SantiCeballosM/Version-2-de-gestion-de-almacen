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
            opci = scanner. nextInt();

        }while(opci != 4);
    }
}
