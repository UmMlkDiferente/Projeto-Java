import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clientes clientes = new Clientes();

        Cliente cliente1 = clientes.criarCliente("Vitor");
        Cliente cliente2 = clientes.criarCliente("Rodolfo");
        Cliente cliente3 = clientes.criarCliente("Andre");
        Cliente cliente4 = clientes.criarCliente("Jose");
        Cliente cliente5 = clientes.criarCliente("Ana Julia");
        cliente1.getContaCorrente().depositar(2050);
        cliente1.getContaPoupanca().depositar(1200);
        cliente2.getContaCorrente().depositar(1500);
        cliente2.getContaPoupanca().depositar(3000);
        cliente3.getContaPoupanca().depositar(2000);
        cliente3.getContaCorrente().depositar(2000);
        cliente4.getContaCorrente().depositar(1000);
        cliente4.getContaPoupanca().depositar(2000);
        cliente5.getContaPoupanca().depositar(1233);
        cliente5.getContaCorrente().depositar(3499);


        while (true) {
            System.out.println("Seja bem vindo, Escolha a opção que deseja ->");
            System.out.println("1 - Vizualizar saldo");
            System.out.println("2 - Fazer um deposito");
            System.out.println("3 - Fazer um saque");
            System.out.println("4 - Fazer uma transferencia");
            System.out.println("5 - Aplicar rendimento na Poupança");
            System.out.println("6 - Mostrar todos os clientes");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 7) {
                System.out.println("Agradeçemos por utilizar o nosso sistema bancario!");
                break;
            }

            System.out.println("Digite seu nome - ");
            String nome = scanner.nextLine();
            Cliente cliente = clientes.buscarCliente(nome);

            if (cliente == null) {
                System.out.println("Infelizmente não foi encontrado em nosso sistema.");
                continue;
            }
            switch (opcao) {
                case 1:
                    cliente.visualizarSaldo();
                    break;
                case 2:
                    System.out.println("\nEscolha a conta para depósito ");
                    System.out.println("1 - Conta Corrente ");
                    System.out.println("2 - Conta Poupança ");
                    int escolhaDeConta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o valor que você deseja depositar ");
                    double valorDeDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    if (escolhaDeConta == 1) {
                        cliente.getContaCorrente().depositar(valorDeDeposito);
                    } else if (escolhaDeConta == 2) {
                        cliente.getContaPoupanca().depositar(valorDeDeposito);
                    } else {
                        System.out.println("Algo não deu certo.");
                        continue;
                    }
                    System.out.println("Depósito realizado com sucesso.");
                    continue;
                case 3:
                    System.out.println("\nDigite de que conta você deseja sacar.");
                    System.out.println("1 - conta Corrente ");
                    System.out.println("2 - Conta Poupança ");
                    int escolhaDeSaque = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o valor de saque");
                    double valorDeSaque = scanner.nextDouble();
                    scanner.nextLine();

                    if (valorDeSaque > 2000){
                        System.out.println("O limite de saque diário é de 2000 reais.");
                        break;
                    }

                    try {
                        if (escolhaDeSaque == 1) {
                            cliente.getContaCorrente().sacar(valorDeSaque);
                        } else if (escolhaDeSaque == 2) {
                            cliente.getContaPoupanca().sacar(valorDeSaque);
                        } else {
                            System.out.println("Algo não deu certo.");
                            continue;
                        }
                        System.out.println("Saque realizado com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo, " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\nDigite o nome do destinatário ");
                    String nomeDoDestinatario = scanner.nextLine();
                    Cliente destinatario = clientes.buscarCliente(nomeDoDestinatario);


                    if (destinatario == null) {
                        System.out.println("Cliente não encontrado");
                        continue;
                    }

                    System.out.println("\nEscolha a conta de origem da transferência ");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeOrigem = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nEscolha a conta de destino da transferência ");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeDestino = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o valor da transferência ");
                    double valorDeTransferencia = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        if (escolhaDeOrigem == 1 && escolhaDeDestino == 1){
                            cliente.getContaCorrente().transferir(destinatario.getContaCorrente(), valorDeTransferencia);
                        } else if (escolhaDeOrigem == 1 && escolhaDeDestino == 2){
                            cliente.getContaCorrente().transferir(destinatario.getContaPoupanca(), valorDeTransferencia);
                        } else if (escolhaDeOrigem == 2 && escolhaDeDestino == 1){
                            cliente.getContaPoupanca().transferir(destinatario.getContaPoupanca(), valorDeTransferencia);
                        }else if (escolhaDeOrigem == 2 && escolhaDeDestino == 2) {
                            cliente.getContaPoupanca().transferir(destinatario.getContaPoupanca(), valorDeTransferencia);
                        } else {
                            System.out.println("Algo não deu certo");
                            continue;
                        }
                        System.out.println("Transferência realizada com sucesso.");
                    }
                    catch (Exception e) {
                        System.out.println("Algo não deu certo, " + e.getMessage());
                    }
                    break;
                case 5:
                    cliente.getContaPoupanca().aplicarRendimento();
                    System.out.println("Rendimento aplicado com sucesso.");
                    break;
                default:
                    System.out.println("Algo não deu certo");

                case 6:{
                    System.out.println("Esse são os clientes de nosso banco ->");
                    clientes.mostrarClientes();
                    break;
                }
            }
        }

        scanner.close();
    }

}