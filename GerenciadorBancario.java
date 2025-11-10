package projeto_boas_praticas;

import java.util.*;
import java.util.stream.Collectors;


public class GerenciadorBancario {
    private List<Cliente> clientes;
    private List<Conta> contas;
   

    public GerenciadorBancario() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }
    
 
    private boolean clienteExiste(String cpf) {
        return buscarCliente(cpf) != null;
    }
    
    public Cliente cadastrarCliente(String nome, String cpf) {
        
        
        if (clienteExiste(cpf)) { 
            System.out.println("Erro: Cliente com CPF " + cpf + " já cadastrado.");
            return null;
        }
        
        
        Cliente novoCliente = new Cliente(nome, cpf);
        clientes.add(novoCliente);
        return novoCliente;
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpfCliente().equals(cpf))
                .findFirst()
                .orElse(null);
    }
    
  
 
    private boolean contaExiste(String numero) {
        return buscarConta(numero) != null; 
    }
    
    private Conta criarNovaConta(String numero, Cliente cliente, double saldoInicial, String tipo) {
        if (tipo.equalsIgnoreCase("corrente")) {
            return new ContaCorrente(numero, cliente, saldoInicial);
        } 
        
        if (tipo.equalsIgnoreCase("poupanca")) {
            return new ContaPoupanca(numero, cliente, saldoInicial);
        } 
        
        throw new IllegalArgumentException("Tipo de conta inválido: " + tipo);
    }
    
    public Conta cadastrarConta(String numero, Cliente cliente, double saldoInicial, String tipo) {
        
        if (contaExiste(numero)) { 
            System.out.println("Erro: Conta número " + numero + " já existe.");
            return null;
        }

        try {
            Conta novaConta = criarNovaConta(numero, cliente, saldoInicial, tipo);
            
            contas.add(novaConta);
            return novaConta;
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar conta: " + e.getMessage());
            return null;
        }
    }

    public Conta buscarConta(String numero) {
        return contas.stream()
                .filter(c -> c.getNumeroConta().equals(numero))
                .findFirst()
                .orElse(null);
    }

    
    public boolean transferir(String contaOrigemNum, String contaDestinoNum, double valor) {
        Conta origem = buscarConta(contaOrigemNum);
        Conta destino = buscarConta(contaDestinoNum);

        if (origem == null || destino == null || valor <= 0) {
            return false;
        }

        if (origem.sacar(valor)) { 
            destino.depositar(valor); 
            return true;
        }
        return false; 
    }

    public List<ContaPoupanca> listarContasPoupanca() {
        List<ContaPoupanca> contasPoupanca = new ArrayList<>();
   
        for (Conta conta : this.contas) { 
            if (conta instanceof ContaPoupanca) {
                contasPoupanca.add((ContaPoupanca) conta); 
            }
        }
        
        return contasPoupanca;
    }
    
    public void aplicarRendimentoEmPoupanças(double percentual) {
        for (ContaPoupanca conta : listarContasPoupanca()) {
            conta.aplicarRendimento(percentual); 
        }
    }
    
    
    public List<Conta> listarContasPorSaldoDescendente() {
        return contas.stream()
            .sorted(Comparator.comparing(Conta::getSaldoConta).reversed()) 
            .collect(Collectors.toList());
    }

    public void gerarRelatorioConsolidado() {
        long totalContas = contas.size();
        double saldoTotal = contas.stream().mapToDouble(Conta::getSaldoConta).sum();

        System.out.println("\n--- Relatório de Consolidação ---");
        System.out.printf("Total de Contas Cadastradas: %d%n", totalContas);
        System.out.printf("Saldo Total do Banco: R$ %.2f%n", saldoTotal);  
        System.out.println("---------------------------------");

        Map<String, Double> saldoPorTipo = contas.stream()
            .collect(Collectors.groupingBy(
                Conta::getTipoConta,
                Collectors.summingDouble(Conta::getSaldoConta)
            ));
        
        System.out.println("Saldos por Tipo de Conta:");
        for (Map.Entry<String, Double> entry : saldoPorTipo.entrySet()) {
            long contasPorTipo = contas.stream().filter(c -> c.getTipoConta().equals(entry.getKey())).count();
            System.out.printf("- %s: %d contas | Saldo Total: R$ %.2f%n", 
                              entry.getKey(), contasPorTipo, entry.getValue());
        }
        System.out.println("---------------------------------");
    }
}