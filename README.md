Este projeto foi desenvolvido como um exercício prático focado na aplicação de Boas Práticas de Programação e Orientação a Objetos (OO) em Java.

Ele fornece funcionalidades básicas de um banco, como cadastro de clientes e contas, operações financeiras (depósito, saque, transferência) e relatórios de consolidação.

👥 Integrantes da Equipe
Clóvis Luan Medeiros de Araújo 

Matheus de Amorim Santana



📝 Sobre o Sistema
O Sistema Bancário Simples é uma aplicação de console (linha de comando) construída em Java.

O código é estruturado em diferentes classes (Cliente, Conta, GerenciadorBancario, etc.) para simular a lógica de um banco.

Arquitetura e Componentes Chave:

Cliente: Representa os dados básicos de um correntista (Nome e CPF).

Conta (Classe Abstrata): Define a estrutura e as operações comuns (sacar, depositar, saldo) para todos os tipos de conta.

ContaCorrente e ContaPoupanca: Herdam de Conta e implementam lógicas específicas (ex: ContaPoupanca possui o método aplicarRendimento).

GerenciadorBancario: Gerencia as coleções de clientes e contas, e executa lógicas de alto nível (cadastro, busca, transferência, relatórios).

SistemaBancario (Classe Principal): Contém o método main e simula a execução das funcionalidades do banco.

Tecnologias Utilizadas:

Linguagem de Programação: Java

Paradigma: Programação Orientada a Objetos (POO)

Estrutura de Dados: List (ArrayList) para armazenar clientes e contas.

⚙️ Como Compilar o Sistema
Para compilar e executar o projeto, é necessário ter o ambiente Java configurado em sua máquina.

Pré-requisitos
Java Development Kit (JDK): Versão 8 ou superior.

Instruções de Compilação

Clone o Repositório: Abra seu terminal/prompt de comando e clone o projeto:


git clone https://github.com/clovismedaraujo/projeto_boas_praticas.git
cd projeto_boas_praticas

Navegue para a Raiz do Pacote: Entre no diretório onde estão os arquivos .java:


cd src/projeto_boas_praticas
Compile os Arquivos: Execute o comando javac para compilar todas as classes:

javac *.java
Isso gerará os arquivos .class correspondentes no mesmo diretório.

▶️ Como Executar o Sistema
Após a compilação, o sistema pode ser executado a partir da classe principal SistemaBancario.

Garanta a Posição no Diretório: Você deve estar no diretório que contém a pasta principal do pacote (src se for um IDE, ou a pasta do projeto se for via terminal). A maneira mais simples é executar a partir do nível superior onde a pasta projeto_boas_praticas está:


 Se você ainda estiver em 'src/projeto_boas_praticas', volte para 'src'
cd ../ 
Execute a Classe Principal: Utilize o comando java, especificando a classe que contém o método main (incluindo o nome do pacote):


java projeto_boas_praticas.SistemaBancario
O resultado será a execução da simulação de operações bancárias definida no método main, exibindo o fluxo e o relatório consolidado no console.
