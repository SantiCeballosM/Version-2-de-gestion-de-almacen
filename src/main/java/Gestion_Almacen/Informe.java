package Gestion_Almacen;

import java.util.Date;

public class Informe {
    Pedido pedido = new Pedido(1, new Date());
    public void generarInformeInventario() {
        System.out.println("INVENTARIO DEL ALMACEN:");
        for (Producto producto : pedido.getProductos()) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Descripción: " + producto.getDescripcion() + ", Precio: " + producto.getPrecio() + ", Cantidad en Stock: " + producto.getCantidadStock());
        }
    }

    public void generarInformeVentas() {

    }

}