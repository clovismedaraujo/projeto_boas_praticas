package projeto_boas_praticas;


public abstract class Conta {
    private String numeroConta; 
    private Cliente cliente;
    protected double saldoConta; 
    private static final double SALDO_INICIAL_PADRAO = 0.0;

    public Conta(String numeroConta, Cliente cliente, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldoConta = saldoInicial;
    }

    public Conta(String numero, Cliente cliente) {
        this.numeroConta = numero;
        this.cliente = cliente;
        this.saldoConta = SALDO_INICIAL_PADRAO;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldoConta += valor;
        }
    }


    public boolean sacar(double valor) {
        if (valor > 0 && this.saldoConta >= valor) {
            this.saldoConta -= valor;
            return true;
        }
  
        return false;
    }

 


    public double getSaldoConta() {
        return saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public abstract String getTipoConta();

   
    @Override
    public String toString() {
        return String.format("Conta %s %s | Cliente: %s | Saldo: R$ %.2f",
                             getTipoConta(), numeroConta, cliente.getNomeCliente(), saldoConta);
    }
}