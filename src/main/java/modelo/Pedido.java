package modelo;


public class Pedido {
    private String codPedido;
    private String comida;
    private String bebida;
    private String formaDePago;

    public Pedido() {}

    public Pedido(String codPedido, String comida, String bebida, String formaDePago) {
        this.codPedido = codPedido;
        this.comida = comida;
        this.bebida = bebida;
        this.formaDePago = formaDePago;
    }

    public String getCodPedido() { return codPedido; }
    public void setCodPedido(String codPedido) { this.codPedido = codPedido; }

    public String getComida() { return comida; }
    public void setComida(String comida) { this.comida = comida; }

    public String getBebida() { return bebida; }
    public void setBebida(String bebida) { this.bebida = bebida; }


    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString() {
        return codPedido + "," + comida + "," + bebida;
    }
}