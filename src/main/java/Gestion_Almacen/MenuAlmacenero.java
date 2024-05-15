package Gestion_Almacen;

import java.util.Scanner;

public class MenuAlmacenero {
    public static void main (String[] args){
        //MenuPrincipal.main(new String[0]);
            Scanner scanner = new Scanner(System.in);
            int opci;
            do{
                System.out.println("MENU ALMACENERO");
                System.out.println();
                System.out.println("1- Ver inventario de productos");
                System.out.println("2- Gestionar pedidos");
                System.out.println("3- Confirmar envios");
                System.out.println("4- Salir del sistema");
                opci = scanner. nextInt();

            }while(opci != 4);
    }
}
