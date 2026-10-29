package br.pucpr.tde;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valorTotal) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }
        if (valorTotal > 500.00) {
            return valorTotal * 0.90;
        }
        return valorTotal;
    }
}