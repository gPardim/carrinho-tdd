package carrinho;

import carrinho.exceptions.EstoqueInsuficienteException;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<ItemCarrinho> itens = new ArrayList<>();

        public double calcularTotal() {
                double total = 0.0;
                        for (ItemCarrinho item : itens) {
                                    total += item.calcularSubtotal();
                                            }
                                                    return total;
                                                        }

                                                            public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException {
                                                                    if (quantidade > produto.getEstoque()) {
                                                                                throw new EstoqueInsuficienteException(
                                                                                                    "Estoque insuficiente para o produto " + produto.getNome() + ".");
                                                                                                            }
                                                                                                                    itens.add(new ItemCarrinho(produto, quantidade));
                                                                                                                        }
                                                                                                                        }
