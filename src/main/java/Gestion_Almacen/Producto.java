package Gestion_Almacen;

import java.util.Scanner;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadStock;

    public Producto(int id, String nombre, String descripcion, double precio, int cantidadStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public static void agregarProducto(Pedido pedido, Scanner scanner) {
        System.out.print("ID del Producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad en Stock: ");
        int cantidadStock = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, cantidadStock);
        pedido.agregarProducto(nuevoProducto);
        System.out.println("Producto agregado exitosamente.");
    }

    public static void modificarProducto(Pedido pedido, Scanner scanner) {
        System.out.print("ID del Producto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nueva Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Nuevo Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Nueva Cantidad en Stock: ");
        int cantidadStock = scanner.nextInt();
        scanner.nextLine();

        Producto productoModificado = new Producto(id, nombre, descripcion, precio, cantidadStock);
        pedido.modificarProducto(id, productoModificado);
        System.out.println("Producto modificado exitosamente.");
    }

    public static void eliminarProducto(Pedido pedido, Scanner scanner) {
        System.out.print("ID del Producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        pedido.eliminarProducto(id);
        System.out.println("Producto eliminado exitosamente.");
    }

    public static void mostrarProductos(Pedido pedido) {
        System.out.println("Lista de Productos:");
        for (Producto producto : pedido.getProductos()) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Cantidad en Stock: " + producto.getCantidadStock());
        }
    }
}
