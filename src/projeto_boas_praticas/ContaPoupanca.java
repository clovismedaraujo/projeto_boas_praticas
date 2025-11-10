package projeto_boas_praticas;


public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroConta, Cliente cliente, double saldoInicial) {
        super(numeroConta, cliente, saldoInicial);
    }

    @Override
    public String getTipoConta() {
        return "Poupança"; 
    }

 
    
    public void aplicarRendimento(double percentual) {
        if (percentual > 0) {
            double rendimento = saldoConta * (percentual / 100.0);
            saldoConta += rendimento;
        }
    }
}