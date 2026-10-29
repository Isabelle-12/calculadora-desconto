package br.pucpr.tde;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTDDTest {

    private final CalculadoraDescontoTDD calc = new CalculadoraDescontoTDD();

    @Test
    void valorZeroLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularValorFinal(0));
    }
}