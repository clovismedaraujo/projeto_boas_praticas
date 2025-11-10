package projeto_boas_praticas;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numeroConta, Cliente cliente, double saldoInicial) {
        super(numeroConta, cliente, saldoInicial);
    }

    @Override
    public String getTipoConta() {
        return "Corrente";
    }
}