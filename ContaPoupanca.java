class ContaPoupanca extends ContaBase {
    private static final double TAXA_RENDIMENTO = 0.03; // 2% ao mês

    public void aplicarRendimento() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        System.out.println("Rendimento de " + rendimento + " aplicado. Saldo atual: " + saldo);
    }
}

