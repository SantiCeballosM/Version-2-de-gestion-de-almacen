package Gestion_Almacen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadStock;
    private static List<Producto> productos = new ArrayList<>();

    public Producto(int id, String nombre, String descripcion, double precio, int cantidadStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        productos.add(this);
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

    public static List<Producto> getProductos() {
        return productos;
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
        scanner.nextLine();

        Producto nuevoProducto = new Producto(id, nombre, descripcion, precio, cantidadStock);
        pedido.agregarProducto(id, 1);
        System.out.println("Producto agregado exitosamente.");
    }

    public static void modificarProducto(Pedido pedido, Scanner scanner) {
        System.out.print("Ingrese el ID del producto que desea modificar: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();

        for (Map.Entry<Integer, Integer> entry : pedido.getProductos().entrySet()) {
            if (entry.getKey() == idProducto) {
                System.out.print("Nuevo nombre del producto: ");
                String nombre = scanner.nextLine();

                System.out.print("Nueva descripción del producto: ");
                String descripcion = scanner.nextLine();

                System.out.print("Nuevo precio del producto: ");
                double precio = scanner.nextDouble();

                System.out.print("Nueva cantidad en stock del producto: ");
                int cantidadStock = scanner.nextInt();
                scanner.nextLine();

                Producto producto = encontrarProductoPorId(idProducto);
                if (producto != null) {
                    producto.setNombre(nombre);
                    producto.setDescripcion(descripcion);
                    producto.setPrecio(precio);
                    producto.setCantidadStock(cantidadStock);
                    System.out.println("Producto modificado exitosamente.");
                } else {
                    System.out.println("Producto no encontrado.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado en el pedido.");
    }

    public static void eliminarProducto(Pedido pedido, Scanner scanner) {
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();

        for (Map.Entry<Integer, Integer> entry : pedido.getProductos().entrySet()) {
            if (entry.getKey() == idProducto) {
                Producto productoAEliminar = encontrarProductoPorId(idProducto);
                if (productoAEliminar != null) {
                    productos.remove(productoAEliminar);
                    pedido.actualizarProductos(idProducto);
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("Producto no encontrado.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado en el pedido.");
    }

    private static Producto encontrarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public static void mostrarProductos(Pedido pedido) {
        System.out.println("Lista de Productos:");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Cantidad en Stock: " + producto.getCantidadStock());
        }
    }
}
