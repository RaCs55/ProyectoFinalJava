package modelo;


import java.util.Date;

public class Gerente extends Trabajador {
    private Date fechaInicio;

    public Gerente() {}

    public Gerente(String dni, String nombre, String apellidos, int anyosExperiencia, Date fechaInicio) {
        super(dni, nombre, apellidos, anyosExperiencia);
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    @Override
    public String toString() {
        return super.toString() + 
               " Gerente{" +
               "fechaInicio=" + fechaInicio +
               '}';
    }
}