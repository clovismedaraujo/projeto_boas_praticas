package projeto_boas_praticas;
import java.util.List;


public class SistemaBancario {

    public static void main(String[] args) {
        GerenciadorBancario banco = new GerenciadorBancario();

       
        System.out.println("--- 1. Cadastro de Clientes ---");
        Cliente cli1 = banco.cadastrarCliente("Alice Silva", "111");
        Cliente cli2 = banco.cadastrarCliente("Bruno Souza", "222");
        System.out.println("Clientes Cadastrados.");

        
        System.out.println("\n--- 2. Cadastro de Contas ---");
        Conta cc1 = banco.cadastrarConta("CC001", cli1, 1000.00, "corrente");
        Conta cp1 = banco.cadastrarConta("CP002", cli1, 5000.00, "poupanca");
        Conta cc2 = banco.cadastrarConta("CC003", cli2, 200.00, "corrente");
        
        
        banco.cadastrarConta("CC001", cli2, 50.00, "corrente"); 
        
        
        cc1.depositar(500.00);
        System.out.printf("\n--- 3. Depósito ---\nDepósito R$ 500,00 em CC001. Saldo: R$ %.2f\n", cc1.getSaldoConta());

        
        System.out.println("\n--- 4. Saque ---");
        cc1.sacar(200.00);
        System.out.printf("Saque R$ 200,00 em CC001. Saldo: R$ %.2f\n", cc1.getSaldoConta());

        boolean saqueFalha = cc2.sacar(300.00); 
        System.out.println("Tentativa de Saque R$ 300,00 em CC003. Sucesso: " + saqueFalha);

        
        System.out.println("\n--- 5. Transferência ---");
        boolean transferencia = banco.transferir("CC001", "CP002", 300.00); // [cite: 44]
        System.out.println("Transferência R$ 300,00 (CC001 -> CP002). Sucesso: " + transferencia);
        System.out.printf("Saldo CC001: R$ %.2f | Saldo CP002: R$ %.2f\n", cc1.getSaldoConta(), cp1.getSaldoConta());

        
        banco.aplicarRendimentoEmPoupanças(1.0); 
        System.out.printf("\n--- 7. Rendimento ---\nRendimento de 1%% aplicado. Novo Saldo CP002: R$ %.2f\n", cp1.getSaldoConta());

        
        List<Conta> contasOrdenadas = banco.listarContasPorSaldoDescendente(); 
        System.out.println("\n--- 8. Listagem de Contas (Saldo Descendente) ---");
        for (Conta c : contasOrdenadas) {
            System.out.println(c);
        }

        
        banco.gerarRelatorioConsolidado(); 
    }
}