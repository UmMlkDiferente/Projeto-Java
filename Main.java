import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        Cliente cliente1 = banco.criarCliente("Vitor");
        Cliente cliente2 = banco.criarCliente("Rodolfo");
        cliente1.getContaCorrente().depositar(2050);
        cliente1.getContaPoupanca().depositar(1200);

        while (true) {
            System.out.println("Seja bem vindo, Escolha a opção que deseja ->");
            System.out.println("1 - Vizualizar saldo");
            System.out.println("2 - Fazer um deposito");
            System.out.println("3 - Fazer um saque");
            System.out.println("4 - Fazer uma transferencia");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 5) {
                System.out.println("Agradeçemos por utilizar o nosso sistema bancario!");
                break;
            }

            System.out.println("Digite seu nome - ");
            String nome = scanner.nextLine();
            Cliente cliente = banco.buscarCliente(nome);

            if (cliente == null) {
                System.out.println("Infelizmente não foi encontrado em nosso sistema.");
                continue;
            }
            switch (opcao) {
                case 1:
                    cliente.visualizarSaldo();
                    break;
                case 2:
                    System.out.println("Digite o valor que você deseja depositar ");
                    double valorDeDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    cliente.getContaCorrente().depositar(valorDeDeposito);
                    System.out.println("Deposito realizado com sucesso");
                    break;
                case 3:
                    System.out.println("Digite o valor de saque ");
                    double valorDeSaque = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        cliente.getContaCorrente().sacar(valorDeSaque);
                        System.out.println("Saque realizado com sucesso");
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do destinatário ");
                    String nomeDoDestinatario = scanner.nextLine();
                    Cliente destinatario = banco.buscarCliente(nomeDoDestinatario);
                    if (destinatario == null) {
                        System.out.println("Cliente não encontrado");
                        continue;
                    }
                    System.out.println("Digite o valor que deseja transferir ");
                    double valorDeTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        cliente.getContaCorrente().transferir(destinatario.getContaCorrente(), valorDeTransferencia);
                        System.out.println("Transferência realizada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Algo não deu certo");
            }
        }

        scanner.close();
    }

}