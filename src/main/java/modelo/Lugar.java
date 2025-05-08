package modelo;


public class Lugar {
    private String codLugar;
    private String direccion;

    public Lugar() {}

    public Lugar(String codLugar, String direccion) {
        this.codLugar = codLugar;
        this.direccion = direccion;
    }

    public String getCodLugar() { return codLugar; }
    public void setCodLugar(String codLugar) { this.codLugar = codLugar; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Lugar{" +
               "codLugar='" + codLugar + '\'' +
               ", direccion='" + direccion + '\'' +
               '}';
    }
}