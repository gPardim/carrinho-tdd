package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarrinhoTest {

    @Test
    void carrinhoVazioTemTotalZero() {
        Carrinho carrinho = new Carrinho();
        assertEquals(0.0, carrinho.calcularTotal());
    }

     @Test
     void deveAumentarTotalAoAdicionarItem() throws Exception {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Caneta", 2.50, 10);

        carrinho.adicionarItem(produto, 3);

        assertEquals(7.50, carrinho.calcularTotal());
    }
}