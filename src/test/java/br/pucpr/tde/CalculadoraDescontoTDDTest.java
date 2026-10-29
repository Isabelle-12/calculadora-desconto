package br.pucpr.tde;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTDDTest {

    private final CalculadoraDescontoTDD calc = new CalculadoraDescontoTDD();
    private static final double DELTA = 0.001;

    @Test
    void valorZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(0, false));
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(-10, false));
    }

    @Test
    void valorAbaixoDe500NaoTemDesconto() {
        assertEquals(400.00, calc.calcularValorFinal(400, false), DELTA);
    }

    @Test
    void valorAcimaDe500Tem10PorCentoDeDesconto() {
        assertEquals(540.00, calc.calcularValorFinal(600, false), DELTA);
    }

    @Test
    void exatos500NaoTemDesconto() {
        assertEquals(500.00, calc.calcularValorFinal(500, false), DELTA);
    }

    @Test
    void valorAcimaDe1000Tem20PorCentoDeDesconto() {
        assertEquals(1200.00, calc.calcularValorFinal(1500, false), DELTA);
    }

    @Test
    void exatos1000Tem10PorCentoDeDesconto() {
        assertEquals(900.00, calc.calcularValorFinal(1000, false), DELTA);
    }

    @Test
    void vipTem5PorCentoSobreValorJaDescontado() {
        assertEquals(513.00, calc.calcularValorFinal(600, true), DELTA);
    }

    @Test
    void vipSemFaixaDeDescontoTem5PorCento() {
        assertEquals(380.00, calc.calcularValorFinal(400, true), DELTA);
    }

    @Test
    void valorFinalAbaixoDe100CobraFrete() {
        assertEquals(95.00, calc.calcularValorFinal(80, false), DELTA);
    }
}