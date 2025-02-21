class ContaCorrente extends ContaBase {
    private static final double LIMITE_SAQUE = 1500.0;

    @Override
    public void sacar(double valor) throws Exception {
        if (valor > LIMITE_SAQUE) {
            throw new Exception("O valor excede o limite de saque de " + LIMITE_SAQUE);
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
