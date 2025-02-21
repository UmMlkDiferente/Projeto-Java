class ContaPoupanca extends ContaBase {
    private static final double TAXA_RENDIMENTO = 0.03;

    public void aplicarRendimento() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        System.out.println("Rendimento de " + rendimento + " aplicado. Seu Saldo atual é de " + saldo);
    }
}
