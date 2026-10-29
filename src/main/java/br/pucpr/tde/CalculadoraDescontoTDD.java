package br.pucpr.tde;

public class CalculadoraDescontoTDD {

    private static final double LIMITE_DESCONTO_10 = 500.00;
    private static final double FATOR_DESCONTO_10 = 0.90;
    private static final double LIMITE_DESCONTO_20 = 1000.00;
    private static final double FATOR_DESCONTO_20 = 0.80;
    private static final double FATOR_DESCONTO_VIP = 0.95;

    public double calcularValorFinal(double valorTotal, boolean vip) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }

        double valor = valorTotal;

        if (valorTotal > LIMITE_DESCONTO_20) {
            valor = valorTotal * FATOR_DESCONTO_20;
        } else if (valorTotal > LIMITE_DESCONTO_10) {
            valor = valorTotal * FATOR_DESCONTO_10;
        }

        if (vip) {
            valor = valor * FATOR_DESCONTO_VIP;
        }

        if (valor < 100.00) {
            valor = valor + 15.00;
        }

        return valor;
    }
}