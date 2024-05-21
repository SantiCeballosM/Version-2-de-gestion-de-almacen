package Gestion_Almacen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private int idPedido;
    private List<Producto> productos;
    private static List<Pedido> pedidosss = new ArrayList<>();
    private String estado;
    private Date fechaHora;

    static {
        pedidosss.add(new Pedido(1, new Date()));
    }

    public Pedido(int idPedido, Date fechaHora) {
        this.idPedido = idPedido;
        this.productos = new ArrayList<>();
        this.estado = "pendiente";
        this.fechaHora = fechaHora;

        productos.add(new Producto(1, "Colchón", "Colchón para basecama", 150000, 40));
        productos.add(new Producto(2, "Silla", "Silla de oficina ergonómica", 50000, 30));
        productos.add(new Producto(3, "Mesa", "Mesa de comedor de madera", 120000, 15));

        this.estado = "pendiente";
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public static List<Pedido> getPedidosss() {
        return pedidosss;
    }

    public static void setPedidosss(List<Pedido> pedidosss) {
        Pedido.pedidosss = pedidosss;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }
    }

    public void modificarProducto(int id, Producto productoModificado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.set(i, productoModificado);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    public static void gestionarPedido(Pedido pedido, Scanner scanner) {
        Pedido nuevoPedido = new Pedido(pedido.getPedidosss().size() + 1, new Date());
        boolean continuar = true;

        while (continuar) {
            Producto.mostrarProductos(pedido);
            System.out.println("_______________________");
            System.out.print("Ingrese el ID del producto que desea llevar: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();

            Producto productoSeleccionado = null;
            for (Producto producto : pedido.getProductos()) {
                if (producto != null && producto.getId() == idProducto) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("El ID del producto ingresado no es válido.");
                continue;
            }
            System.out.println("_______________________");
            System.out.print("Ingrese la cantidad de productos que desea llevar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (cantidad <= productoSeleccionado.getCantidadStock()) {
                productoSeleccionado.setCantidadStock(productoSeleccionado.getCantidadStock() - cantidad);
                nuevoPedido.agregarProducto(productoSeleccionado, cantidad);
                System.out.println("Producto agregado al pedido exitosamente.");
            } else {
                System.out.println("No hay suficientes productos en el inventario para el pedido.");
            }

            System.out.print("¿Desea agregar otro producto al pedido? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        pedidosss.add(nuevoPedido);
        System.out.println("Pedido confirmado exitosamente.");

        System.out.println("Ingrese el estado del pedido:");
        System.out.print("(pendiente, en proceso, entregado, cancelado): ");
        String estadoPedido = scanner.nextLine().trim().toLowerCase();
        nuevoPedido.setEstado(estadoPedido);
    }

    public static void mostrarPedidos() {
        for (Pedido p : pedidosss) {
            System.out.println("_______________________");
            System.out.println("Pedido ID: " + p.getIdPedido() + ", Fecha: " + p.getFechaHora() + ", Estado: " + p.getEstado());
            for (Producto producto : p.getProductos()) {
                System.out.println("Producto ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad: " + p.getProductos().stream().filter(prod -> prod.getId() == producto.getId()).count());
            }
            System.out.println("_______________________");
        }
    }


    public static void eliminarPedido(Scanner scanner) {
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < pedidosss.size(); i++) {
            if (pedidosss.get(i).getIdPedido() == idPedido) {
                pedidosss.remove(i);
                System.out.println("Pedido con ID " + idPedido + " eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Pedido " + idPedido + " no encontrado.");
    }

    public static void modificarPedido(Pedido pedido, Scanner scanner) {
        System.out.print("Ingrese el ID del pedido que desea modificar: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedidoAModificar = null;
        for (Pedido p : Pedido.getPedidosss()) {
            if (p.getIdPedido() == idPedido) {
                pedidoAModificar = p;
                break;
            }
        }

        if (pedidoAModificar == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            Producto.mostrarProductos(pedidoAModificar);
            System.out.println("_______________________");
            System.out.print("Ingrese el ID del producto que desea modificar: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();

            Producto productoSeleccionado = null;
            for (Producto producto : pedidoAModificar.getProductos()) {
                if (producto != null && producto.getId() == idProducto) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("El ID del producto ingresado no es válido.");
                continue;
            }

            System.out.println("_______________________");
            System.out.println("Ingrese los nuevos datos del producto:");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Cantidad en stock: ");
            int cantidadStock = scanner.nextInt();
            scanner.nextLine();

            Producto productoModificado = new Producto(idProducto, nombre, descripcion, precio, cantidadStock);
            pedidoAModificar.modificarProducto(idProducto, productoModificado);
            System.out.println("Producto modificado exitosamente.");

            System.out.print("¿Desea modificar otro producto del pedido? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Ingrese el estado del pedido:");
        System.out.print("(pendiente, en proceso, entregado, cancelado): ");
        String estadoPedido = scanner.nextLine().trim().toLowerCase();
        pedidoAModificar.setEstado(estadoPedido);

        System.out.println("Pedido modificado exitosamente.");
    }




}
