import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        Cliente cliente1 = banco.criarCliente("Vitor");
        Cliente cliente2 = banco.criarCliente("Rodolfo");
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

        // agr a transferencia entre eles...

        System.out.println("Compartilhamento entre clientes");
        System.out.println("Digite seu nome ");
        String nomeRem = scanner.nextLine();


        Cliente remetente = banco.buscarCliente(nomeRem);
        if (remetente == null){
            System.out.println("Cliente nao encontrado no momento.");
            return;
        }

        System.out.println("Para quem voce deseja fazer a transferencia?");
        String nomeDestinatario = scanner.nextLine();

        Cliente destinatario = banco.buscarCliente(nomeDestinatario);
        if (destinatario == null){
            System.out.println("CLiente não encontrado");
            return;
        }

        System.out.println("Digite seu valor da transferencia ");
        double valor = scanner.nextDouble();

        try {
            remetente.getContaCorrente().transferir(destinatario.getContaCorrente(), valor);
            System.out.println("Transferencia realizada!");
        } catch (Exception e) {
            System.out.println("Algo não deu certo: " + e.getMessage());
        }

        remetente.visualizarSaldo();
        destinatario.visualizarSaldo();

        scanner.close();
    }
}