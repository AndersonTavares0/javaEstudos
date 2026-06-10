
---
## Convenções de Nomenclatura e Declaração

* **Palavras Reservadas:** O Java possui 8 tipos primitivos. Todos são escritos estritamente em letras minúsculas (`int`, `double`, `float`, `char`, `byte`, `short`, `long`, `boolean`) e são palavras-chave protegidas pelo sistema.
* **camelCase:** A convenção para nomes de variáveis e métodos determina que a primeira letra da primeira palavra seja minúscula e a inicial das palavras seguintes seja maiúscula.
    * *Exemplos:* `salarioDouble`, `idadeDoUsuario`, `quantidadePlantoesExtras`, `isFichaLimpa`.
* **Operador de Atribuição (`=`):** Significa que a variável está recebendo e armazenando um valor específico no espaço alocado na memória RAM. Não significa igualdade matemática (para igualdade, usa-se `==`).

---

## Estrutura Básica e Exibição de Dados

### Declaração Simples
```java
public class DevDojoTiposPrimitivos {
    public static void main(String[] args) {
        int age = 10;
        System.out.println(age);
    }
}
````

### Exibição com Texto (Concatenação)

Para exibir textos fixos junto com o valor de variáveis, utiliza-se aspas duplas `""` para criar uma String e o operador `+` para colar (concatenar) as partes.

Java

```
public class DevDojoTiposPrimitivos {
    public static void main(String[] args) {
        String nome = "Alexandre";
        int age = 10;
        double salario = 1500.0;

        // Exemplo 1: Concatenação simples
        System.out.println("A idade é " + age);

        // Exemplo 2: Múltiplas concatenações na mesma linha
        System.out.println("O funcionário " + nome + " tem " + age + " anos e recebe R$ " + salario);
    }
}
```

## Tabela de Referência Rápida dos Tipos Primitivos

O motivo principal da existência de múltiplos tipos de variáveis é a otimização do uso de memória e a eficiência de processamento do hardware.

|**Tipo Primitivo**|**Espaço em Memória**|**Tipo de Dado**|**Quando Utilizar (Aplicação Prática)**|
|---|---|---|---|
|`boolean`|1 bit (indireto)|Lógico|Flags de estado, permissões e controle. Ex: `isAutenticado`, `isActive`.|
|`byte`|1 byte (8 bits)|Inteiro curto|Manipulação de arquivos brutos, imagens, vídeos ou buffers de rede.|
|`char`|2 bytes (16 bits)|Caractere|Armazenar uma única letra ou símbolo via aspas simples. Ex: `'M'`, `'A'`, `'7'`.|
|`short`|2 bytes (16 bits)|Inteiro curto|Otimização estrita de arrays numéricos massivos. Praticamente nulo no mercado.|
|`int`|4 bytes (32 bits)|Inteiro padrão|Uso padrão para contadores, índices de loops, IDs simples e matemática geral.|
|`float`|4 bytes (32 bits)|Decimal|Gráficos 3D, engines de jogos ou física onde velocidade importa mais que precisão.|
|`double`|8 bytes (64 bits)|Decimal padrão|Uso padrão para números fracionários reais, moedas, coordenadas e cálculos.|
|`long`|8 bytes (64 bits)|Inteiro longo|IDs de grande escala, contagens astronômicas e timestamps (milissegundos).|

### Inicialização dos 8 Tipos Primitivos no Código

Java

```
public class DevDojoTiposPrimitivos {
    public static void main(String[] args) {
        int age = 10;
        double salarioDouble = 2500.0D; // O 'D' é opcional, pois double já é o padrão decimal
        float salarioFloat = 2500.0F;   // O 'F' é obrigatório para não compilar como double
        byte idadeByte = -128;          // Limite mínimo do byte
        short idadeShort = 10;
        boolean falso = false;
        boolean verdadeiro = true;
        char caractereLetra = 'A';      // Declaração padrão com aspas simples
        char caractereAscii = 65;       // O número 65 corresponde à letra 'A' na tabela ASCII/Unicode

        System.out.println(age);
        System.out.println(salarioFloat);
        System.out.println(caractereAscii); // Vai imprimir: A
    }
}
```

## Frequência de Uso no Mercado Comercial

Na maioria dos cenários de software corporativo, você utilizará quase exclusivamente apenas **quatro** tipos principais:

- `int`: Tipo definitivo para contagens ordinais, idades, estoques e loops.

- `double`: Escolha automática para qualquer número fracionário (porcentagens, médias, valores monetários simples).

- `boolean`: Base estrutural para tomada de decisões lógicas (`if` / `else`).

- `long`: Utilizado massivamente para chaves primárias (IDs) em bancos de dados e registros de data/hora.


### Classificação por Frequência

|**Tipo Primitivo**|**Frequência de Uso**|**Motivo do Uso Dominante**|
|---|---|---|
|`int`|Altíssima|Padrão nativo da JVM para inteiros. Evita conversões forçadas (casts).|
|`double`|Altíssima|Oferece a precisão decimal necessária para a maioria dos cálculos reais.|
|`boolean`|Altíssima|Base para qualquer lógica condicional dentro do sistema.|
|`long`|Alta|Garante que IDs de grandes volumes de dados não sofram estouro de limite.|
|`char`|Baixa|Geralmente substituído pela classe String, que lida com textos completos.|
|`byte`|Rara|Restrito a cenários de infraestrutura de leitura de arquivos e streams de rede.|
|`float`|Rara|Substituído pelo double, exceto em processamento gráfico de alta performance.|
|`short`|Quase Nula|Praticamente sem aplicação no desenvolvimento comercial moderno.|

## Tipo de Dado Literal vs. Casting Primitivo

### 1. A Analogia das Caixas de Memória

O Java gerencia o espaço em memória através de tamanhos fixos e rígidos de caixas:

- **Caixa Pequena (`float`):** Ocupa 4 bytes.

- **Caixa Grande (`double`):** Ocupa 8 bytes. Este é o padrão automático para qualquer número decimal escrito diretamente no código.


O compilador impede que você insira o conteúdo de uma Caixa Grande dentro de uma Caixa Pequena de forma automática para evitar que dados sumam se o número for muito grande.

Java

```
// ISTO GERA ERRO DE COMPILAÇÃO:
float salario = 2500.0; // O Java interpreta 2500.0 como double e bloqueia a linha.
```

### 2. As Duas Soluções Práticas

#### Solução A: O Sufixo Literal (letra f)

Informa ao compilador o tamanho exato da caixa antes do número ser instanciado na memória. Usado ao digitar valores decimais manualmente no código.

Java

```
// O "f" força o compilador a criar o número ocupando diretamente apenas 4 bytes
float salarioDefinido = 2500.0f; 
double precoNotebook = 4500.99; // Sem sufixo, assume double automaticamente
```

#### Solução B: O Casting Explícito `(float)` ou `(int)`

Uma instrução manual que força a conversão de um tipo maior para um tipo menor. O processador "trunca" (corta fora) o tamanho do dado, descartando o excesso.

Java

```
// Cenário 1: O dado vem como double e precisa virar float
double salarioDoBanco = 5000.50;
float salarioDoSistema = (float) salarioDoBanco; 

// Cenário 2: Truncamento intencional (Descartar casas decimais)
double taxaPreco = 99.99;
int precoSemQuebrado = (int) taxaPreco; // Corta o ".99". O resultado armazenado será exatamente 99.
```

### 3. Guia de Decisão Rápida

- Digitando o número decimal manualmente no código? Use o sufixo `f` no final (exemplo: `150.75f`).

- O dado decimal veio de uma variável `double` e precisa passar para `float`? Use o cast na frente: `(float) variavel`.

- Deseja eliminar os decimais e manter apenas o número inteiro? Use o cast para inteiro: `(int) variavel`.


> ⚠️ **Nota de mercado:** Em sistemas reais, quase não se usa o casting de primitivos para regras de negócio cotidianas. Prefere-se usar diretamente os tipos corretos (`int` e `double`) ou classes de conversão específicas para evitar perda acidental de dados.

## Classe String (Não é tipo primitivo)

A `String` é uma **Classe** (um tipo de referência) e não um tipo primitivo. Ela serve para armazenar cadeias de caracteres textuais completas (palavras, frases, textos longos).

- **Diferença visual:** Tipos primitivos começam com letra minúscula (`int`, `double`). A `String` começa com a **letra S maiúscula**, seguindo a convenção de classe (PascalCase).

- **Declaração:** Utiliza obrigatoriamente **aspas duplas** `""`.


Java

```
public class ExemploString {
    public static void main(String[] args) {
        // Declaração padrão da classe String
        String textoModoGeral = "hello world";
        String fraseCompleta = "Estudando Java no DevDojo em 2026";
        String textoVazio = ""; // Uma String pode conter zero caracteres
        
        System.out.println(textoModoGeral);
    }
}
```