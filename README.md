

Este projeto foi desenvolvido como um exercício prático focado na aplicação de **Boas Práticas de Programação** e **Orientação a Objetos (OO)** em Java. Ele simula funcionalidades básicas de um banco, como cadastro de clientes e contas, operações financeiras e relatórios.

### 👥 Integrantes da Equipe

* **Clóvis Luan Medeiros de Araújo** 
* **Matheus de Amorim Santana** 


---

### 📝 Sobre o Sistema

O Sistema é uma aplicação de console construída em Java que demonstra conceitos de **Herança**, **Abstração** e **Encapsulamento** para gerenciar contas bancárias.

#### **Funcionalidades Chave**

* **Cadastro:** Clientes e Contas.
* **Tipos de Conta:** Conta Corrente e Conta Poupança.
* **Operações:** Depósito, Saque e Transferência entre contas.
* **Lógica Específica:** Aplicação de rendimento para Contas Poupança.
* **Gerenciamento:** Listagem de contas ordenadas por saldo e geração de Relatório Consolidado.

#### **Estrutura de Classes (POO)**

| Classe | Descrição | Conceito Principal |
| :--- | :--- | :--- |
| `Conta` | Classe Abstrata, define operações comuns (depositar, sacar). | Abstração |
| `ContaCorrente` | Implementa a conta corrente. | Herança |
| `ContaPoupanca` | Implementa a conta poupança e inclui o método `aplicarRendimento`. | Herança e Polimorfismo |
| `Cliente` | Contém dados básicos do cliente (nome e CPF). | Encapsulamento |
| `GerenciadorBancario` | Gerencia coleções de contas e clientes, executa lógicas de negócio. | Controle/Serviço |
| `SistemaBancario` | Classe principal (`main`), executa a simulação. | Inicialização |

---

### ⚙️ Como Compilar o Sistema

O projeto é construído em Java puro e requer apenas o JDK para compilação e execução.

#### **Pré-requisitos**

* **Java Development Kit (JDK)**: Versão 8 ou superior.
* **Git**

#### **Instruções de Compilação (Terminal)**

1.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/clovismedaraujo/projeto_boas_praticas.git](https://github.com/clovismedaraujo/projeto_boas_praticas.git)
    cd projeto_boas_praticas
    ```

2.  **Compile os Arquivos:**
    O código está dentro do pacote `projeto_boas_praticas`. Você deve compilar a partir do diretório que contém a pasta `src`.
    ```bash
    # Se você estiver na raiz do projeto, navegue para o diretório "src"
    cd src
    
    # Execute a compilação de todas as classes do pacote
    javac projeto_boas_praticas/*.java
    ```
    *Isso gerará os arquivos `.class` dentro da pasta `projeto_boas_praticas` (dentro de `src`).*

---

### ▶️ Como Executar o Sistema

Após a compilação, o sistema é executado chamando a classe principal (`SistemaBancario`) através do comando `java`, especificando o pacote.

1.  **Navegue para o Diretório de Execução:**
    Certifique-se de que você está no diretório `src` (onde a pasta do pacote `projeto_boas_praticas` está visível).
    ```bash
    # Se você estiver em 'src/projeto_boas_praticas', volte um nível para 'src'
    cd ..
    ```

2.  **Execute a Classe Principal:**
    Execute a simulação do sistema:
    ```bash
    java projeto_boas_praticas.SistemaBancario
    ```

O sistema irá rodar a simulação de cadastro, operações e relatórios, exibindo os resultados diretamente no console.
