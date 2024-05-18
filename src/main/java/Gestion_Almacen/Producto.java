package Gestion_Almacen;

public class Producto{
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadInventario;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public Producto(int id, String descripcion, String nombre, double precio, int cantidadInventario) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadInventario = cantidadInventario;
    }
}