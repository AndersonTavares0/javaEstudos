/*
Exercício 1: Cálculo de Salário Líquido e Casting

Objetivo: Praticar o uso de tipos primitivos numéricos, operadores aritméticos e conversão explícita de tipo (casting).

Enunciado: Um desenvolvedor júnior recebe um salário bruto mensal de R$ 5000. Desse valor, são descontados 11% de imposto retido na fonte.
Além disso, ele recebeu um bônus adicional fixo de R$ 250.50 centavos.

O que fazer:

Declare as variáveis necessárias utilizando os tipos primitivos mais adequados para dinheiro (double).

Calcule o valor do imposto e o salário líquido final (Salário Bruto - Imposto + Bônus).

 Printe o salário líquido no console usando o sout.

Desafio do Casting: Pegue o valor do salário líquido final e converta-o explicitamente para um tipo inteiro (int),
o resultado em uma nova variável chamada salarioTruncado.
Printe o valor final truncado na tela e observe o que aconteceu com os centavos.
 */

package devdojo_exercicios;

public class exercicio2 {
    public static void main(String[] args) {
        //Declaração de variaveis
        double salarioBruto = 5000;
        double bonus = 250;

        //Calculo do Imposto, utilizando * para multiplicação
        double valorImposto = salarioBruto * 0.11;

        //calculo com Bonus
        double valorLiquido = salarioBruto - valorImposto + bonus;

        //print com lineBreak
        System.out.println("O valor Líquido é R$ "+valorLiquido);

        //Casting
        int salarioTrucado = (int) valorLiquido;
        System.out.println("O valor final trucado é R$ " + salarioTrucado);
    }
}
