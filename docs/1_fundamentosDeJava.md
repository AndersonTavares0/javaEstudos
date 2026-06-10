
---

## Versões e Ambiente de Desenvolvimento

* **Versões de Mercado:** As versões `JDK 8` e `JDK 11` continuam sendo amplamente utilizadas como padrões de mercado para sistemas corporativos estáveis e sistemas legados devido ao seu suporte de longo prazo (LTS).
* **Diretório `src` (Source):** Pasta raiz que armazena todos os pacotes e arquivos de código-fonte (`.java`) criados no projeto.
* **External Libraries:** Conjunto de arquivos, pacotes e bibliotecas nativas do próprio JDK que dão sustentação para a aplicação rodar.
* **Pastas `.idea` e arquivos `.iml`:** Arquivos de configuração internos gerados automaticamente pela IDE (como o IntelliJ IDEA) para gerenciar o projeto localmente. Eles não devem ser modificados e não causam impacto na lógica do código Java.

---

## Ciclo de Execução e Compilação

O Java é uma linguagem híbrida: ela é **compilada** para gerar uma linguagem intermediária e depois **interpretada** pela máquina virtual.

* **`javac`:** Comando utilizado no terminal para invocar diretamente o compilador do Java. Ele lê o arquivo `.java` e valida a sintaxe.
* **Arquivo `.class`:** O arquivo físico gerado automaticamente pelo compilador (`javac`) após a verificação do código. Ele armazena o bytecode do programa.
* **Bytecode:** O código intermediário de baixo nível gerado após a compilação. Ele é independente de plataforma (funciona em Windows, Mac ou Linux) e está pronto para ser lido pela JVM.
* **JVM (Java Virtual Machine):** A Máquina Virtual do Java. Ela interpreta o bytecode (arquivo `.class`) e o traduz para a linguagem binária específica do sistema operacional onde o programa está rodando.

### O Fluxo Visual de Execução
```text
[app.java] (Código-fonte) ──(compilador javac)──> [app.class] (Bytecode) ──(JVM)──> Execução no Hardware
````

## Organização de Arquivos, Pastas e Pacotes

### Regras de Estrutura

- **Vínculo de Nome:** O nome da classe interna deve ser rigorosamente **idêntico** ao nome do arquivo físico no disco (ex: a classe `public class NomeDaClasse` deve estar salva em um arquivo chamado `NomeDaClasse.java`).

- **Diretório `out`:** Pasta de saída gerada pela IDE onde ficam guardados os arquivos compilados (`.class`).


### Estrutura de Pacotes (Packages)

Os pacotes servem para organizar logicamente o projeto em subpastas e evitar conflitos de nomes de classes.

- **Hierarquia Visual Padrão:** ```text

  src/

  └── devdojo/

  └── exercicios/

  └── MeuPrograma.java

- **Diretriz Obrigatória:** Todo arquivo de código que estiver dentro de um pacote precisa obrigatoriamente declarar o caminho desse pacote exatamente na **primeira linha** do código, utilizando letras totalmente minúsculas.

  Java

    ```
    package devdojo.exercicios;
    ```


## Tipos de Comentários no Java

O Java possui três formas distintas de inserir comentários que são completamente ignorados pelo compilador durante a geração do bytecode:

Java

```
// 1. Comentário de Linha Única: Usado para explicações rápidas e diretas.

/*
 * 2. Comentário de Bloco:
 * Permite escrever textos longos que se estendem
 * por múltiplas linhas sem a necessidade de repetir as barras.
 */

/**
 * 3. JavaDoc (Comentário de Documentação Oficial):
 * Começa com uma barra e dois asteriscos (/**). É utilizado para documentar 
 * a utilidade de classes e métodos de forma profissional. Ferramentas conseguem 
 * ler este bloco e gerar uma página de documentação HTML automaticamente.
 */
```

## Sintaxe Básica e Estrutura Mínima (Hello World)

Todo programa em Java precisa de uma classe e de um método de entrada principal chamado `main` para poder iniciar a execução.

Java

```
package devdojo.fundamentos;

public class HelloWorld {
    // O ponto de entrada que a JVM procura para rodar o código
    public static void main(String[] args) {
        // Exibe o texto no console e pula para a próxima linha
        System.out.println("Hello World");
    }
}
```

## Atalhos de Produtividade (Live Templates no IntelliJ)

Para acelerar a escrita de blocos de códigos repetitivos, digite a palavra-chave abaixo no editor e pressione a tecla **TAB** ou **Enter**.

### 1. Estruturas Iniciais Básicas

- `psvm` : Cria a linha do método de entrada principal:

  `public static void main(String[] args) { }`

- `sout` : Cria o comando padrão de saída de dados no console:

  `System.out.println();`


### 2. Variações de Impressão (Família do `sout`)

- `soutv` : Imprime a variável mais próxima criada acima, já incluindo o nome e o valor dela formatados.

    - _Exemplo:_ Se tiver `int idade = 10;`, gera: `System.out.println("idade = " + idade);`

- `soutm` : Cria o comando de impressão pré-preenchido com o nome da classe e do método atual.

    - _Gera:_ `System.out.println("NomeDaClasse.main");`

- `soutp` : Cria um comando que lista e imprime todos os parâmetros recebidos pelo método atual.


### 3. Estruturas Lógicas e de Repetição

- `ifn` : Monta uma verificação condicional para saber se um objeto é nulo (`null`).

    - _Gera:_ `if (variavel == null) { }`

- `inn` : Monta a verificação oposta, testando se o objeto não é nulo.

    - _Gera:_ `if (variavel != null) { }`

- `fori` : Cria a estrutura completa de um loop indexado padrão.

    - _Gera:_ `for (int i = 0; i < ; i++) { }`


> Dica de controle: Caso queira ver a lista completa de atalhos disponíveis no ponto exato do seu cursor, use o comando `Ctrl + J` (Windows/Linux) ou `Cmd + J` (Mac).