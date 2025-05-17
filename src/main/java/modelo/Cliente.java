package modelo;


public class Cliente {
    private int numCliente;
    private String nombre;
    private int numMesa;

    public Cliente() {}

    public Cliente(int numCliente, String nombre, int numMesa) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.numMesa = numMesa;
    }

    public int getNumCliente() { return numCliente; }
    public void setNumCliente(int numCliente) { this.numCliente = numCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getMesa() { return numMesa; }
    public void setMesa(Mesa mesa) { this.numMesa = numMesa; }

    @Override
    public String toString() {
        return "Cliente{" +
               "numCliente=" + numCliente +
               ", nombre='" + nombre + '\'' +
               ", mesa=" + numMesa +
               '}';
    }
}