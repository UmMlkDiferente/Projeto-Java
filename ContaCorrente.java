class ContaCorrente extends ContaBase {
    private static final double LIMITE_SAQUE = 2000.0;

    @Override
    public void sacar(double valor) throws Exception {
        if (valor > LIMITE_SAQUE) {
            throw new Exception("O valor excede o limite de saque de " + LIMITE_SAQUE);
        }
        super.sacar(valor);
    }
}
