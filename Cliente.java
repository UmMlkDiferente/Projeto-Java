import java.util.ArrayList;
import java.util.List;
import java.lang.String;

class Cliente {
    private String nome;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome) {
        this.nome = nome;
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    public String getNome() {
        return nome;
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
    public Cliente criarCliente(String nome){
        Cliente cliente = new Cliente (nome);
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
                System.out.println(cliente.getNome());
            }
        }
    }
    }
