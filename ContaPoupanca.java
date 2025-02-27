import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ContaPoupanca extends ContaBase {
    private static final double TaxaRend = 0.03;
    private static final double LimiteSaque = 2000.0;
    private static final double PercenSaqueAniver = 30.0;
    private LocalDate dataAniversario;

    public ContaPoupanca() {
        this.dataAniversario = LocalDate.now();
    }

    public void aplicarRendimento() {                                                       //Aplicação de rendimento na conta poupança.
        double rendimento = saldo * TaxaRend;
        saldo += rendimento;
        System.out.println("Rendimento de " + rendimento + " aplicado. Seu saldo atual é de " + saldo);
    }

    public void sacar(double valor) throws Exception {                                          //Saque de dinheiro da conta poupança.
        if (valor > LimiteSaque) {
            throw new Exception("O valor excede o limite de saque de " + LimiteSaque);
        }
        super.sacar(valor);
    }

    public void depositar(double valor) {                                               //Deposito de dinheiro na conta poupança.
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
        } else {
            System.out.println("Algo não deu certo.");
        }
    }

    public void definirDataAniversario(String dataNasc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");                    //Data de aniversario formatada no formato dd/MM/yyyy - dia/mes/ano.
        this.dataAniversario = LocalDate.parse(dataNasc, formatter);
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void saqueAniversario(Cliente cliente) {

        LocalDate dataAtual = LocalDate.now();
        int mesAtual = dataAtual.getMonthValue();
        int mesAniver = cliente.getData_Nasc().getMonthValue();

        if (mesAtual == mesAniver) {                                                        //Saque aniversario no mes do aniversario do cliente.
            System.out.println("Saque aniversário permitido.");
            double valorSaque = saldo * PercenSaqueAniver / 100;
            saldo -= valorSaque;
            System.out.println("Você sacou " + valorSaque + "saldo atual " + saldo);
        } else {
            System.out.println("Não é o mês de aniversário. O saque aniversário não pode ser realizado.");
        }
    }
}


