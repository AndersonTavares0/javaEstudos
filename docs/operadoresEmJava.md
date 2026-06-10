
---
## Operadores Aritméticos
Usados para realizar cálculos matemáticos básicos sobre variáveis numéricas.

* `+` : Adição (também usado para juntar textos)
* `-` : Subtração
* `/` : Divisão
* `*` : Multiplicação

### Exemplo Prático e Comportamentos Cruciais
```java
public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        int soma = a + b;          // Resultado: 15
        int subtracao = a - b;     // Resultado: 5
        int multiplicacao = a * b; // Resultado: 50
        
        // CUIDADO: Divisão de inteiros desconsidera as casas decimais
        int divisaoInteira = 5 / 2; // Resultado: 2 (o correto seria 2.5, mas o tipo int corta o quebrado)
        
        // Para obter o resultado decimal real:
        double divisaoReal = 5.0 / 2; // Resultado: 2.5 (pelo menos um número precisa ser decimal)
        
        System.out.println("Soma: " + soma);
        System.out.println("Divisão Real: " + divisaoReal);
    }
}
````

## Operador de Módulo (`%`)

Retorna estritamente o **resto** que sobra de uma divisão inteira entre dois números.

### Exemplo Prático e Casos de Uso

Java

```
public class OperadorModulo {
    public static void main(String[] args) {
        // Cenário 1: Descobrindo o resto de uma divisão quebrada
        int resto1 = 10 % 3; // Resultado: 1 (10 dividido por 3 dá 3, e sobra 1)
        
        // Cenário 2: Verificando se um número é PAR ou ÍMPAR (Aplicação real em loops)
        int numeroPar = 4;
        int numeroImpar = 7;
        
        int restoPar = numeroPar % 2;   // Resultado: 0 (Toda divisão exata por 2 dá resto 0)
        int restoImpar = numeroImpar % 2; // Resultado: 1 (Todo número ímpar dividido por 2 deixa resto 1)
        
        System.out.println("Resto 1: " + resto1);
        System.out.println("O número 4 é par? Resto: " + restoPar);
    }
}
```

## Operadores Relacionais / Booleanos

Usados para realizar comparações entre valores. O resultado de qualquer operação relacional é sempre um valor estritamente lógico: `true` ou `false`.

- `<` : Menor que

- `>` : Maior que

- `<=` : Menor ou igual a

- `>=` : Maior ou igual a

- `==` : Igual a (Comparação de igualdade de valores)

- `!=` : Diferente de (Verifica se os valores são distintos)


### Exemplo Prático com Múltiplos Casos

Java

```
public class OperadoresRelacionais {
    public static void main(String[] args) {
        int x = 20;
        int y = 10;
        int z = 20;

        boolean menor = x < y;       // Resultado: false
        boolean maior = x > y;       // Resultado: true
        boolean igual = x == z;      // Resultado: true (20 é igual a 20)
        boolean diferente = x != y;  // Resultado: true (20 é diferente de 10)
        boolean menorOuIgual = x <= z; // Resultado: true (20 não é menor, mas é IGUAL a 20)

        // Alerta de Iniciante: NÃO confunda '=' com '=='
        int numero = 5; // '=' guarda o valor 5 dentro da variável
        boolean comparacao = (numero == 5); // '==' pergunta se o valor lá dentro é igual a 5 (true)
    }
}
```

## Operadores Lógicos

Usados para conectar ou modificar múltiplas condições booleanas ao mesmo tempo dentro do sistema.

- `&&` : **AND** (E) -> Retorna `true` apenas se **todas** as condições individuais forem verdadeiras.

  > Dica de teclado: Digite pressionando a combinação `SHIFT + 7` duas vezes seguidas.

- `||` : **OR** (OU) -> Retorna `true` se pelo menos **uma** das condições testadas for verdadeira.

- `!` : **NOT** (Negação) -> Inverte o estado lógico atual da variável.


### Tabelas-Verdade de Referência

|**Condição A**|**Condição B**|**Resultado A && B (AND)**|**Resultado A \| B (OR)**|
|---|---|---|---|
|`true`|`true`|**`true`**|**`true`**|
|`true`|`false`|`false`|**`true`**|
|`false`|`true`|`false`|**`true`**|
|`false`|`false`|`false`|`false`|

### Exemplo Prático e Avaliação de Curto-Circuito (Short-Circuit)

O Java é inteligente: no operador `&&`, se a primeira condição for `false`, ele ignora o resto. No operador `||`, se a primeira for `true`, ele também ignora as próximas condições porque o resultado já está garantido.

Java

```
public class OperadoresLogicos {
    public static void main(String[] args) {
        boolean temIdade = true;
        boolean temCarteira = false;
        boolean temDinheiro = true;

        // Caso 1: Operador AND (&&) - Exigente
        boolean podeDirigir = temIdade && temCarteira; // Resultado: false (falta a carteira)

        // Caso 2: Operador OR (||) - Flexível
        // Basta ter a idade OU ter dinheiro para entrar no evento
        boolean podeEntrarNaFesta = temIdade || temDinheiro; // Resultado: true (um dos critérios basta)

        // Caso 3: Operador de Negação (!)
        boolean isUsuarioAtivo = true;
        boolean isUsuarioBloqueado = !isUsuarioAtivo; // Resultado: false (inverteu o true)
        
        // Caso 4: Misturando operadores lógicos com parênteses de prioridade
        // Regra fictícia: Pode viajar se tiver dinheiro E (tiver idade OU tiver carteira)
        boolean podeViajar = temDinheiro && (temIdade || temCarteira); // Resultado: true
    }
}
```

## Convenção para Variáveis Booleanas

Por padrão estrito de boas práticas no desenvolvimento de software de mercado, variáveis do tipo `boolean` devem ser nomeadas simulando uma **pergunta sobre o estado atual do dado**. Por isso, iniciamos sempre com prefixos verbais como `is`, `has` ou `pode` (em camelCase).

### Exemplos Práticos do Padrão Corporativo

Java

```
public class ConvençãoBooleans {
    public static void main(String[] args) {
        // Padrão correto internacional (Altamente recomendado):
        boolean isActive = true;       // Está ativo?
        boolean isClosed = false;      // Está fechado?
        boolean hasToken = true;       // Possui o token de acesso?
        
        // Padrão correto adaptado para Português comercial:
        boolean isAtivo = true;
        boolean temCadastro = false;
        boolean podeAvancar = true;
        
        // Jeito ERRADO que deve ser evitado (Nomes genéricos ou confusos):
        boolean ativo = true;     // Falta o prefixo de estado
        boolean cadastro = false; // Parece o nome de uma String ou Classe, não um boolean
        boolean verificar = true; // Parece o nome de um método de ação, não de uma variável
    }
}
```