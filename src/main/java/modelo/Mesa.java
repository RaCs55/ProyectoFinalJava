package modelo;


public class Mesa {
    private int numeroMesa;
    private int capacidad;

    public Mesa() {}

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
    }

    public int getNumeroMesa() { return numeroMesa; }
    public void setNumeroMesa(int numeroMesa) { this.numeroMesa = numeroMesa; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    @Override
    public String toString() {
        return "Mesa{" +
               "numeroMesa=" + numeroMesa +
               ", capacidad=" + capacidad +
               '}';
    }
}