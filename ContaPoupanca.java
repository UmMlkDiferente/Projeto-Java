class ContaPoupanca extends ContaBase {
    private static final double TAXA_RENDIMENTO = 0.03;

    public void aplicarRendimento() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        System.out.println("Rendimento de " + rendimento + " aplicado. Seu Saldo atual é de " + saldo);
    }
    private static final double LimiteDeSaque = 2000.0;
    public void sacar (double valor) throws Exception {
        if (valor > LimiteDeSaque) {
            throw new Exception("O valor excede o limite de saque de " + LimiteDeSaque);
        }
        super.sacar(valor);
    }
    public void depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de " + valor + " realizado. Saldo atual " + saldo);
        }
        else {
        System.out.println("Algo não deu certo");
        }
    }
}

