/*
Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:

Eu <nome>, morando no endereço <endereço>, confirmo que recebi o salário de <salario>, na data <data>.
 */
package devdojo_exercicios;

public class exercicio1 {
    public static void main(String[] args) {
        String name = "Alexandre Frota";
        String andress = "Rua Augusta";
        String date = "01/01/1900";
        double wage = 1.621;
        System.out.println("Eu " +name+" morando no endereço " +andress+", confirmo que recebi o salário de R$ "+wage+", na data de "+date);
    }
}
