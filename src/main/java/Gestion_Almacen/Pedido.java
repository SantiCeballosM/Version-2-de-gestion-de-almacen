package Gestion_Almacen;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public  class Pedido {
    private int idPedido;
    private List<Producto> productos;
    private String estado;
    private Date fechaHora;

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

    public Pedido(int idPedido, List<Producto> productos, String estado, Date fechaHora) {
        this.idPedido = idPedido;
        this.productos = productos;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }
}