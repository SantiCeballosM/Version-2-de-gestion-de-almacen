package Gestion_Almacen;

import java.util.Scanner;

public class MenuAdministrador {
    public static void main (String[] args){
        //MenuPrincipal.main(new String[0]);
        Scanner scanner = new Scanner(System.in);
        int opci;
        do{
            System.out.println("MENU ADMINISTRADOR");
            System.out.println();
            System.out.println("1- Agregar Producto");
            System.out.println("2- Modificar producto");
            System.out.println("3- Eliminar Producto");
            System.out.println("4- Gestionar Envios");
            System.out.println("5- Confirmar envios");
            System.out.println("6- Generar informe de venta");
            System.out.println("7- Generar informe de inventario");
            System.out.println("8- Administrar roles y asignar roles");
            System.out.println("9- Salir del sistema");
            System.out.println();
            System.out.println("Ingresa la opcion: ");
            opci = scanner. nextInt();

        }while(opci != 9);
    }
}
