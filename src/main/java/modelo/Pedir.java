package modelo;

public class Pedir {
    private String codPedido;
    private  String codFactura;

    public Pedir() {}

    public Pedir(String codPedido, String codFactura) {
        this.codPedido = codPedido;
        this.codFactura = codFactura;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public String toString() {
        return "Pedir{" +
                "codPedido='" + codPedido + '\'' +
                ", codFactura='" + codFactura + '\'' +
                '}';
    }
}
