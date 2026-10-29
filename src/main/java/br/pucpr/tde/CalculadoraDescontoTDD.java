package br.pucpr.tde;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valorTotal) {
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }
        return valorTotal;
    }
}