package modelo;

public class Alimento {
    private int codAlimento;
    private String tipo;
    private String nombre;

    public Alimento() {}

    public Alimento(int codAlimento, String tipo, String nombre) {
        this.codAlimento = codAlimento;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public int getCodAlimento() { return codAlimento; }
    public void setCodAlimento(int codAlimento) { this.codAlimento = codAlimento; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Alimento{" +
               "codAlimento=" + codAlimento +
               ", tipo='" + tipo + '\'' +
               ", nombre='" + nombre + '\'' +
               '}';
    }
}