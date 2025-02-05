public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = banco.criarCliente("Vitor");
        cliente1.getContaCorrente().depositar(2050);
        cliente1.getContaPoupanca().depositar(1200);

        cliente1.visualizarSaldo();

        try {
            cliente1.getContaCorrente().sacar(300);
            cliente1.getContaCorrente().transferir(cliente1.getContaPoupanca(), 5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cliente1.getContaPoupanca().aplicarRendimento();

        cliente1.visualizarSaldo();
    }
}