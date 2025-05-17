package modelo;


public class Local {
    private String codLocal;
    private String direccion;

    public Local() {}

    public Local(String codLocal, String direccion) {
        this.codLocal = codLocal;
        this.direccion = direccion;
    }

    public String getCodLugar() { return codLocal; }
    public void setCodLugar(String codLugar) { this.codLocal = codLugar; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "Lugar{" +
               "codLugar='" + codLocal + '\'' +
               ", direccion='" + direccion + '\'' +
               '}';
    }
}