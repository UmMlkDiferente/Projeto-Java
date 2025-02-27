import java.time.LocalDate;
import java.time.format.DateTimeFormatter;                                                                  //Criação de clientes com informações pessoais e criação de agencia e num de conta aleatorio.
import java.util.List;
import java.util.ArrayList;

class Cliente extends ContaBase {
    private String nome;
    private LocalDate data_nasc;
    private String CPF;
    private String endereco;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome, String data_nasc, String CPF, String endereco) {
        this.nome = nome;
        this.data_nasc = parseDatanascimento(data_nasc);
        this.CPF = CPF;
        this.endereco = endereco;
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    private LocalDate parseDatanascimento(String dataNasc) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataNasc, formatter);
        } catch (Exception e) {
            System.out.println("Algo não deu certo: " + e.getMessage());
            return null;
        }
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_Nasc() {
        return data_nasc;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEndereco() {
        return endereco;
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

    public Cliente criarCliente(String nome, String data_nasc, String cpf, String endereco) {
        Cliente cliente = new Cliente(nome, data_nasc, cpf, endereco);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado ainda.");
        } else {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Cliente cliente : clientes) {
                System.out.println("Nome - " + cliente.getNome());
                String dataNascCrt = cliente.getData_Nasc().format(format);
                System.out.println("Data de nascimento - " + dataNascCrt);
                System.out.println("CPF - " + cliente.getCPF());
                System.out.println("Endereço - " + cliente.getEndereco());
                System.out.println("Agência - " + cliente.getContaCorrente().getAgencia());
                System.out.println("Número de conta - " + cliente.getContaCorrente().getNumeroConta());
            }
        }
    }
}
