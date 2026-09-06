package carrinho;

import carrinho.exceptions.CarrinhoVazioException;
import carrinho.exceptions.CupomJaAplicadoException;
import carrinho.exceptions.EstoqueInsuficienteException;
import carrinho.exceptions.CupomInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<ItemCarrinho> itens = new ArrayList<>();
    private Cupom cupomAplicado;

    public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        validarEstoqueDisponivel(produto, quantidade);
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto() == produto);
    }

    public void aplicarCupom(Cupom cupom) throws CupomJaAplicadoException, CupomInvalidoException {
        if (cupomAplicado != null) {
            throw new CupomJaAplicadoException(
                "Um cupom ja foi aplicado a este carrinho.");
        }
        if (cupom.getPercentualDesconto() > 100.0) {
            throw new CupomInvalidoException(
                "O desconto do cupom nao pode tornar o total negativo.");
        }
        this.cupomAplicado = cupom;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotalItens();
        return aplicarDescontoSeHouver(subtotal);
    }

    public void finalizarCompra() throws CarrinhoVazioException {
        if (itens.isEmpty()) {
            throw new CarrinhoVazioException(
                    "Nao e possivel finalizar a compra de um carrinho vazio.");
        }
    }

    private void validarEstoqueDisponivel(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > produto.getEstoque()) {
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente para o produto " + produto.getNome() + ".");
        }
    }

    private double calcularSubtotalItens() {
        double subtotal = 0.0;
        for (ItemCarrinho item : itens) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal;
    }

    private double aplicarDescontoSeHouver(double subtotal) {
        if (cupomAplicado == null) {
            return subtotal;
        }
        return subtotal - subtotal * (cupomAplicado.getPercentualDesconto() / 100.0);
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   