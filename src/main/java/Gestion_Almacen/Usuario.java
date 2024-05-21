package Gestion_Almacen;

import java.util.HashMap;
import java.util.Scanner;
public class Usuario {
    private HashMap<String, String> administradores;
    private HashMap<String, String> almaceneros;
    private HashMap<String, String> contadores;

    public Usuario() {
        administradores = new HashMap<>();
        almaceneros = new HashMap<>();
        contadores = new HashMap<>();

        administradores.put("admin", "admin123");
        almaceneros.put("almace", "almace123");
        contadores.put("cont", "cont123");
    }

    public boolean verificarLoginAdmin(String usuario, String contrasena) {
        return administradores.containsKey(usuario) && administradores.get(usuario).equals(contrasena);
    }
    public boolean verificarLoginAlmace(String usuario, String contrasena) {
        return almaceneros.containsKey(usuario) && almaceneros.get(usuario).equals(contrasena);
    }
    public boolean verificarLoginCont(String usuario, String contrasena) {
        return contadores.containsKey(usuario) && contadores.get(usuario).equals(contrasena);
    }
    public void agregarUsuarioConRol() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el rol del usuario:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Almacenero");
        System.out.println("3 - Contador");
        System.out.print("Ingrese el número correspondiente al rol: ");
        int rol = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        switch (rol) {
            case 1:
                administradores.put(usuario, contrasena);
                break;
            case 2:
                almaceneros.put(usuario, contrasena);
                break;
            case 3:
                contadores.put(usuario, contrasena);
                break;
            default:
                System.out.println("Rol no válido.");
                break;
        }
        System.out.println("Usuario agregado exitosamente con el rol seleccionado.");
        scanner.close();
    }
    public void mostrarUsuarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué usuarios desea ver:");
        System.out.println("1 - Todos los usuarios");
        System.out.println("2 - Solo administradores");
        System.out.println("3 - Solo almaceneros");
        System.out.println("4 - Solo contadores");
        System.out.print("Ingrese el número correspondiente a la opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Todos los usuarios:");
                mostrarTodosLosUsuarios();
                break;
            case 2:
                System.out.println("Administradores:");
                mostrarAdministradores();
                break;
            case 3:
                System.out.println("Almaceneros:");
                mostrarAlmaceneros();
                break;
            case 4:
                System.out.println("Contadores:");
                mostrarContadores();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        scanner.close();
    }

    private void mostrarTodosLosUsuarios() {
        System.out.println("Administradores:");
        mostrarAdministradores();
        System.out.println("Almaceneros:");
        mostrarAlmaceneros();
        System.out.println("Contadores:");
        mostrarContadores();
    }

    private void mostrarAdministradores() {
        for (String usuario : administradores.keySet()) {
            System.out.println("Usuario: " + usuario);
        }
    }

    private void mostrarAlmaceneros() {
        for (String usuario : almaceneros.keySet()) {
            System.out.println("Usuario: " + usuario);
        }
    }

    private void mostrarContadores() {
        for (String usuario : contadores.keySet()) {
            System.out.println("Usuario: " + usuario);
        }
    }
    public void eliminarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué tipo de usuario desea eliminar:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Almacenero");
        System.out.println("3 - Contador");
        System.out.print("Ingrese el número correspondiente a la opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                eliminarUsuario(administradores);
                break;
            case 2:
                eliminarUsuario(almaceneros);
                break;
            case 3:
                eliminarUsuario(contadores);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private void eliminarUsuario(HashMap<String, String> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("El usuario ingresado no existe.");
        }
    }
    public void modificarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué tipo de usuario desea modificar:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Almacenero");
        System.out.println("3 - Contador");
        System.out.print("Ingrese el número correspondiente a la opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                modificarUsuario(administradores);
                break;
            case 2:
                modificarUsuario(almaceneros);
                break;
            case 3:
                modificarUsuario(contadores);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    private void modificarUsuario(HashMap<String, String> usuarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario que desea modificar: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.print("Ingrese la nueva contraseña: ");
            String contrasena = scanner.nextLine();
            usuarios.put(usuario, contrasena);
            System.out.println("Usuario modificado exitosamente.");
        } else {
            System.out.println("El usuario ingresado no existe.");
        }
    }
    public void MenuGestionUsuarios() {
        Scanner scanner = new Scanner(System.in);
        int opcion_usuarios;
        do {
            System.out.println();
            System.out.println("MENU DE GESTION DE USUARIOS");
            System.out.println("1- Agregar usuario");
            System.out.println("2- Modificar usuario");
            System.out.println("3- Eliminar usuario");
            System.out.println("4- Mostrar usuarios");
            System.out.println("5- Salir");
            System.out.print("Ingrese la opción correspondiente: ");
            opcion_usuarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcion_usuarios) {
                case 1:
                    agregarUsuarioConRol();
                    break;
                case 2:
                    modificarUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    mostrarUsuarios();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de gestión de usuarios...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion_usuarios != 5);

        scanner.close();
    }
}
