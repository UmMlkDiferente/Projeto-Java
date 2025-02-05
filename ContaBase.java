abstract class ContaBase {
    protected double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
        } else {
            System.out.println("Valor de depósito errado.");
        }
    }

    public void sacar(double valor) throws Exception {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Saldo atual: " + saldo);
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
}
