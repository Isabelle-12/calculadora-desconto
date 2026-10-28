package br.pucpr.tde;

public class CalculadoraDescontoTradicional {

    public double calcularValorFinal(double valorTotal, boolean vip) {
        // Estação 1: valida a entrada
        if (valorTotal <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }

        double valor = valorTotal;

        // Estação 2: desconto por faixa (não acumulam: vale só a maior faixa)
        if (valorTotal > 1000.00) {
            valor = valor * 0.80;   // 20%
        } else if (valorTotal > 500.00) {
            valor = valor * 0.90;   // 10%
        }

        // Estação 3: desconto VIP, sobre o valor que já foi descontado
        if (vip) {
            valor = valor * 0.95;   // 5%
        }

        // Estação 4: frete, decidido depois de todos os descontos
        if (valor < 100.00) {
            valor = valor + 15.00;
        }

        return valor;
    }
}