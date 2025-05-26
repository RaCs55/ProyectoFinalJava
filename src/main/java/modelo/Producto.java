package modelo;

public class Producto {
    private String codProducto;
    private String nombre;
    private String tipo;
    private double precio;

    public Producto(String codProducto, String nombre, String tipo, double precio) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getCodProducto() {
        return codProducto;
    }
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codProducto + "," + nombre + "," + tipo + "," + precio;
    }
}