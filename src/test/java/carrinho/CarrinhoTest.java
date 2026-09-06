package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarrinhoTest {

    @Test
    void carrinhoVazioTemTotalZero() {
        Carrinho carrinho = new Carrinho();
        assertEquals(0.0, carrinho.calcularTotal());
    }
}
