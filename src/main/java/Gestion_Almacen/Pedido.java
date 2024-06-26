package Gestion_Almacen;

import java.util.*;

public class Pedido {
    private int idPedido;
    private Map<Integer, Integer> productos;
    private static List<Pedido> pedidosss = new ArrayList<>();
    private String estado;
    private Date fechaHora;

    public Pedido(int idPedido, Date fechaHora) {
        this.idPedido = idPedido;
        this.productos = new HashMap<>();
        this.estado = "pendiente";
        this.fechaHora = fechaHora;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Map<Integer, Integer> getProductos() {
        return productos;
    }

    public static List<Pedido> getPedidosss() {
        return pedidosss;
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

    public void agregarProducto(int idProducto, int cantidad) {
        productos.put(idProducto, cantidad);
    }

    public void actualizarProductos(int idProducto) {
        productos.remove(idProducto);
    }

    public static void gestionarPedido(Pedido pedido, Scanner scanner) {
        Pedido nuevoPedido = new Pedido(getPedidosss().size() + 1, new Date());
        boolean continuar = true;

        while (continuar) {
            System.out.println("Lista de Productos:");
            for (Producto producto : Producto.getProductos()) {
                System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Cantidad en Stock: " + producto.getCantidadStock());
            }
            System.out.println("_______________________");
            System.out.print("Ingrese el ID del producto que desea llevar: ");
            int idProducto = scanner.nextInt();
            scanner.nextLine();

            Producto productoSeleccionado = null;
            for (Producto producto : Producto.getProductos()) {
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
                nuevoPedido.agregarProducto(idProducto, cantidad);

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
        System.out.println();
        System.out.println("ESTABLECER EL ESTADO DEL PEDIDO");
        System.out.println();
        System.out.println("1- Pendiente");
        System.out.println("2- En proceso");
        System.out.println("3- Entregado");
        System.out.println();
        System.out.println("Ingrese el estado del pedido:");
        int estadooo = scanner.nextInt();

        String estadoPedido = "";
        switch (estadooo) {
            case 1:
                estadoPedido = "Pendiente";
                break;
            case 2:
                estadoPedido = "En proceso";
                break;
            case 3:
                estadoPedido = "Entregado";
                break;
        }
        nuevoPedido.setEstado(estadoPedido);
    }

    public static void mostrarPedidos() {
        for (Pedido p : pedidosss) {
            System.out.println("PEDIDOS");
            System.out.println("_______________________");
            System.out.println();
            System.out.println("Pedido ID: " + p.getIdPedido() + ", Fecha: " + p.getFechaHora() + ", Estado: " + p.getEstado());
            for (Map.Entry<Integer, Integer> entry : p.getProductos().entrySet()) {
                int idProducto = entry.getKey();
                int cantidad = entry.getValue();
                Producto producto = encontrarProductoPorId(idProducto);
                if (producto != null) {
                    System.out.println("Producto ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad: " + cantidad);
                } else {
                    System.out.println("Producto con ID " + idProducto + " no encontrado.");
                }
            }
            System.out.println("_______________________");
        }
    }

    private static Producto encontrarProductoPorId(int id) {
        for (Producto producto : Producto.getProductos()) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
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

        System.out.println();
        System.out.println("MODIFICACION DEL ESTADO DEL PEDIDO");
        System.out.println();
        System.out.println("1- Pendiente");
        System.out.println("2- En proceso");
        System.out.println("3- Entregado");
        System.out.println();
        System.out.println("Ingrese el nuevo estado del pedido:");
        int estadooo = scanner.nextInt();
        String estadoPedido = "";
        switch (estadooo) {
            case 1:
                estadoPedido = "Pendiente";
                break;
            case 2:
                estadoPedido = "En proceso";
                break;
            case 3:
                estadoPedido = "Entregado";
                break;
        }
        pedidoAModificar.setEstado(estadoPedido);

        System.out.println("Pedido modificado exitosamente.");
    }
}
