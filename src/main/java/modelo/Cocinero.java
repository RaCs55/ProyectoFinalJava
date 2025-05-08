package modelo;


public class Cocinero extends Trabajador {
    private String especialidad;
    private Cocinero cocineroSupervisor;

    public Cocinero() {}

    public Cocinero(String dni, String nombre, String apellidos, int anyosExperiencia, 
                   String especialidad, Cocinero cocineroSupervisor) {
        super(dni, nombre, apellidos, anyosExperiencia);
        this.especialidad = especialidad;
        this.cocineroSupervisor = cocineroSupervisor;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public Cocinero getCocineroSupervisor() { return cocineroSupervisor; }
    public void setCocineroSupervisor(Cocinero cocineroSupervisor) { 
        this.cocineroSupervisor = cocineroSupervisor; 
    }

    @Override
    public String toString() {
        return super.toString() + 
               " Cocinero{" +
               "especialidad='" + especialidad + '\'' +
               ", cocineroSupervisor=" + (cocineroSupervisor != null ? cocineroSupervisor.getDni() : "null") +
               '}';
    }
}