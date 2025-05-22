package modelo;


public class Trabajador {
    private String dni;
    private String nombre;
    private String apellidos;
    private int anyosExperiencia;

    public Trabajador() {}

    public Trabajador(String dni, String nombre, String apellidos, int anyosExperiencia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anyosExperiencia = anyosExperiencia;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getAnyosExperiencia() { return anyosExperiencia; }
    public void setAnyosExperiencia(int anyosExperiencia) { this.anyosExperiencia = anyosExperiencia; }

    @Override
    public String toString() {
        return dni + "," + nombre + "," + apellidos + "," + anyosExperiencia;
    }
}