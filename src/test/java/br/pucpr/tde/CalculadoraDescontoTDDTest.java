package br.pucpr.tde;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTDDTest {

    private final CalculadoraDescontoTDD calc = new CalculadoraDescontoTDD();
    private static final double DELTA = 0.001;

    @Test
    void valorZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(0));
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(-10));
    }

    @Test
    void valorAbaixoDe500NaoTemDesconto() {
        assertEquals(400.00, calc.calcularValorFinal(400), DELTA);
    }

    @Test
    void valorAcimaDe500Tem10PorCentoDeDesconto() {
        assertEquals(540.00, calc.calcularValorFinal(600), DELTA);
    }
}