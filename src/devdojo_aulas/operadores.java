/*
Opeadores aritmeticos são +, -, /, *
% é utilizado para o módulo/resto de uma divisão.

Operadores lógicos são
And = && que se faz utilizando SHIFT + 7
! = negação
|| = or

Operadores boolean < > e <= e >=
== é comparação
!= diferente de

padrão em tipo boolean é começar a variavel com is
 */
package devdojo_aulas;

public class operadores {
    public static void main(String[] args) {
        // INTEIRO
        int number1 = 67;
        int number2 = 69;
        double result = number1 / (double) number2;
        System.out.println(result);

        // && (AND) || (OR) !
        int age = 30;
        float wage = 5000;
        boolean isDentroDaLeiSeIdadeForMaiorOuIgualaTrinta = age >= 30 && wage >=4612;
        boolean isForaDaLeiSeIdadeForMaiorOuIgualaTrinta = age < 30 && wage >=3381;

        System.out.println(isDentroDaLeiSeIdadeForMaiorOuIgualaTrinta);
        System.out.println(isForaDaLeiSeIdadeForMaiorOuIgualaTrinta);

    }
}


