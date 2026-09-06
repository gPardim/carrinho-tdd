package carrinho;

public class ItemCarrinho {

    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
