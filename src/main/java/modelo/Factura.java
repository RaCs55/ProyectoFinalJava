package modelo;

public class Factura {
    private String codFactura;
    private String formaPago;
    private double precioTotal;

    public Factura() {}

    public Factura(String codFactura, String formaPago, double precioTotal) {
        this.codFactura = codFactura;
        this.formaPago = formaPago;
        this.precioTotal = precioTotal;
    }

    public String getCodFactura() { return codFactura; }
    public void setCodFactura(String codFactura) { this.codFactura = codFactura; }

    public String getFormaPago() { return formaPago; }
    public void setFormaPago(String formaPago) { this.formaPago = formaPago; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    @Override
    public String toString() {
        return "Factura{" +
               "codFactura='" + codFactura + '\'' +
               ", formaPago='" + formaPago + '\'' +
               ", precioTotal=" + precioTotal +
               '}';
    }
}