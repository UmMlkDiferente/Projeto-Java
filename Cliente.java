class Cliente {
    private final String nome;
    private final ContaCorrente contaCorrente;
    private final ContaPoupanca contaPoupanca;

    public Cliente(String nome) {
        this.nome = nome;
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    public String getNome() {
        return nome;
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
