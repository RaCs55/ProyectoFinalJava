package modelo;


public class Pedido {
    private String codPedido;
    private String comida;
    private String bebida;

    public Pedido() {}

    public Pedido(String codPedido, String comida, String bebida) {
        this.codPedido = codPedido;
        this.comida = comida;
        this.bebida = bebida;
    }

    public String getCodPedido() { return codPedido; }
    public void setCodPedido(String codPedido) { this.codPedido = codPedido; }

    public String getComida() { return comida; }
    public void setComida(String comida) { this.comida = comida; }

    public String getBebida() { return bebida; }
    public void setBebida(String bebida) { this.bebida = bebida; }

    @Override
    public String toString() {
        return "Pedido{" +
               "codPedido='" + codPedido + '\'' +
               ", comida='" + comida + '\'' +
               ", bebida='" + bebida + '\'' +
               '}';
    }
}