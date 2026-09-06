package carrinho;

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

        public void adicionarItem(Produto produto, int quantidade) {
            itens.add(new ItemCarrinho(produto, quantidade));
        }
}