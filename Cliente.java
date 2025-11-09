package projeto_boas_praticas;

public class Cliente {
    private String nomeCliente;
    private String cpfCliente; 

    public Cliente(String nomeCliente, String cpfCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    
    @Override
    public String toString() {
        return nomeCliente + " (CPF: " + cpfCliente + ")";
    }
}