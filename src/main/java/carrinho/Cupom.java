package carrinho;

public class Cupom {

    private final String codigo;
    private final double percentualDesconto;

    public Cupom(String codigo, double percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}
