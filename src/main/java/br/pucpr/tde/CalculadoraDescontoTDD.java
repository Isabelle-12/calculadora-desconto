package br.pucpr.tde;

public class CalculadoraDescontoTDD {

    private static final double LIMITE_DESCONTO_10 = 500.00;
    private static final double FATOR_DESCONTO_10 = 0.90;

    public double calcularValorFinal(double valorTotal) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }
        if (valorTotal > 1000.00) {
            return valorTotal * 0.80;
        }
        if (valorTotal > LIMITE_DESCONTO_10) {
            return valorTotal * FATOR_DESCONTO_10;
        }
        return valorTotal;
    }
}