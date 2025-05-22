package modelo;


public class Proveedor {
    private String cifProveedor;
    private String nombre;
    private String direccion;

    public Proveedor() {}

    public Proveedor(String cifProveedor, String nombre, String direccion) {
        this.cifProveedor = cifProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCifProveedor() { return cifProveedor; }
    public void setCifProveedor(String cifProveedor) { this.cifProveedor = cifProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return cifProveedor + "," + nombre + "," + direccion;
    }
}