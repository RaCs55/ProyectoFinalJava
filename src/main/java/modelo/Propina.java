package modelo;

public class Propina {
    private String codPropina;
    private String formaPago;
    private double cantidad;

    public Propina() {}

    public Propina(String codPropina, String formaPago, double cantidad) {
        this.codPropina = codPropina;
        this.formaPago = formaPago;
        this.cantidad = cantidad;
    }

    public String getCodPropina() { return codPropina; }
    public void setCodPropina(String codPropina) { this.codPropina = codPropina; }

    public String getFormaPago() { return formaPago; }
    public void setFormaPago(String formaPago) { this.formaPago = formaPago; }

    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return "Propina{" +
               "codPropina='" + codPropina + '\'' +
               ", formaPago='" + formaPago + '\'' +
               ", cantidad=" + cantidad +
               '}';
    }
}