import java.util.ArrayList;
import java.util.List;
import java.lang.String;

class Cliente {
    private String nome;
    private String data_nasc;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome, String data_nasc) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    public String getNome() {
        return nome;
    }

    public String getData_Nasc() {
        return data_nasc;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void visualizarSaldo() {
        System.out.println("Saldo da Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo da Conta Poupança: " + contaPoupanca.getSaldo());
    }
}

    class Clientes {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente criarCliente(String nome, String data_nasc){
        Cliente cliente = new Cliente (nome, data_nasc);
     clientes.add(cliente);
     return cliente;
    }

    public Cliente buscarCliente(String nome){
        for (Cliente cliente : clientes){
            if (cliente.getNome().equalsIgnoreCase(nome)){
                return cliente;
            }
        }
        return null;
    }
    public void mostrarClientes(){
        if (clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado ainda.");
        }
        else {
            for (Cliente cliente : clientes){
                System.out.println("nome - " + cliente.getNome() + "\n Data de nascimento - " + cliente.getData_Nasc());
            }
        }
    }
    }
