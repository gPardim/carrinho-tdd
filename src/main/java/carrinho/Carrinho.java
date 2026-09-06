package carrinho;

import carrinho.exceptions.EstoqueInsuficienteException;
import carrinho.exceptions.CupomJaAplicadoException;
import carrinho.exceptions.CarrinhoVazioException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

        private final List<ItemCarrinho> itens = new ArrayList<>();
        private Cupom cupomAplicado;

        public double calcularTotal() {
                double total = 0.0;
                for (ItemCarrinho item : itens) {
                        total += item.calcularSubtotal();
                }
                if (cupomAplicado != null) {
                        total -= total * (cupomAplicado.getPercentualDesconto() / 100.0);
                }
                return total;
        }

        public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException {
                validarEstoqueDisponivel(produto, quantidade);
                itens.add(new ItemCarrinho(produto, quantidade));
        }

        public void removerItem(Produto produto) {
                itens.removeIf(item -> item.getProduto() == produto);
        }

        public void aplicarCupom(Cupom cupom) throws CupomJaAplicadoException {
                if (cupomAplicado != null) {
                        throw new CupomJaAplicadoException(
                                "Um cupom ja foi aplicado a este carrinho.");
                }
                this.cupomAplicado = cupom;
        }

        private void validarEstoqueDisponivel(Produto produto, int quantidade) throws EstoqueInsuficienteException {
                if (quantidade > produto.getEstoque()) {
                        throw new EstoqueInsuficienteException(
                                "Estoque insuficiente para o produto " + produto.getNome() + ".");
                }
        }

        public void finalizarCompra() throws CarrinhoVazioException {
                if (itens.isEmpty()) {
                        throw new CarrinhoVazioException(
                                "Nao e possivel finalizar a compra de um carrinho vazio.");
                }
        }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   