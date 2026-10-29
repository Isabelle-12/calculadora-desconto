package br.pucpr.tde;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTradicionalTest {

    private final CalculadoraDescontoTradicional calc = new CalculadoraDescontoTradicional();
    private static final double DELTA = 0.001;

    // Validação
    @Test
    void valorZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(0, false));
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(-10, false));
    }

    // Faixas de desconto
    @Test
    void semDescontoAbaixoDe500() {
        assertEquals(400.00, calc.calcularValorFinal(400, false), DELTA);
    }

    @Test
    void exatos500NaoTemDesconto() {
        assertEquals(500.00, calc.calcularValorFinal(500, false), DELTA);
    }

    @Test
    void acima500Tem10PorCento() {
        assertEquals(540.00, calc.calcularValorFinal(600, false), DELTA);
    }

    @Test
    void exatos1000Tem10PorCento() {
        assertEquals(900.00, calc.calcularValorFinal(1000, false), DELTA);
    }

    @Test
    void acima1000Tem20PorCento() {
        assertEquals(1200.00, calc.calcularValorFinal(1500, false), DELTA);
    }

    // VIP
    @Test
    void vipTem5PorCentoSobreValorDescontado() {
        assertEquals(513.00, calc.calcularValorFinal(600, true), DELTA);
    }

    @Test
    void vipSemFaixaDeDesconto() {
        assertEquals(380.00, calc.calcularValorFinal(400, true), DELTA);
    }

    // Frete
    @Test
    void abaixoDe100CobraFrete() {
        assertEquals(95.00, calc.calcularValorFinal(80, false), DELTA);
    }

    @Test
    void exatos100NaoCobraFrete() {
        assertEquals(100.00, calc.calcularValorFinal(100, false), DELTA);
    }

    @Test
    void vipQueFicaAbaixoDe100CobraFrete() {
        // 105 * 0,95 = 99,75 -> frete -> 114,75
        assertEquals(114.75, calc.calcularValorFinal(105, true), DELTA);
    }
}