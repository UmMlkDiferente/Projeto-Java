class ContaCorrente extends ContaBase {
    private static final double LimiteSaque = 2000.0;

    public void sacar(double valor) throws Exception {

        if (valor > LimiteSaque) {
            throw new Exception("O valor excede o limite de saque de " + LimiteSaque);
        }
        super.sacar(valor);
    }
    public void depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de " + valor + "realizado. Saldo atual é de " + saldo);
        }
        else {
            System.out.println("Algo não deu certo.");
        }
    }
}
