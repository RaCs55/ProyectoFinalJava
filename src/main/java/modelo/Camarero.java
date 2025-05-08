package modelo;

public class Camarero extends Trabajador {
    private String zona;

    public Camarero() {}

    public Camarero(String dni, String nombre, String apellidos, int anyosExperiencia, String zona) {
        super(dni, nombre, apellidos, anyosExperiencia);
        this.zona = zona;
    }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    @Override
    public String toString() {
        return super.toString() + 
               " Camarero{" +
               "zona='" + zona + '\'' +
               '}';
    }
}