import java.util.Random;                                                                 //ContaBase com dados de cliente e de conta corrente e conta poupança.

abstract class ContaBase {
    protected double saldo;
    private static Random random = new Random();
    private int numeroConta;
    private String agencia;

    public ContaBase() {
       this.numeroConta = 1000 + random.nextInt(9000);
       this.agencia = String.format("%03d", random.nextInt(900));
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Saldo atual " + saldo);
        } else {
            System.out.println("Valor de depósito errado.");
        }
    }

    public void sacar(double valor) throws Exception {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Saldo atual " + saldo);
        } else {
            throw new Exception("Saldo insuficiente ou valor errado.");
        }
    }

    public void transferir(ContaBase contaDestino, double valor) throws Exception {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso.");
        } else {
            throw new Exception("Saldo insuficiente ou valor errado.");
        }
    }

    public void exibirDadosConta() {
        System.out.println("Agência - " + agencia);
        System.out.println("Número da Conta - " + numeroConta);
    }
}
