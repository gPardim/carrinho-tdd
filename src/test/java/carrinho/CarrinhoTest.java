package carrinho;

import carrinho.exceptions.EstoqueInsuficienteException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void deveLancarExcecaoAoAdicionarQuantidadeMaiorQueEstoque() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Caneta", 2.50, 5);

        assertThrows(EstoqueInsuficienteException.class,
        () -> carrinho.adicionarItem(produto, 6));
    }

    @Test
    void deveReduzirTotalAoRemoverItem() throws Exception {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Caneta", 2.50, 10);
        carrinho.adicionarItem(produto, 3);

        carrinho.removerItem(produto);

        assertEquals(0.0, carrinho.calcularTotal());
    }

    
}