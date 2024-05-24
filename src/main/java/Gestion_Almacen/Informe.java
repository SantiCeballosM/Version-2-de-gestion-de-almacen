package Gestion_Almacen;

import java.util.Date;
import java.util.Map;

public class Informe {

    Pedido pedido = new Pedido(1, new Date());

    public void generarInformeVentas() {
        System.out.println("INFORME DE VENTAS:");
        for (Pedido p : Pedido.getPedidosss()) {
            System.out.println("_______________________");
            System.out.println("Pedido ID: " + p.getIdPedido() + ", Fecha: " + p.getFechaHora() + ", Estado: " + p.getEstado());
            for (Map.Entry<Integer, Integer> entry : p.getProductos().entrySet()) {
                int idProducto = entry.getKey();
                int cantidad = entry.getValue();
                Producto producto = encontrarProductoPorId(idProducto);
                if (producto != null) {
                    System.out.println("Producto ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Cantidad: " + cantidad + ", Precio Unitario: " + producto.getPrecio() + ", Subtotal: " + (producto.getPrecio() * cantidad));
                } else {
                    System.out.println("Producto no encontrado para el ID: " + idProducto);
                }
            }
            System.out.println("_______________________");
        }
    }

    public void generarInformeInventario() {
        System.out.println("INFORME DE INVENTARIO:");
        for (Producto producto : Producto.getProductos()) {
            System.out.println("_______________________");
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Cantidad en Stock: " + producto.getCantidadStock());
            System.out.println("_______________________");
        }
    }

    private Producto encontrarProductoPorId(int id) {
        for (Producto producto : Producto.getProductos()) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
}
