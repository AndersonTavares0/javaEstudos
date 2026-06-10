# Git e GitHub: Versionamento e Nuvem

---

## A Diferença entre Git e GitHub
Eles possuem papéis completamente diferentes no desenvolvimento de software.

* **Git (O Zelador Local):** É um **software** instalado na própria máquina. Ele funciona como um sistema de arquivos inteligente que grava o histórico de alterações do seu código. Ele não precisa de internet para funcionar.
* **GitHub (A Nuvem Pública):** É uma **plataforma online** (um site) que hospeda os repositórios do Git na internet. Ele serve para você salvar o código na nuvem, mostrar portfólio e trabalhar em equipe.

---

## O Ciclo de Vida dos Arquivos (Estados do Git)
Dentro do computador, o Git gerencia seus arquivos através de três áreas principais antes de enviar o código para a internet. Entender esse fluxo evita erros de sincronização.



1. **Working Directory (Diretório de Trabalho):** É a pasta real no seu computador onde você está digitando o código Java no IntelliJ. Os arquivos aqui estão "modificados", mas o Git ainda não os salvou no histórico.
2. **Staging Area / Index (A Área de Preparação):** É a esteira de carregamento. Quando você roda o comando `git add`, você está escolhendo quais arquivos modificados vão entrar no próximo "pacote de salvamento".
3. **Local Repository (Repositório Local):** É o cofre dentro do seu computador. Quando você roda `git commit`, o Git fecha o pacote da esteira e grava uma foto (*snapshot*) definitiva do seu código com um número de registro único.

---

## O Fluxo Visual de Sincronização

```text
[ Código na IDE ] ──( git add )──> [ Esteira / Staging ] ──( git commit )──> [ Cofre Local ] ──( git push )──> [ GitHub (Nuvem) ]

```

---

## Convenções de Nomenclatura para Git (Branches e PRs)

No ambiente profissional, as ramificações (*branches*) e os títulos dos Pull Requests seguem o padrão internacional baseado em **Conventional Commits**. Isso mantém o histórico legível e padronizado.

### 1. Prefixos de Tipos Utilizados (Padrão de Mercado)

* `feat/` : Desenvolvimento de uma nova funcionalidade ou código novo (ex: novos exercícios).
* `fix/` : Correção de um bug, erro de sintaxe ou código que estava quebrando.
* `docs/` : Alterações exclusivas em documentações, arquivos Markdown ou comentários.
* `chore/` : Tarefas de manutenção diária, configurações de IDE, atualização de `.gitignore` ou estruturas de pastas, sem mexer no código lógico.
* `refactor/` : Alterações que melhoram a estrutura do código atual sem mudar o seu comportamento final.

### 2. Padrão de Nomenclatura para Branches

Usa-se letras totalmente minúsculas, separando o tipo do assunto por uma barra (`/`) e substituindo os espaços por hífens (`-`).

```bash
# Exemplos práticos para o seu terminal:
git checkout -b feat/calculadora-bonus
git checkout -b docs/resumo-git-github
git checkout -b chore/configuracao-gitignore

```

### 3. Padrão de Nomenclatura para Títulos de PRs / Commits

Segue a estrutura rígida: `tipo: descrição curta em letras minúsculas`.

```text
// Exemplos de títulos para Pull Requests no GitHub ou mensagens de commit:
feat: implementada calculadora de bonus com scanner
docs: adicionadas anotacoes de operadores para o obsidian
fix: corrigido erro de compilacao na classe gerenciamento de risco

```

---

## Guia de Sobrevivência: Principais Comandos

### 1. Inicialização e Configuração (Feito uma vez por projeto)

* `git init` : Transforma a pasta atual do seu computador em um repositório do Git (cria a pasta oculta `.git`).
* `git remote add origin <URL>` : Conecta o seu Git local ao repositório criado no site do GitHub, apelidando o link do servidor de `origin`.

### 2. A Rotina Diária de Salvamento (O Feijão com Arroz do Dev)

Sempre execute estes três comandos nesta exata ordem para atualizar o seu GitHub:

```bash
git add .
git commit -m "feat: resolvido exercicio 3 de java"
git push origin main

```

* `git add .` : Adiciona **todos** os arquivos modificados e novos para a esteira (o ponto `.` significa "tudo desta pasta").
* `git commit -m "mensagem"` : Salva o pacote localmente e carimba com uma mensagem explicativa sobre o que você fez.
* `git push origin main` : Empurra os commits do seu computador para a branch principal (`main`) no GitHub.

### 3. Comandos de Diagnóstico (Para descobrir erros)

* `git status` : O comando mais importante. Mostra quais arquivos foram modificados, o que está na esteira e o que ainda não foi salvo.
* `git log` : Mostra o histórico de todos os commits já feitos no projeto, exibindo o autor, data e a mensagem.

---

## Glossário de Termos de Mercado

* **Repository (Repositório / Repo):** A pasta do seu projeto que está sendo monitorada pelo Git.
* **Commit:** Uma foto do estado do seu código em um determinado momento. É o "Save Game" do programador.
* **Branch (Ramificação):** Uma linha do tempo independente do seu código. A principal se chama `main`. Criar outra branch permite testar códigos sem estragar o projeto principal.
* **Pull Request (PR):** Um pedido formal (feito pelo site do GitHub) para que o dono do projeto junte (faça *Merge*) as alterações de uma branch secundária dentro da branch principal.
* **Merge:** O ato de fundir duas linhas do tempo (branches) diferentes em uma só.
* **Casting / Push Forçado (`--force`):** Um comando de segurança que ignora os avisos do GitHub e substitui todo o código do servidor pelo código que está na sua máquina local de forma definitiva.

---

## ⌨️ Atalho Mental de Resolução de Divergência

Se o seu terminal reclamar que o GitHub e o Computador estão com históricos diferentes (*divergent branches*), a configuração padrão para unificar os arquivos de forma segura através do terminal é:

```bash
git config pull.rebase false
git pull origin main --allow-unrelated-histories