package br.pucpr.tde;

public class CalculadoraDescontoTDD {

    private static final double LIMITE_DESCONTO_10 = 500.00;
    private static final double FATOR_DESCONTO_10 = 0.90;
    private static final double LIMITE_DESCONTO_20 = 1000.00;
    private static final double FATOR_DESCONTO_20 = 0.80;

    public double calcularValorFinal(double valorTotal) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }
        double valor = valorTotal;

        if (valorTotal > LIMITE_DESCONTO_20) {
            valor = valorTotal * FATOR_DESCONTO_20;
        } else if (valorTotal > LIMITE_DESCONTO_10) {
            valor = valorTotal * FATOR_DESCONTO_10;
        }

        return valor;
    }

    public double calcularValorFinal(double valorTotal, boolean vip) {
        double valor = calcularValorFinal(valorTotal);
        if (vip) {
            valor = valor * 0.95;
        }
        return valor;
    }
}