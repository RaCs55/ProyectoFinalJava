package modelo;


public class Cliente {
    private int numCliente;
    private String nombre;
    private Mesa mesa;

    public Cliente() {}

    public Cliente(int numCliente, String nombre, Mesa mesa) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.mesa = mesa;
    }

    public int getNumCliente() { return numCliente; }
    public void setNumCliente(int numCliente) { this.numCliente = numCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }

    @Override
    public String toString() {
        return "Cliente{" +
               "numCliente=" + numCliente +
               ", nombre='" + nombre + '\'' +
               ", mesa=" + mesa.getNumeroMesa() +
               '}';
    }
}